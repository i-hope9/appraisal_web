package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.AppraisalFee;
import com.kukyang.appraisal_web.dto.AppraisalFeeDto;

import javax.transaction.Transactional;
import java.util.List;

public interface AppraisalFeeService {

    /* Create */
    @Transactional
    AppraisalFee saveAppraisalFee(AppraisalFeeDto appraisalFeeDto);

    @Transactional
    List<AppraisalFee> saveAppraisalFeeList(List<AppraisalFeeDto> appraisalFeeDtoList, Appraisal appraisal);

}
