package com.kukyang.appraisal_web.service.impl;

import com.kukyang.appraisal_web.domain.model.Category;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.domain.repository.CategoryRepository;
import com.kukyang.appraisal_web.dto.category.CategoryDto;
import com.kukyang.appraisal_web.service.CategoryService;
import com.kukyang.appraisal_web.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 저장
     */
    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        return categoryRepository.save(Category.toEntity(categoryDto));
    }

    /**
     * 카테고리 조회: ID로 카테고리 1개
     * */
    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("카테고리를 찾을 수 없습니다. (ID: " + id + ")"));
    }

    /**
     * 카테고리 목록 조회: 삭제 상태가 아닌 모든 카테고리 목록
     * */
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAllByStatusNot(StatusEnum.DELETED);
    }

    /**
     * 카테고리 목록 조회: 사용 상태의 모든 카테고리 목록
     * */
    @Override
    public List<Category> findAllEnabledCategories() {
        return categoryRepository.findAllByStatus(StatusEnum.ENABLE);
    }

    /**
     * 카테고리 수정
     * */
    @Override
    public Category updateCategory(Long id, CategoryDto categoryDto) {
        Category category = this.findCategoryById(id);
        category.update(categoryDto);

        return categoryRepository.save(category);
    }

    /**
     * 카테고리 수정: 상태 수정
     * */
    @Override
    public Category updateCategoryStatus(Long id, StatusEnum status) {
        Category category = this.findCategoryById(id);
        category.updateStatus(status);

        return categoryRepository.save(category);
    }
}
