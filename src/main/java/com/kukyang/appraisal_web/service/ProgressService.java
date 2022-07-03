package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.AppraisalProgress;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressCreateDto;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressUpdateDto;

import javax.transaction.Transactional;
import java.util.List;

public interface ProgressService {

    /* Create */
    @Transactional
    AppraisalProgress saveProgress(Long appraisalId, ProgressCreateDto progressDto);

    @Transactional
    AppraisalProgress saveProgress(ProgressCreateDto progressDto);

    /* Read */
    @Transactional
    AppraisalProgress findById(Long progressId);

    @Transactional
    List<AppraisalProgress> findByAppraisalId(Long appraisalId);

    /* Update */
    @Transactional
    AppraisalProgress updateProgress(Long progressId, ProgressUpdateDto updateDto);
}
