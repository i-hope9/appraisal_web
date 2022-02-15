package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.CategoryItemDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryItem extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @Column(length = 150)
    private String name;

    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public static CategoryItem toEntity(CategoryItemDto categoryItemDto) {
        return CategoryItem.builder()
                .name(categoryItemDto.getName())
                .category(categoryItemDto.getCategory())
                .description(categoryItemDto.getDescription())
                .status(categoryItemDto.getStatus())
                .build();
    }

    public void update(CategoryItemDto categoryItemDto) {
        this.name = categoryItemDto.getName();
        this.description = categoryItemDto.getDescription();
    }

    public void updateStatus(StatusEnum status) {
        this.status = status;
    }

}
