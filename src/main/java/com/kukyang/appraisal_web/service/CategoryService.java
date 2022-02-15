package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Category;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.CategoryDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryService {

    /* Create */
    @Transactional
    Category saveCategory(CategoryDto categoryDto);

    /* Read */
    @Transactional
    Category findCategoryById(Long id);

    @Transactional
    List<Category> findAllCategories();

    @Transactional
    List<Category> findAllEnabledCategories();

    /* Update */
    @Transactional
    Category updateCategory(Long id, CategoryDto categoryDto);

    @Transactional
    Category updateCategoryStatus(Long id, StatusEnum status);

}
