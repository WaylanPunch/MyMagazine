package com.waylanpunch.mymagazine.controller.admin;

import java.io.IOException;
import java.util.Date;

import com.waylanpunch.mymagazine.model.ReturnResult;
import com.waylanpunch.mymagazine.pojo.Attachment;
import com.waylanpunch.mymagazine.service.IAttachmentService;
import com.waylanpunch.mymagazine.util.MagazineException;
import com.waylanpunch.mymagazine.util.ReturnResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/15 0:51
 * <p>
 * 文件上传功能：https://spring.io/guides/gs/uploading-files/
 */
@Controller
@RequestMapping("/admin/attachment")
public class AttachmentController {
    private final static Logger logger = LoggerFactory.getLogger(AttachmentController.class);
    @Autowired
    private IAttachmentService attachmentService;


    @GetMapping
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("attachments", attachmentService.findAllAttachments());

        /*
        model.addAttribute("files", attachmentService.
                loadAll().
                map(path -> MvcUriComponentsBuilder.
                        fromMethodName(AttachmentController.class, "serveFile", path.getFileName().toString())
                        .build()
                        .toString())
                .collect(Collectors.toList()));
          */
        return "admin/attachment";
    }

    /**
     * 下载
     *
     * @param filename
     * @return
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = attachmentService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    /**
     * Upload Form
     *
     * @return
     */
    @GetMapping("/upload")
    public String fileUploadForm() {
        logger.info("AttachmentController->fileUploadForm");
        return "admin/attachmentUpload";
    }

    /**
     * Upload Action
     * https://blog.csdn.net/gnail_oug/article/details/80324120
     * https://blog.csdn.net/Yaphst/article/details/82625159
     *
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public ReturnResult<Object> handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        logger.info("AttachmentController->handleFileUpload");
        String ERROR_MESSAGE = "You are failed to upload " + file.getOriginalFilename() + "!";
        String OK_MESSAGE = "You successfully uploaded " + file.getOriginalFilename() + "!";
        ///*
        try {
            String filename = attachmentService.store(file);
            attachmentService.addAttachment(new Attachment(null, filename, file.getContentType(), "/admin/attachment/files/" + filename, 1, new Date()));
            //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        } catch (MagazineException ex) {
            logger.info("AttachmentController->handleFileUpload", ex);
            return ReturnResultUtil.error(HttpStatus.BAD_REQUEST.value(), ERROR_MESSAGE);
        }
        return ReturnResultUtil.sucess(HttpStatus.OK.value(), OK_MESSAGE);
        //return "redirect:/admin/attachment";
        //return "You successfully uploaded " + file.getOriginalFilename() + "!";
        //return ResponseEntity.status(HttpStatus.OK).body("You successfully uploaded " + file.getOriginalFilename() + "!");
        //*/

        //return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You are failed to upload " + file.getOriginalFilename() + "!");
        //return ResponseEntity.status(HttpStatus.OK).body("You successfully uploaded " + file.getOriginalFilename() + "!");



        //return new ResponseEntity<>(ERROR_MESSAGE, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MagazineException.class)
    public ResponseEntity<?> handleStorageFileNotFound(MagazineException exc) {
        return ResponseEntity.notFound().build();
    }
}
