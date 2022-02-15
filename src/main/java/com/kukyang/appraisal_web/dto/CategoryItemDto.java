package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.domain.model.Category;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryItemDto extends BaseTime {

    private Long id;

    private Category category;

    private String name;

    private String description;

    private StatusEnum status;

    public static CategoryItemDto fromEntity(CategoryItem categoryItem) {
        return CategoryItemDto.builder()
                .id(categoryItem.getId())
                .category(categoryItem.getCategory())
                .name(categoryItem.getName())
                .description(categoryItem.getDescription())
                .status(categoryItem.getStatus())
                .build();
    }


}
