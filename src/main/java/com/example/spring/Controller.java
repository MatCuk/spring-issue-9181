package com.example.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/upload",
            produces = {"text/plain"},
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    public ResponseEntity<String> saveKycDocument(@Valid @RequestPart(value = "file") MultipartFile file) {
        final String filename = file.getOriginalFilename();
        if (filename == null) {
            throw new IllegalArgumentException("provide file");
        }
        logger.info("upload {}", filename);
        return ResponseEntity.ok(filename);
    }
}
