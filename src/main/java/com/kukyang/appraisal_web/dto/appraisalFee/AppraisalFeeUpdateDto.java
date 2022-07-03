package com.kukyang.appraisal_web.dto.appraisalFee;

import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.Parties;
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
public class AppraisalFeeUpdateDto {
    private Long appraisalId;
    private Long feePartiesCategoryId;
    private Long feeCategoryId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate feeDate;
    private Long feeAmount;
    private Long remainder;
    private String description;
    private StatusEnum status;

    private CategoryItem feeCategory;
    private Parties parties;

}
