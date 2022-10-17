package com.tkachev.simpleblog.repository;

import com.tkachev.simpleblog.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}
