package com.kukyang.appraisal_web.domain.repository;

import com.kukyang.appraisal_web.domain.model.AppraisalProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppraisalProgressRepository extends JpaRepository<AppraisalProgress, Long> {
    List<AppraisalProgress> findByAppraisalId(Long appraisalId);
}
