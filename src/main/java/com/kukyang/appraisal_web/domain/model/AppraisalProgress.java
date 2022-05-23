package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.AppraisalProgressCreateDto;
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
public class AppraisalProgress extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appraisal_id")
    private Appraisal appraisal;

    @OneToOne
    @JoinColumn(name = "progress_category_id", referencedColumnName = "id")
    private CategoryItem progressCategory;

    private LocalDateTime progressDate;

    private String description;

    private StatusEnum status;

    public static AppraisalProgress toEntity(AppraisalProgressCreateDto dto) {
        return AppraisalProgress.builder()
                .progressCategory(dto.getProgressCategory())
                .appraisal(dto.getAppraisal())
                .progressDate(dto.getProgressDate().atStartOfDay())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();
    }
}
