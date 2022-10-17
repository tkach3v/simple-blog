package com.tkachev.simpleblog.rest;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import com.tkachev.simpleblog.dto.article.CreateArticleRequest;
import com.tkachev.simpleblog.dto.article.UpdateArticleRequest;
import com.tkachev.simpleblog.dto.category.CategoryResponse;
import com.tkachev.simpleblog.dto.category.CreateCategoryRequest;
import com.tkachev.simpleblog.dto.category.UpdateCategoryRequest;
import com.tkachev.simpleblog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getArticles() {
        List<ArticleResponse> articles = articleService.getArticles();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(@Valid @RequestBody CreateArticleRequest dto) {
        ArticleResponse article = articleService.createArticle(dto);

        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticleById(@PathVariable(name = "id") String id) {
        ArticleResponse article = articleService.getArticleById(id);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ArticleResponse> updateArticle(@Valid @RequestBody UpdateArticleRequest dto) {
        ArticleResponse article = articleService.updateArticle(dto);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);

        return new ResponseEntity<>("Article with ID = " + id + " has been deleted", HttpStatus.NO_CONTENT);
    }
}
