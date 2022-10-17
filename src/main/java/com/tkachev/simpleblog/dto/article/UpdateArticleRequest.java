package com.tkachev.simpleblog.dto.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tkachev.simpleblog.entity.ArticleStatus;
import com.tkachev.simpleblog.utils.DateFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UpdateArticleRequest implements Serializable {
    @NotBlank
    private String id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private ArticleStatus status;
    @NotBlank
    private String imageUri;
    @NotBlank
    private String categoryId;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormat.DD_MM_YYYY)
    private Date creationDate;
    private List<String> tags;
}