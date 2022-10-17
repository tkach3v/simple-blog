package com.tkachev.simpleblog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document("category")
public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private String imageUri;
    @DBRef
    private List<Article> articles;

    public void linkArticle(Article article) {
        if (article == null) {
            return;
        }

        if (articles == null) {
            articles = new ArrayList<>();
        }

        articles.add(article);
    }
}
