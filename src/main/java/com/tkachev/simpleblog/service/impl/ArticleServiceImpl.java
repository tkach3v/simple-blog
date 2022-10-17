package com.tkachev.simpleblog.service.impl;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import com.tkachev.simpleblog.dto.article.CreateArticleRequest;
import com.tkachev.simpleblog.dto.article.UpdateArticleRequest;
import com.tkachev.simpleblog.dto.mappers.ArticleMapper;
import com.tkachev.simpleblog.entity.Category;
import com.tkachev.simpleblog.repository.CategoryRepository;
import com.tkachev.simpleblog.service.AbstractService;
import com.tkachev.simpleblog.service.ArticleService;
import com.tkachev.simpleblog.entity.Article;
import com.tkachev.simpleblog.entity.ArticleStatus;
import com.tkachev.simpleblog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends AbstractService<String> implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final ArticleMapper mapper;

    @Override
    public ArticleResponse createArticle(CreateArticleRequest dto) {
        Article article = mapper.toArticle(dto);
        article.setStatus(Objects.requireNonNullElse(article.getStatus(), ArticleStatus.ON_MODERATION));
        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        isNotNull(category, "Category", dto.getCategoryId());
        category.linkArticle(article);
        articleRepository.save(article);
        categoryRepository.save(category);

        return mapper.toArticleResponse(article);
    }

    @Override
    public void deleteArticle(String id) {
        Article article = articleRepository.findById(id).orElse(null);
        article = isNotNull(article, "Article", id);
        articleRepository.delete(article);
    }

    @Override
    public ArticleResponse updateArticle(UpdateArticleRequest dto) {
        Article article = articleRepository.findById(dto.getId()).orElse(null);
        article = isNotNull(article, "Article", dto.getId());
        mapper.updateArticle(dto, article);
        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        isNotNull(category, "Category", dto.getCategoryId());
        articleRepository.save(article);

        return mapper.toArticleResponse(article);
    }

    @Override
    public List<ArticleResponse> getArticles() {
        return articleRepository.findAll().
                stream().
                map(mapper::toArticleResponse).
                toList();
    }

    @Override
    public ArticleResponse getArticleById(String id) {
        Article article = articleRepository.findById(id).orElse(null);
        article = isNotNull(article, "Article", id);

        return mapper.toArticleResponse(article);
    }
}
