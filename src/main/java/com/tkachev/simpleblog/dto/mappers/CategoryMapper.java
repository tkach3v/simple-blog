package com.tkachev.simpleblog.dto.mappers;

import com.tkachev.simpleblog.dto.category.CategoryResponse;
import com.tkachev.simpleblog.dto.category.CreateCategoryRequest;
import com.tkachev.simpleblog.dto.category.UpdateCategoryRequest;
import com.tkachev.simpleblog.entity.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        uses = {ArticleMapper.class})
public interface CategoryMapper {
    Category toCategory(CreateCategoryRequest createCategoryRequest);

    CategoryResponse toCategoryResponse(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategory(UpdateCategoryRequest updateCategoryRequest, @MappingTarget Category category);
}
