package com.tkachev.simpleblog.repository;

import com.tkachev.simpleblog.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String > {
}
