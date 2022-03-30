package com.nuriddin.myCinemaRoom.controller;


// t.me/superJavaDeveloper 09.03.2022;

import com.nuriddin.myCinemaRoom.entity.Attachment;
import com.nuriddin.myCinemaRoom.entity.AttachmentContent;
import com.nuriddin.myCinemaRoom.repository.AttConRepo;
import com.nuriddin.myCinemaRoom.repository.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
@RequestMapping("api/attachment")
public class AttachmentController {


    AttachmentRepo attachmentRepo;

    AttConRepo attConRepo;

    public AttachmentController(AttConRepo attConRepo) {
        this.attConRepo = attConRepo;
    }

    @Autowired
    public AttachmentController(AttachmentRepo attachmentRepo) {
        this.attachmentRepo = attachmentRepo;
    }

    @GetMapping("/getFile")
    public HttpEntity<?> getFile() {
        return new HttpEntity<>(attachmentRepo.findAll());
    }

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
        String name = UUID.randomUUID() + "." + split[split.length - 1];
        attachment.setUniqueName(name);
        Attachment saveAttachment = attachmentRepo.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setContent(file.getBytes());
        attachmentContent.setAttachment(saveAttachment);
        AttachmentContent saveCon = attConRepo.save(attachmentContent);
        return "Saved id" + saveAttachment.getId() + " and conId " + saveCon.getId();


    }

    @GetMapping("/getFile/{id}")
    public void getFile(@PathVariable String id, HttpServletResponse response) throws IOException {


        Optional<Attachment> attachmentOptional = attachmentRepo.findById(Long.valueOf(id));
        if (attachmentOptional.isPresent()) {
            Attachment attachment = attachmentOptional.get();
            Optional<AttachmentContent> optionalAttachmentContent = attConRepo.findByAttachmentId(Long.valueOf(id));
            if (optionalAttachmentContent.isPresent()) {
                AttachmentContent attachmentContent = optionalAttachmentContent.get();
                response.setHeader("Content-Disposition", "attachment; filename=" + attachment.getFileOriginalName());
                response.setHeader("Content-Transfer-Encoding", "binary");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachmentContent.getContent(), response.getOutputStream());
            }

        }

    }

    @DeleteMapping("/deleteFile/{id}")
    public HttpEntity<?> deleteAttachment(@PathVariable Long id) {

        Optional<AttachmentContent> byAttachmentId = attConRepo.findByAttachmentId(id);
        if (byAttachmentId.isPresent()) {
            AttachmentContent attachmentContent = byAttachmentId.get();
            attConRepo.delete(attachmentContent);
        }
        attachmentRepo.deleteById(id);
        return new HttpEntity<>("Deleted");
    }

}
