package com.tkachev.simpleblog.rest;

import com.tkachev.simpleblog.dto.image.UploadFileResponse;
import com.tkachev.simpleblog.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<UploadFileResponse> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        UploadFileResponse uploadImage = imageService.uploadImage(file);

        return new ResponseEntity<>(uploadImage, HttpStatus.CREATED);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable(name = "fileName") String fileName) throws IOException {
        byte[] imageData = imageService.downloadImage(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
