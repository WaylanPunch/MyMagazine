package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.pojo.Article;
import com.waylanpunch.mymagazine.pojo.Attachment;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface IAttachmentService {

    List<Attachment> findAllAttachments();

    void init();

    String store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    int addAttachment(Attachment attachment);

}
