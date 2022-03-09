package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartiesDto extends BaseTimeDto {
    private Long partiesCategoryId;
    private String partiesName;
    private Long partiesTel;
    private String affiliation;
    private Long affiliationTel;
    private StatusEnum status;

    private CategoryItem partiesCategory;
    private Appraisal appraisal;

}
