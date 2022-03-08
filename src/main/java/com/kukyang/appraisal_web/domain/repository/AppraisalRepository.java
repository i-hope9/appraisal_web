package com.kukyang.appraisal_web.domain.repository;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppraisalRepository extends JpaRepository<Appraisal, Long> {
}
