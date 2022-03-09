package com.kukyang.appraisal_web.utils;

import com.kukyang.appraisal_web.dto.CategoryItemDto;
import com.kukyang.appraisal_web.service.CategoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SelectOptionUtils {
    private final CategoryItemService categoryItemService;

    private final Long COURT_CATEGORY_ID = 1L;
    private final Long APPRAISAL_CATEGORY_ID = 2L;
    private final Long PARTIES_CATEGORY_ID = 3L;
    private final Long FEE_CATEGORY_ID = 4L;

    public List<Long> generateYearOptions() {
        long year = LocalDateTime.now().getYear();
        List<Long> years = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            years.add(year - i);
        }

        return years;
    }

    public List<CategoryItemDto> generateCourtOptions() {
        return categoryItemService.findEnabledCategoryItemsByCategoryId(COURT_CATEGORY_ID)
                .stream()
                .map(CategoryItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CategoryItemDto> generateAppraisalOptions() {
        return categoryItemService.findEnabledCategoryItemsByCategoryId(APPRAISAL_CATEGORY_ID)
                .stream()
                .map(CategoryItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CategoryItemDto> generatePartiesOptions() {
        return categoryItemService.findEnabledCategoryItemsByCategoryId(PARTIES_CATEGORY_ID)
                .stream()
                .map(CategoryItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CategoryItemDto> generateFeeOptions() {
        return categoryItemService.findEnabledCategoryItemsByCategoryId(FEE_CATEGORY_ID)
                .stream()
                .map(CategoryItemDto::fromEntity)
                .collect(Collectors.toList());
    }
}
