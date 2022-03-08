package com.kukyang.appraisal_web.dto;

import com.kukyang.appraisal_web.dto.bases.BaseTimeDto;
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
public class AppraisalCreateDto extends BaseTimeDto {
    private Long year;
    private String appraisalNumber;
    private Long courtCategory;
    private String judgePanel;
    private Long judgeTel;
    private Long judgeFax;
    private String caseType;
    private Long caseNumber;
    private Long appraisalCategory;
    private String name;
    private String objectAddress;
    private String objectRemarks;

    private String plaintiffName;
    private Long plaintiffTel;
    private String plaintiffAttorneyCompanyName;
    private Long plaintiffAttorneyCompanyTel;
    private String plaintiffAttorneyName;
    private Long plaintiffAttorneyTel;

    private String defendantName;
    private Long defendantTel;
    private String defendantAttorneyCompanyName;
    private Long defendantAttorneyCompanyTel;
    private String defendantAttorneyName;
    private Long defendantAttorneyTel;

    private LocalDateTime plaintiffFee1Date;
    private Long plaintiffFee1;
    private LocalDateTime plaintiffFee2Date;
    private Long plaintiffFee2;
    private LocalDateTime plaintiffFee3Date;
    private Long plaintiffFee3;

    private LocalDateTime defendantFee1Date;
    private Long defendantFee1;
    private LocalDateTime defendantFee2Date;
    private Long defendantFee2;
    private LocalDateTime defendantFee3Date;
    private Long defendantFee3;
}
