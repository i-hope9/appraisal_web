package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Category;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryItemDto extends BaseTimeDto {

    private Long id;

    private Long categoryId;

    private Category category;

    private String name;

    private String description;

    private StatusEnum status;

    public static CategoryItemDto fromEntity(CategoryItem categoryItem) {
        return CategoryItemDto.builder()
                .id(categoryItem.getId())
                .name(categoryItem.getName())
                .description(categoryItem.getDescription())
                .status(categoryItem.getStatus())
                .createdAt(categoryItem.getCreatedAt())
                .modifiedAt(categoryItem.getModifiedAt())
                .build();
    }

}
