package com.kukyang.appraisal_web.dto.category;

import com.kukyang.appraisal_web.domain.model.Category;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@Getter
@Setter
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
                .createdAt(category.getCreatedAt())
                .modifiedAt(category.getModifiedAt())
                .build();
    }
}
