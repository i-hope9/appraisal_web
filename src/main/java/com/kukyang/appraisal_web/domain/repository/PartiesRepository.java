package com.kukyang.appraisal_web.domain.repository;

import com.kukyang.appraisal_web.domain.model.Parties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartiesRepository extends JpaRepository<Parties, Long> {
    Optional<Parties> findByAppraisalIdAndPartiesCategoryId(Long appraisalId, Long partiesCategoryId);
}
