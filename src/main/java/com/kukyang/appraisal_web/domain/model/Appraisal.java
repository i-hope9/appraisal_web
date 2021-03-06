package com.kukyang.appraisal_web.domain.model;

import com.kukyang.appraisal_web.domain.model.bases.BaseTime;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.dto.appraisal.AppraisalCreateDto;
import com.kukyang.appraisal_web.dto.appraisal.AppraisalUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Getter
@DynamicUpdate
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

    private String judgeTel;

    private String judgeFax;

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
            fetch = FetchType.EAGER)
    private Set<Parties> partiesList;

    @OneToMany(mappedBy = "appraisal",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    private Set<AppraisalFee> appraisalFeeList;

    @OneToMany(mappedBy = "appraisal",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    private Set<AppraisalProgress> appraisalProgressList;

    @OneToMany(mappedBy = "appraisal",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    private Set<AppraisalFeeProgress> appraisalFeeProgressList;

    public static Appraisal toEntity(AppraisalCreateDto dto) {
        return Appraisal.builder()
                .courtCategory(dto.getCourtCategory())
                .appraisalCategory(dto.getAppraisalCategory())
                .year(dto.getYear())
                .appraisalNumber(dto.getAppraisalNumber())
                .judgePanel(dto.getJudgePanel())
                .judgeFax(dto.getJudgeFax())
                .caseType(dto.getCaseType())
                .caseNumber(dto.getCaseNumber())
                .name(dto.getName())
                .objectAddress(dto.getObjectAddress())
                .objectRemarks(dto.getObjectRemarks())
                .status(dto.getStatus())
                .build();
    }

    public void updateAppraisal(AppraisalUpdateDto dto) {
        this.courtCategory = dto.getCourtCategory();
        this.appraisalCategory = dto.getAppraisalCategory();
        this.year = dto.getYear();
        this.appraisalNumber = dto.getAppraisalNumber();
        this.judgePanel = dto.getJudgePanel();
        this.judgeTel = dto.getJudgeTel();
        this.judgeFax = dto.getJudgeFax();
        this.caseType = dto.getCaseType();
        this.caseNumber = dto.getCaseNumber();
        this.name = dto.getName();
        this.objectAddress = dto.getObjectAddress();
        this.objectRemarks = dto.getObjectRemarks();
        this.status = dto.getStatus();
    }
}
