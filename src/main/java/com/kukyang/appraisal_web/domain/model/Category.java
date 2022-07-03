package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.category.CategoryDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 150)
    private String name;

    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @OneToMany(mappedBy = "category",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<CategoryItem> categoryItems;

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .status(categoryDto.getStatus())
                .build();
    }

    public void update(CategoryDto categoryDto) {
        this.name = categoryDto.getName();
        this.description = categoryDto.getDescription();
    }

    public void updateStatus(StatusEnum status) {
        this.status = status;
    }
}
