package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.Parties;
import com.kukyang.appraisal_web.dto.PartiesCreateDto;

import javax.transaction.Transactional;
import java.util.List;

public interface PartiesService {

    /* Create */
    @Transactional
    Parties saveParties(PartiesCreateDto partiesDto);

    @Transactional
    List<Parties> savePartiesList(List<PartiesCreateDto> partiesDtoList, Appraisal appraisal);

    /* Read */
    @Transactional
    Parties findByAppraisalAndPartiesCategory(Long appraisalId, Long partiesId);
}
