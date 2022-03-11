package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.Parties;
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
public class AppraisalFeeCreateDto extends BaseTimeDto {
    private Long feePartiesCategoryId;
    private Long feeCategoryId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate feeDate;
    private Long feeAmount;
    private StatusEnum status;

    private CategoryItem feeCategory;
    private Appraisal appraisal;
    private Parties parties;

}
