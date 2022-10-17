package com.tkachev.simpleblog.dto.category;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import com.tkachev.simpleblog.entity.Article;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryResponse implements Serializable {
    private String id;
    private String title;
    private String description;
    private List<ArticleResponse> articles;
}