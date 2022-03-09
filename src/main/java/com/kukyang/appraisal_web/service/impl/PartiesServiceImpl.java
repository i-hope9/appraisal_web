package com.kukyang.appraisal_web.service.impl;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.Parties;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.domain.repository.PartiesRepository;
import com.kukyang.appraisal_web.dto.PartiesDto;
import com.kukyang.appraisal_web.service.CategoryItemService;
import com.kukyang.appraisal_web.service.PartiesService;
import com.kukyang.appraisal_web.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartiesServiceImpl implements PartiesService {
    private final PartiesRepository partiesRepository;
    private final CategoryItemService categoryItemService;

    /**
     * 당사자 저장
     */
    @Override
    public Parties saveParties(PartiesDto partiesDto) {
        CategoryItem partiesCategory = categoryItemService.findCategoryItemById(partiesDto.getPartiesCategoryId());
        partiesDto.setPartiesCategory(partiesCategory);

        return partiesRepository.save(Parties.toEntity(partiesDto));
    }

    /**
     * 당사자 저장: 목록으로 저장
     */
    @Override
    public List<Parties> savePartiesList(List<PartiesDto> partiesDtoList, Appraisal appraisal) {
        List<Parties> results = new ArrayList<>();
        for (PartiesDto partiesDto : partiesDtoList) {
            partiesDto.setAppraisal(appraisal);
            partiesDto.setStatus(StatusEnum.ENABLE);
            results.add(this.saveParties(partiesDto));
        }
        return results;
    }

    /**
     * 당사자 조회: 감정 ID, 당사자 유형 ID로 조회
     */
    @Override
    public Parties findByAppraisalAndPartiesCategory(Long appraisalId, Long partiesId) {
        return partiesRepository.findByAppraisalIdAndPartiesCategoryId(appraisalId, partiesId)
                .orElseThrow(() -> new ResourceNotFoundException("당사자를 찾을 수 없습니다."));
    }
}
