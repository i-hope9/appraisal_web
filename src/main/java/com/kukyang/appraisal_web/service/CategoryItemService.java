package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.category.CategoryItemDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryItemService {

    /* Create */
    @Transactional
    CategoryItem saveCategoryItem(CategoryItemDto categoryItemDto);

    /* Read */
    @Transactional
    CategoryItem findCategoryItemById(Long id);

    @Transactional
    List<CategoryItem> findCategoryItemsByCategoryId(Long id);

    @Transactional
    List<CategoryItem> findEnabledCategoryItemsByCategoryId(Long id);

    /* Update */
    @Transactional
    CategoryItem updateCategoryItem(Long id, CategoryItemDto categoryItemDto);

    @Transactional
    CategoryItem updateCategoryItemStatus(Long id, StatusEnum status);

}
