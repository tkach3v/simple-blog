package com.tkachev.simpleblog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document("article ")
public class Article {
    @Id
    private String id;
    private String title;
    private String description;
    private ArticleStatus status;
    private String imageUri;
    private String categoryId;
    private Date creationDate;
    private List<String> tags;
}
