package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.dto.AppraisalCreateDto;

import javax.transaction.Transactional;
import java.util.List;

public interface AppraisalService {

    /* Create */
    @Transactional
    Appraisal saveAppraisal(AppraisalCreateDto appraisalCreateDto);

    /* Read */
    @Transactional
    List<Appraisal> findAllAppraisals();

    @Transactional
    Appraisal findAppraisalById(Long id);
}
