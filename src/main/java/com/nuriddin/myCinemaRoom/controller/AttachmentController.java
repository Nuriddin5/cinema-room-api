package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 09.03.2022;

import com.nuriddin.myCinemaRoom.entity.Attachment;
import com.nuriddin.myCinemaRoom.entity.AttachmentContent;
import com.nuriddin.myCinemaRoom.repository.AttConRepo;
import com.nuriddin.myCinemaRoom.repository.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping( "api/attachment")
public class AttachmentController {

//    private static final String path1 = "C:\\Users\\zuxra\\Desktop\\JavaAllCodes\\40 InshaAlloh\\Spring learning 1h\\demo\\src\\main\\resources\\uploads\\";


    @Autowired
    AttachmentRepo attachmentRepo;
    @Autowired
    AttConRepo attConRepo;

    @PostMapping("/upload")
    public String uploadFile(MultipartHttpServletRequest request) throws IOException {

        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        assert file != null;
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        String contentType = file.getContentType();
        Attachment attachment = new Attachment();
        attachment.setFileOriginalName(originalFilename);
        attachment.setSize(size);
        attachment.setContentType(contentType);
        assert originalFilename != null;
        String[] split = originalFilename.split("\\.");
        String name = UUID.randomUUID().toString() + "." + split[split.length - 1];
        attachment.setUniqueName(name);
        Attachment saveAttachment = attachmentRepo.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setContent(file.getBytes());
        attachmentContent.setAttachment(saveAttachment);
        AttachmentContent saveCon = attConRepo.save(attachmentContent);
        return "Saved id" + saveAttachment.getId() + " and conId " + saveCon.getId();


    }
//
//    @PostMapping("/upload1")
//    public String uploadFileToSystem(MultipartHttpServletRequest request) throws IOException {
//        Iterator<String> fileNames = request.getFileNames();
//        MultipartFile file = request.getFile(fileNames.next());
//        Attachment attachment = new Attachment();
//        assert file != null;
//        String originalFilename = file.getOriginalFilename();
//        attachment.setFileOriginalName(originalFilename);
//        attachment.setSize(file.getSize());
//        attachment.setContentType(file.getContentType());
//        attachment.setContentType(attachment.getContentType());
//        assert originalFilename != null;
//        String[] split = originalFilename.split("\\.");
//        String name = UUID.randomUUID().toString() + "." + split[split.length - 1];
//        attachment.setUniqueName(name);
//        attachmentRepo.save(attachment);
//        Path path = Paths.get(path1 + name);
//        Files.copy(file.getInputStream(), path);
//        return "saved file with id: " + attachment.getId();
//
//    }

    @GetMapping("/getFile/{id}")
    public void getFile(@PathVariable String id, HttpServletResponse response) throws IOException {


        Optional<Attachment> attachmentOptional = attachmentRepo.findById(Long.valueOf(id));
        if (attachmentOptional.isPresent()) {
            Attachment attachment = attachmentOptional.get();
            Optional<AttachmentContent> optionalAttachmentContent = attConRepo.findByAttachmentId(Long.valueOf(id));
            if (optionalAttachmentContent.isPresent()) {
                AttachmentContent attachmentContent = optionalAttachmentContent.get();
//                response.setHeader("Content-Disposition", "attachment; filename\"" + attachment.getFileOriginalName() + "\"");
                response.setHeader("Content-Disposition", "attachment; filename=" + attachment.getFileOriginalName());
                response.setHeader("Content-Transfer-Encoding", "binary");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachmentContent.getContent(), response.getOutputStream());
            }

        }

    }

//    @GetMapping("/getFile1/{id}")
//    public void getFile1(@PathVariable Long id, HttpServletResponse response) throws IOException {
//        Optional<Attachment> optionalAttachment = attachmentRepo.findById(id);
//        if (optionalAttachment.isPresent()) {
//            Attachment attachment = optionalAttachment.get();
////            response.setHeader("Content-Disposition", "attachment; filename\"" + attachment.getFileOriginalName() + "\"");
//            response.setHeader("Content-Disposition", "attachment; filename=" + attachment.getFileOriginalName());
//            response.setHeader("Content-Transfer-Encoding", "binary");
//            response.setContentType(attachment.getContentType());
//
//            FileInputStream fileInputStream = new FileInputStream(path1+"/"+attachment.getUniqueName());
//            FileCopyUtils.copy(fileInputStream, response.getOutputStream());
//        }
//    }
}
