package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.dto.AppraisalCreateDto;
import com.kukyang.appraisal_web.dto.AppraisalUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    Page<Appraisal> findAllAppraisals(Pageable pageable);

    @Transactional
    Appraisal findAppraisalById(Long id);

    /* Update */
    @Transactional
    Appraisal updateAppraisal(Long id, AppraisalUpdateDto appraisalUpdateDto);
}
