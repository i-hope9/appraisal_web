package com.kukyang.appraisal_web.service.impl;

import com.kukyang.appraisal_web.domain.model.Category;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.domain.repository.CategoryItemRepository;
import com.kukyang.appraisal_web.dto.category.CategoryItemDto;
import com.kukyang.appraisal_web.service.CategoryItemService;
import com.kukyang.appraisal_web.service.CategoryService;
import com.kukyang.appraisal_web.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryItemServiceImpl implements CategoryItemService {
    private final CategoryItemRepository categoryItemRepository;
    private final CategoryService categoryService;

    /**
     * 카테고리 항목 저장
     */
    @Override
    public CategoryItem saveCategoryItem(CategoryItemDto categoryItemDto) {
        Category category = categoryService.findCategoryById(categoryItemDto.getCategoryId());
        categoryItemDto.setCategory(category);

        return categoryItemRepository.save(CategoryItem.toEntity(categoryItemDto));
    }

    /**
     * 카테고리 항목 조회: 카테고리 항목 ID로 카테고리 항목 1개
     * */
    @Override
    public CategoryItem findCategoryItemById(Long id) {
        return categoryItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("카테고리 항목을 찾을 수 없습니다. (ID: " + id + ")"));
    }

    /**
     * 카테고리 항목 목록 조회: 카테고리 ID로 카테고리 항목 목록 조회, 삭제 상태 아님
     * */
    @Override
    public List<CategoryItem> findCategoryItemsByCategoryId(Long id) {
        // 카테고리가 존재하는지 조회
        categoryService.findCategoryById(id);

        return categoryItemRepository.findByCategoryIdAndStatusNot(id, StatusEnum.DELETED);
    }

    /**
     * 카테고리 항목 목록 조회: 카테고리 ID로 카테고리 항목 목록 조회, 사용 상태
     * */
    @Override
    public List<CategoryItem> findEnabledCategoryItemsByCategoryId(Long id) {
        // 카테고리가 존재하는지 조회
        categoryService.findCategoryById(id);

        return categoryItemRepository.findByCategoryIdAndStatus(id, StatusEnum.ENABLE);
    }

    /**
     * 카테고리 항목 수정
     * */
    @Override
    public CategoryItem updateCategoryItem(Long id, CategoryItemDto categoryItemDto) {
        CategoryItem categoryItem = this.findCategoryItemById(id);
        categoryItem.update(categoryItemDto);

        return categoryItemRepository.save(categoryItem);
    }

    /**
     * 카테고리 항목 수정: 상태 수정
     * */
    @Override
    public CategoryItem updateCategoryItemStatus(Long id, StatusEnum status) {
        CategoryItem categoryItem = this.findCategoryItemById(id);
        categoryItem.updateStatus(status);

        return categoryItemRepository.save(categoryItem);
    }

}
