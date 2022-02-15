package com.kukyang.appraisal_web.domain.repository;

import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryItemRepository extends JpaRepository<CategoryItem, Long> {
    List<CategoryItem> findByCategoryIdAndStatusNot(Long categoryId, StatusEnum status);
    List<CategoryItem> findByCategoryIdAndStatus(Long categoryId, StatusEnum status);
}
