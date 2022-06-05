package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.AppraisalFeeProgress;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalFeeProgressDto extends BaseTimeDto {
    private Long id;
    private PartiesDto parties;
    private LocalDateTime depositDate;
    private String description;
    private StatusEnum status;

    public static AppraisalFeeProgressDto fromEntity(AppraisalFeeProgress feeProgress) {
        return AppraisalFeeProgressDto.builder()
                .id(feeProgress.getId())
                .parties(PartiesDto.fromEntity(feeProgress.getParties()))
                .depositDate(feeProgress.getDepositDate())
                .description(feeProgress.getDescription())
                .status(feeProgress.getStatus())
                .createdAt(feeProgress.getCreatedAt())
                .modifiedAt(feeProgress.getModifiedAt())
                .build();
    }
}
