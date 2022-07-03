package com.kukyang.appraisal_web.dto.appraisal;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.appraisalFee.AppraisalFeeDto;
import com.kukyang.appraisal_web.dto.appraisalFee.AppraisalFeeProgressDto;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesDto;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressDto;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import com.kukyang.appraisal_web.dto.category.CategoryItemDto;
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
    private String judgeTel;
    private String judgeFax;
    private String caseType;
    private Long caseNumber;
    private CategoryItemDto appraisalCategory;
    private String name;
    private String objectAddress;
    private String objectRemarks;
    private StatusEnum status;

    private List<PartiesDto> partiesList;
    private List<AppraisalFeeDto> appraisalFeeList;
    private List<ProgressDto> appraisalProgressList;
    private List<AppraisalFeeProgressDto> appraisalFeeProgressList;

    public static AppraisalDto fromEntity(Appraisal appraisal) {
        List<PartiesDto> partiesList = appraisal.getPartiesList().stream().map(PartiesDto::fromEntity).collect(Collectors.toList());
        List<AppraisalFeeDto> appraisalFeeList = appraisal.getAppraisalFeeList().stream().map(AppraisalFeeDto::fromEntity).collect(Collectors.toList());
        List<ProgressDto> appraisalProgressList = appraisal.getAppraisalProgressList().stream().map(ProgressDto::fromEntity).collect(Collectors.toList());
        List<AppraisalFeeProgressDto> feeProgressList = appraisal.getAppraisalFeeProgressList().stream().map(AppraisalFeeProgressDto::fromEntity).collect(Collectors.toList());

        return AppraisalDto.builder()
                .id(appraisal.getId())
                .year(appraisal.getYear())
                .appraisalNumber(appraisal.getAppraisalNumber())
                .courtCategory(CategoryItemDto.fromEntity(appraisal.getCourtCategory()))
                .judgePanel(appraisal.getJudgePanel())
                .judgeTel(appraisal.getJudgeTel())
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
                .appraisalProgressList(appraisalProgressList)
                .appraisalFeeProgressList(feeProgressList)
                .createdAt(appraisal.getCreatedAt())
                .modifiedAt(appraisal.getModifiedAt())
                .build();
    }
}
