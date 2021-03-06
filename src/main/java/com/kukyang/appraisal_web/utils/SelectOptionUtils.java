package com.kukyang.appraisal_web.utils;

import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.service.CategoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SelectOptionUtils {
    private final CategoryItemService categoryItemService;

    public Map<Long, String> generateCategoryMap(Long id) {
        return categoryItemService.findEnabledCategoryItemsByCategoryId(id)
                .stream()
                .collect(Collectors.toMap(CategoryItem::getId, CategoryItem::getName));
    }

    public Map<Integer, String> generateYearOptions() {
        Map<Integer, String> years = new HashMap<>();
        int year = LocalDate.now().getYear();
        years.put(year, String.valueOf(year));

        for (int i = 1; i <= 5; i++) {
            years.put(year - i, String.valueOf(year - i));
            years.put(year + i, String.valueOf(year + i));
        }

        return years;
    }

}
