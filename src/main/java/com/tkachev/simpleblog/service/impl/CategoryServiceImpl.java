package com.tkachev.simpleblog.service.impl;

import com.tkachev.simpleblog.dto.category.CategoryResponse;
import com.tkachev.simpleblog.dto.category.CreateCategoryRequest;
import com.tkachev.simpleblog.dto.category.UpdateCategoryRequest;
import com.tkachev.simpleblog.dto.mappers.CategoryMapper;
import com.tkachev.simpleblog.entity.Category;
import com.tkachev.simpleblog.repository.CategoryRepository;
import com.tkachev.simpleblog.service.AbstractService;
import com.tkachev.simpleblog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends AbstractService<String> implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest dto) {
        Category category = mapper.toCategory(dto);
        categoryRepository.save(category);

        return mapper.toCategoryResponse(category);
    }

    @Override
    public void deleteCategory(String id) {
        Category category = categoryRepository.findById(id).orElse(null);
        category = isNotNull(category, "Category", id);
        categoryRepository.delete(category);
    }

    @Override
    public CategoryResponse updateCategory(UpdateCategoryRequest dto) {
        Category category = categoryRepository.findById(dto.getId()).orElse(null);
        category = isNotNull(category, "Category", dto.getId());
        mapper.updateCategory(dto, category);
        categoryRepository.save(category);

        return mapper.toCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> getCategories() {
        return categoryRepository.findAll().
                stream().
                map(mapper::toCategoryResponse).
                toList();
    }

    @Override
    public CategoryResponse getCategoryById(String id) {
        Category category = categoryRepository.findById(id).orElse(null);
        category = isNotNull(category, "Category", id);

        return mapper.toCategoryResponse(category);
    }
}
