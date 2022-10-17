package com.tkachev.simpleblog.dto.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tkachev.simpleblog.entity.ArticleStatus;
import com.tkachev.simpleblog.utils.DateFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ArticleResponse implements Serializable {
    private String id;
    private String title;
    private String description;
    private ArticleStatus status;
    private String imageUri;
    private String categoryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormat.DD_MM_YYYY)
    private Date creationDate;
    private List<String> tags;
}