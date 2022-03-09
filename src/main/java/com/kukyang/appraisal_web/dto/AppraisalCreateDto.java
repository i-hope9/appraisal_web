package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalCreateDto extends BaseTimeDto {
    private Long year;
    private String appraisalNumber;
    private Long courtCategoryId;
    private String judgePanel;
    private Long judgeTel;
    private Long judgeFax;
    private String caseType;
    private Long caseNumber;
    private Long appraisalCategoryId;
    private String name;
    private String objectAddress;
    private String objectRemarks;
    private StatusEnum status;

    private List<PartiesDto> partiesList;
    private List<AppraisalFeeDto> appraisalFeeList;

    private CategoryItem courtCategory;
    private CategoryItem appraisalCategory;

}
