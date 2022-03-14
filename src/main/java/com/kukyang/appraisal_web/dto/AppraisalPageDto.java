package com.kukyang.appraisal_web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalPageDto {
    private int totalPage;
    private List<AppraisalDto> data;
}
