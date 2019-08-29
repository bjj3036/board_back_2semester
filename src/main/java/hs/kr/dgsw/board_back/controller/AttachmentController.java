package hs.kr.dgsw.board_back.controller;

import hs.kr.dgsw.board_back.domain.Attach;
import hs.kr.dgsw.board_back.service.AttachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@RestController
public class AttachmentController {

    @Autowired
    private AttachService attachService;

    @PostMapping("/image/upload")
    public Long upload(@RequestPart MultipartFile srcFile) {
        try {
            String destFilename
                    = "C:/Users/baejunjae/IdeaProjects/SecondSemesterBoard/board_back/upload/"
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS_"))
                    + srcFile.getOriginalFilename();
            File destFile = new File(destFilename);
            destFile.getParentFile().mkdirs();
            srcFile.transferTo(destFile);
            Attach attach = new Attach(srcFile.getOriginalFilename(), destFilename);
            return attachService.add(attach);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return -1L;
    }

    @GetMapping("/image/{id}")
    public void image(@PathVariable Long id, HttpServletResponse response) {
        try {
            HashMap map = this.attachService.findById(id);
            String filename = (String) map.get("filename");
            String filepath = (String) map.get("filepath");

            File file = new File(filepath);
            if (!file.exists()) return;

            String mimeType = URLConnection.guessContentTypeFromName(filepath);
            if (mimeType == null) mimeType = "application/octet-stream";

            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", "inline; filename='" + filename + "'");
            response.setContentLength((int) file.length());

            InputStream is = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(is, response.getOutputStream());
        } catch (Exception ex) {
            final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
            logger.warn(ex.getLocalizedMessage());
        }

    }
}
