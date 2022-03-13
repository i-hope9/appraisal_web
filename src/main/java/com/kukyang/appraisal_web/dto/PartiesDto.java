package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Parties;
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
    private Long id;
    private CategoryItemDto partiesCategory;
    private String name;
    private String tel;
    private String affiliation;
    private String affiliationTel;
    private StatusEnum status;

    public static PartiesDto fromEntity(Parties parties) {
        return PartiesDto.builder()
                .id(parties.getId())
                .partiesCategory(CategoryItemDto.fromEntity(parties.getPartiesCategory()))
                .name(parties.getName())
                .tel(parties.getTel())
                .affiliation(parties.getAffiliation())
                .affiliationTel(parties.getAffiliationTel())
                .createdAt(parties.getCreatedAt())
                .modifiedAt(parties.getModifiedAt())
                .build();
    }
}
