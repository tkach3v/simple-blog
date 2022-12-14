package com.tkachev.simpleblog.dto.category;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
public class CreateCategoryRequest implements Serializable {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String imageUri;
    private List<ArticleResponse> articles;
}