package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.AppraisalFee;
import com.kukyang.appraisal_web.dto.AppraisalFeeCreateDto;

import javax.transaction.Transactional;
import java.util.List;

public interface AppraisalFeeService {

    /* Create */
    @Transactional
    AppraisalFee saveAppraisalFee(AppraisalFeeCreateDto appraisalFeeDto);

    @Transactional
    List<AppraisalFee> saveAppraisalFeeList(List<AppraisalFeeCreateDto> appraisalFeeDtoList, Appraisal appraisal);

}