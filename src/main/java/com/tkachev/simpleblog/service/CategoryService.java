package com.tkachev.simpleblog.service;

import com.tkachev.simpleblog.dto.category.CategoryResponse;
import com.tkachev.simpleblog.dto.category.CreateCategoryRequest;
import com.tkachev.simpleblog.dto.category.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CreateCategoryRequest dto);

    void deleteCategory(String id);

    CategoryResponse updateCategory(UpdateCategoryRequest dto);

    List<CategoryResponse> getCategories();

    CategoryResponse getCategoryById(String id);
}
