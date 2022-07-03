package com.kukyang.appraisal_web.dto.appraisalParties;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
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
public class PartiesUpdateDto {
    private String name;
    private String tel;
    private String affiliation;
    private String affiliationTel;
    private StatusEnum status;
    private Long partiesCategoryId;

    private CategoryItem partiesCategory;
    private Appraisal appraisal;

}
