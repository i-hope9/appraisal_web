package com.kukyang.appraisal_web.dto.appraisalProgress;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgressUpdateDto {
    private Long progressCategoryId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate progressDate;
    private String description;
    private StatusEnum status;

    private CategoryItem progressCategory;
    private Appraisal appraisal;
}
