package com.tkachev.simpleblog.service;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import com.tkachev.simpleblog.dto.article.CreateArticleRequest;
import com.tkachev.simpleblog.dto.article.UpdateArticleRequest;

import java.util.List;

public interface ArticleService {

    ArticleResponse createArticle(CreateArticleRequest dto);

    void deleteArticle(String id);

    ArticleResponse updateArticle(UpdateArticleRequest dto);

    List<ArticleResponse> getArticles();

    ArticleResponse getArticleById(String id);
}
