package com.kukyang.appraisal_web.controller;

import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.CategoryDto;
import com.kukyang.appraisal_web.dto.CategoryItemDto;
import com.kukyang.appraisal_web.service.CategoryItemService;
import com.kukyang.appraisal_web.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryItemService categoryItemService;

    @GetMapping
    public String getCategoryPage() {

        return "pages/admin/category/categoryMain";
    }

    @ResponseBody
    @GetMapping("/all")
    public List<CategoryDto> getCategories() {
        return categoryService.findAllCategories()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }


    @PostMapping
    public String saveCategory(@RequestBody CategoryDto requestDto) {
        // 카테고리 저장
        categoryService.saveCategory(requestDto);

        return "pages/admin/category/categoryMain :: #categoryDiv";
    }

    @ResponseBody
    @PutMapping("/{id}")
    public Long updateCategory(@PathVariable Long id, @RequestBody CategoryDto requestDto) {
        return categoryService.updateCategory(id, requestDto)
                .getId();
    }

    @ResponseBody
    @PutMapping("/{id}/status")
    public Long updateStatus(@PathVariable Long id, @RequestBody StatusEnum status) {
        return categoryService.updateCategoryStatus(id, status)
                .getId();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Long deleteCategory(@PathVariable Long id) {
        return categoryService.updateCategoryStatus(id, StatusEnum.DELETED)
                .getId();
    }

    @ResponseBody
    @GetMapping("/{id}/items")
    public List<CategoryItemDto> getCategoryItems(@PathVariable Long id) {
        return categoryItemService.findCategoryItemsByCategoryId(id)
                .stream()
                .map(CategoryItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/item")
    public String saveCategoryItem(@RequestBody CategoryItemDto requestDto) {
        // 카테고리 항목 저장
        categoryItemService.saveCategoryItem(requestDto);

        return "pages/admin/category/categoryMain :: #categoryItemDiv";
    }
}
