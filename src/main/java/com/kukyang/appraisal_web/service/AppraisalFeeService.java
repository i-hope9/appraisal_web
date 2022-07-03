package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.AppraisalFee;
import com.kukyang.appraisal_web.dto.appraisalFee.AppraisalFeeCreateDto;
import com.kukyang.appraisal_web.dto.appraisalFee.AppraisalFeeUpdateDto;

import javax.transaction.Transactional;
import java.util.List;

public interface AppraisalFeeService {

    /* Create */
    @Transactional
    AppraisalFee saveAppraisalFee(AppraisalFeeCreateDto appraisalFeeDto);

    @Transactional
    List<AppraisalFee> saveAppraisalFeeList(List<AppraisalFeeCreateDto> appraisalFeeDtoList, Appraisal appraisal);

    /* Read */
    @Transactional
    AppraisalFee findById(Long appraisalFeeId);

    /* Update */
    @Transactional
    AppraisalFee updateAppraisalFee(Long appraisalFeeId, AppraisalFeeUpdateDto updateDto);

}
