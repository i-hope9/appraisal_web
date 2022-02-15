package com.kukyang.appraisal_web.controller;

import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.CategoryItemDto;
import com.kukyang.appraisal_web.service.CategoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/category/item")
@RequiredArgsConstructor
public class CategoryItemController {
    private final CategoryItemService categoryItemService;

    @ResponseBody
    @GetMapping
    public List<CategoryItemDto> getCategoryItems(@RequestParam Long categoryId) {
        return categoryItemService.findCategoryItemsByCategoryId(categoryId)
                .stream()
                .map(CategoryItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping
    public Long saveCategoryItem(@RequestBody CategoryItemDto requestDto) {
        return categoryItemService.saveCategoryItem(requestDto).getId();
    }

    @ResponseBody
    @PutMapping("/{id}")
    public Long updateCategoryItem(@PathVariable Long id, @RequestBody CategoryItemDto requestDto) {
        return categoryItemService.updateCategoryItem(id, requestDto)
                .getId();
    }

    @ResponseBody
    @PutMapping("/{id}/status")
    public Long updateStatus(@PathVariable Long id, @RequestBody StatusEnum status) {
        return categoryItemService.updateCategoryItemStatus(id, status)
                .getId();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Long deleteCategoryItem(@PathVariable Long id) {
        return categoryItemService.updateCategoryItemStatus(id, StatusEnum.DELETED)
                .getId();
    }
}
