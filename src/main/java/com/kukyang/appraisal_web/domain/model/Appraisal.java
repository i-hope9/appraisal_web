package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
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
public class Appraisal extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "court_category_id", referencedColumnName = "id")
    private CategoryItem courtCategory;

    @OneToOne
    @JoinColumn(name = "appraisal_category_id", referencedColumnName = "id")
    private CategoryItem appraisalCategory;

    @Column(length = 20)
    private Long year;

    // 감정 번호: 수기로 입력 (K______)
    private String appraisalNumber;

    // 재판부
    private String judgePanel;

    private Long judgeTel;

    private Long judgeFax;

    // 사건 구분: (2022가합)
    private String caseType;

    // 사건 번호
    private Long caseNumber;

    private String name;

    private String objectAddress;

    private String objectRemarks;

    private StatusEnum status;

    @OneToMany(mappedBy = "appraisal",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<Parties> partiesList;

    @OneToMany(mappedBy = "appraisal",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<AppraisalFee> appraisalFeeList;
}