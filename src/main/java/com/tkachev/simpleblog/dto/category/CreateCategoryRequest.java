package com.tkachev.simpleblog.dto.category;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import com.tkachev.simpleblog.entity.Article;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class CreateCategoryRequest implements Serializable {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private List<ArticleResponse> articles;
}