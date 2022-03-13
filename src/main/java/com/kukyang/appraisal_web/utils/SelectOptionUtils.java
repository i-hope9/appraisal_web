package com.kukyang.appraisal_web.utils;

import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.service.CategoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SelectOptionUtils {
    private final CategoryItemService categoryItemService;

    public Map<Long, String> generateOptions(Long id) {
        return categoryItemService.findEnabledCategoryItemsByCategoryId(id)
                .stream()
                .collect(Collectors.toMap(CategoryItem::getId, CategoryItem::getName));
    }

}
