package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalDto extends BaseTimeDto {
    private Long id;
    private Long year;
    private String appraisalNumber;
    private CategoryItemDto courtCategory;
    private String judgePanel;
    private Long judgeTel;
    private Long judgeFax;
    private String caseType;
    private Long caseNumber;
    private CategoryItemDto appraisalCategory;
    private String name;
    private String objectAddress;
    private String objectRemarks;
    private StatusEnum status;

    public static AppraisalDto fromEntity(Appraisal appraisal) {
        return AppraisalDto.builder()
                .id(appraisal.getId())
                .year(appraisal.getYear())
                .appraisalNumber(appraisal.getAppraisalNumber())
                .courtCategory(CategoryItemDto.fromEntity(appraisal.getCourtCategory()))
                .judgePanel(appraisal.getJudgePanel())
                .judgeFax(appraisal.getJudgeFax())
                .caseType(appraisal.getCaseType())
                .caseNumber(appraisal.getCaseNumber())
                .appraisalCategory(CategoryItemDto.fromEntity(appraisal.getAppraisalCategory()))
                .name(appraisal.getName())
                .objectAddress(appraisal.getObjectAddress())
                .objectRemarks(appraisal.getObjectRemarks())
                .status(appraisal.getStatus())
                .createdAt(appraisal.getCreatedAt())
                .modifiedAt(appraisal.getModifiedAt())
                .build();
    }
}
