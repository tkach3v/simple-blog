package com.tkachev.simpleblog.dto.category;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryResponse implements Serializable {
    private String id;
    private String title;
    private String description;
    private String imageUri;
    private List<ArticleResponse> articles;
}