package com.kukyang.appraisal_web.service;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.Parties;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesCreateDto;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesUpdateDto;

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
    Parties findById(Long partiesId);

    @Transactional
    Parties findByAppraisalAndPartiesCategory(Long appraisalId, Long partiesId);

    /* Update */
    @Transactional
    Parties updateParties(Long partiesId, PartiesUpdateDto updateDto);
}
