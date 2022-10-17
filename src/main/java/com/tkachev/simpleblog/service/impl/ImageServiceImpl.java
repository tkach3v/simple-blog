package com.tkachev.simpleblog.service.impl;

import com.tkachev.simpleblog.dto.image.UploadFileResponse;
import com.tkachev.simpleblog.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

@Service
public class ImageServiceImpl implements ImageService {

    private static final String FOLDER_PATH = "src/main/resources/static/images/";

    @Override
    public UploadFileResponse uploadImage(MultipartFile file) throws IOException {
        String filePath = getFilePath(file.getOriginalFilename());

        file.transferTo(new File(filePath));

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/images/")
                .path(Objects.requireNonNull(file.getOriginalFilename()))
                .toUriString();

        return new UploadFileResponse(file.getOriginalFilename(), fileDownloadUri, file.getSize());
    }

    @Override
    public byte[] downloadImage(String fileName) throws IOException {
        String filePath = getFilePath(fileName);

        return Files.readAllBytes(new File(filePath).toPath());
    }

    private static String getFilePath(String fileName) {
        File folder = new File(FOLDER_PATH);
        String absolutePath = folder.getAbsolutePath() + '/';
        return absolutePath + fileName;
    }
}
