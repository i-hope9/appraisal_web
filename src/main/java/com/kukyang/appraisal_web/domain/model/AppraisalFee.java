package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.AppraisalFeeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalFee extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appraisal_id")
    private Appraisal appraisal;

    @ManyToOne
    @JoinColumn(name = "parties_id")
    private Parties parties;

    @OneToOne
    @JoinColumn(name = "fee_category_id", referencedColumnName = "id")
    private CategoryItem feeCategory;

    private LocalDateTime depositDate;

    private Long amount;

    private String description;

    private StatusEnum status;

    public static AppraisalFee toEntity(AppraisalFeeDto appraisalFeeDto) {
        return AppraisalFee.builder()
                .appraisal(appraisalFeeDto.getAppraisal())
                .parties(appraisalFeeDto.getParties())
                .feeCategory(appraisalFeeDto.getFeeCategory())
                .depositDate(appraisalFeeDto.getFeeDate().atStartOfDay())
                .amount(appraisalFeeDto.getFeeAmount())
                .status(appraisalFeeDto.getStatus())
                .build();
    }

}
