package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.AppraisalFeeProgressCreateDto;
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
public class AppraisalFeeProgress extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appraisal_id")
    private Appraisal appraisal;

    @ManyToOne
    @JoinColumn(name = "parties_id")
    private Parties parties;

    private LocalDateTime depositDate;

    private Long amount;

    private String description;

    private StatusEnum status;

    public static AppraisalFeeProgress toEntity(AppraisalFeeProgressCreateDto dto) {
        return AppraisalFeeProgress.builder()
                .appraisal(dto.getAppraisal())
                .parties(dto.getParties())
                .depositDate(dto.getDepositDate().atStartOfDay())
                .amount(dto.getAmount())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();
    }
}
