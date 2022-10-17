package com.tkachev.simpleblog.dto.image;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UploadFileResponse implements Serializable {
    private String fileName;
    private String fileDownloadUri;
    private long size;
}
