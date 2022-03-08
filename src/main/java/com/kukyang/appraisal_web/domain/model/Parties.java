package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Parties extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appraisal_id")
    private Appraisal appraisal;

    @OneToOne
    @JoinColumn(name = "parties_category_id", referencedColumnName = "id")
    private CategoryItem partiesCategory;

    private String name;

    private Long tel;

    private String affiliation;

    private Long affiliationTel;

    @OneToMany(mappedBy = "parties",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<AppraisalFee> appraisalFeeList;
}
