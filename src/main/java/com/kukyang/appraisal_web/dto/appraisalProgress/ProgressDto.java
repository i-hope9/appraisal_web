package com.kukyang.appraisal_web.dto.appraisalProgress;

import com.kukyang.appraisal_web.domain.model.AppraisalProgress;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import com.kukyang.appraisal_web.dto.category.CategoryItemDto;
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
public class ProgressDto extends BaseTimeDto {
    private Long id;
    private CategoryItemDto progressCategory;
    private LocalDateTime progressDate;
    private String description;
    private StatusEnum status;

    public static ProgressDto fromEntity(AppraisalProgress appraisalProgress) {
        return ProgressDto.builder()
                .id(appraisalProgress.getId())
                .progressCategory(CategoryItemDto.fromEntity(appraisalProgress.getProgressCategory()))
                .progressDate(appraisalProgress.getProgressDate())
                .description(appraisalProgress.getDescription())
                .status(appraisalProgress.getStatus())
                .createdAt(appraisalProgress.getCreatedAt())
                .modifiedAt(appraisalProgress.getModifiedAt())
                .build();
    }
}
