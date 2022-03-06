package com.kukyang.appraisal_web.controller;

import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.CategoryDto;
import com.kukyang.appraisal_web.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public String getCategoryPage(Model model) {

        return "pages/admin/category/categoryMain";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<CategoryDto> getCategories(Model model) {
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
}
