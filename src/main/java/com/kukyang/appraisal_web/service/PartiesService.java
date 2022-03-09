package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.Parties;
import com.kukyang.appraisal_web.dto.PartiesDto;

import javax.transaction.Transactional;
import java.util.List;

public interface PartiesService {

    /* Create */
    @Transactional
    Parties saveParties(PartiesDto partiesDto);

    @Transactional
    List<Parties> savePartiesList(List<PartiesDto> partiesDtoList, Appraisal appraisal);

    /* Read */
    @Transactional
    Parties findByAppraisalAndPartiesCategory(Long appraisalId, Long partiesId);
}
