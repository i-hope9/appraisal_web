package com.kukyang.appraisal_web.dto.appraisalProgress;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
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
public class AppraisalProgressCreateDto extends BaseTimeDto {
    private Long appraisalProgressCategoryId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate progressDate;
    private String description;
    private StatusEnum status;

    private CategoryItem progressCategory;
    private Appraisal appraisal;
}
