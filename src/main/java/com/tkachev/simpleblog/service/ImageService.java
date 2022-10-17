package com.tkachev.simpleblog.service;

import com.tkachev.simpleblog.dto.image.UploadFileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    UploadFileResponse uploadImage(MultipartFile file) throws IOException;

    byte[] downloadImage(String fileName) throws IOException;
}
