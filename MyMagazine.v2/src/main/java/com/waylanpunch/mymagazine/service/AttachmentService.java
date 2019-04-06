package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.AttachmentMapper;
import com.waylanpunch.mymagazine.pojo.Attachment;
import com.waylanpunch.mymagazine.pojo.AttachmentExample;
import com.waylanpunch.mymagazine.util.MagazineException;
import com.waylanpunch.mymagazine.util.AttachmentStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/16 17:07
 */
@Service
public class AttachmentService implements IAttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    private final Path rootLocation;

    @Autowired
    public AttachmentService(AttachmentStorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public List<Attachment> findAllAttachments() {
        AttachmentExample attachmentExample = new AttachmentExample();
        AttachmentExample.Criteria criteria = attachmentExample.createCriteria();
        criteria.andAttachmentIdIsNotNull();
        return attachmentMapper.selectByExample(attachmentExample);
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new MagazineException(HttpStatus.BAD_REQUEST.value(), "Could not initialize storage");
        }
    }

    @Override
    public String store(MultipartFile file) {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String newFilename = UUID.randomUUID().toString() + "=" + originalFilename;
        System.out.println("newFilename:" + newFilename);
        try {
            if (file.isEmpty()) {
                throw new MagazineException(HttpStatus.BAD_REQUEST.value(), "Failed to store empty file " + originalFilename);
            }
            if (originalFilename.contains("..")) {
                // This is a security check
                throw new MagazineException(HttpStatus.BAD_REQUEST.value(), "Cannot store file with relative path outside current directory " + originalFilename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(newFilename), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            newFilename = null;
            throw new MagazineException(HttpStatus.BAD_REQUEST.value(), "Failed to store file " + originalFilename);
        }
        return newFilename;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new MagazineException(HttpStatus.BAD_REQUEST.value(), "Failed to read stored files");
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new MagazineException(HttpStatus.BAD_REQUEST.value(), "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new MagazineException(HttpStatus.BAD_REQUEST.value(), "Could not read file: " + filename);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public int addAttachment(Attachment attachment) {
        return attachmentMapper.insertSelective(attachment);
    }
}
