package com.tkachev.simpleblog.dto.mappers;

import com.tkachev.simpleblog.dto.article.ArticleResponse;
import com.tkachev.simpleblog.dto.article.CreateArticleRequest;
import com.tkachev.simpleblog.dto.article.UpdateArticleRequest;
import com.tkachev.simpleblog.entity.Article;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ArticleMapper {
    Article toArticle(CreateArticleRequest createArticleRequest);

    ArticleResponse toArticleResponse(Article article);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Article updateArticle(UpdateArticleRequest updateArticleRequest, @MappingTarget Article article);
}
