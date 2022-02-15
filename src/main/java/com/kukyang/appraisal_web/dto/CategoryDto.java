package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Category;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.*;

@Builder @ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto extends BaseTimeDto {
    private Long id;
    private String name;
    private String description;
    private StatusEnum status;

    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .status(category.getStatus())
                .build();
    }
}
