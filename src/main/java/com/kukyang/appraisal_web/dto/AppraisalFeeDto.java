package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.AppraisalFee;
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
public class AppraisalFeeDto extends BaseTimeDto {
    private Long id;
    private CategoryItemDto feeCategory;
    private PartiesDto parties;
    private Long feePartiesCategoryId;
    private LocalDateTime depositDate;
    private Long amount;
    private String description;
    private StatusEnum status;

    public static AppraisalFeeDto fromEntity(AppraisalFee appraisalFee) {
        return AppraisalFeeDto.builder()
                .id(appraisalFee.getId())
                .feeCategory(CategoryItemDto.fromEntity(appraisalFee.getFeeCategory()))
                .parties(PartiesDto.fromEntity(appraisalFee.getParties()))
                .feePartiesCategoryId(appraisalFee.getParties().getPartiesCategory().getId())
                .depositDate(appraisalFee.getDepositDate())
                .amount(appraisalFee.getAmount())
                .description(appraisalFee.getDescription())
                .status(appraisalFee.getStatus())
                .createdAt(appraisalFee.getCreatedAt())
                .modifiedAt(appraisalFee.getModifiedAt())
                .build();
    }
}
