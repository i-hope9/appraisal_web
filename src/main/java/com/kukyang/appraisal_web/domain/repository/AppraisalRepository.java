package com.kukyang.appraisal_web.domain.repository;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppraisalRepository extends JpaRepository<Appraisal, Long> {
    List<Appraisal> findAllByStatusNot(StatusEnum status);
}
