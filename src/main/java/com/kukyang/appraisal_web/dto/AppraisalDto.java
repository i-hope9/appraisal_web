package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

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

    private List<PartiesDto> partiesList;
    private List<AppraisalFeeDto> appraisalFeeList;

    public static AppraisalDto fromEntity(Appraisal appraisal) {
        List<PartiesDto> partiesList = appraisal.getPartiesList().stream().map(PartiesDto::fromEntity).collect(Collectors.toList());
        List<AppraisalFeeDto> appraisalFeeList = appraisal.getAppraisalFeeList().stream().map(AppraisalFeeDto::fromEntity).collect(Collectors.toList());

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
                .partiesList(partiesList)
                .appraisalFeeList(appraisalFeeList)
                .createdAt(appraisal.getCreatedAt())
                .modifiedAt(appraisal.getModifiedAt())
                .build();
    }
}
