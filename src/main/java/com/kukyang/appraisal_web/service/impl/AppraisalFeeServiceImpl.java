package com.kukyang.appraisal_web.service.impl;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.AppraisalFee;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.Parties;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.domain.repository.AppraisalFeeRepository;
import com.kukyang.appraisal_web.dto.appraisalFee.AppraisalFeeCreateDto;
import com.kukyang.appraisal_web.dto.appraisalFee.AppraisalFeeUpdateDto;
import com.kukyang.appraisal_web.service.AppraisalFeeService;
import com.kukyang.appraisal_web.service.CategoryItemService;
import com.kukyang.appraisal_web.service.PartiesService;
import com.kukyang.appraisal_web.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppraisalFeeServiceImpl implements AppraisalFeeService {
    private final AppraisalFeeRepository feeRepository;
    private final CategoryItemService categoryItemService;
    private final PartiesService partiesService;

    /**
     * 감정료 저장
     */
    @Override
    public AppraisalFee saveAppraisalFee(AppraisalFeeCreateDto appraisalFeeDto) {
        CategoryItem feeCategory = categoryItemService.findCategoryItemById(appraisalFeeDto.getFeeCategoryId());
        Parties parties = partiesService.findByAppraisalAndPartiesCategory(appraisalFeeDto.getAppraisal().getId(), appraisalFeeDto.getFeePartiesCategoryId());
        appraisalFeeDto.setFeeCategory(feeCategory);
        appraisalFeeDto.setParties(parties);

        return feeRepository.save(AppraisalFee.toEntity(appraisalFeeDto));
    }

    /**
     * 감정료 저장: 목록으로 저장
     */
    @Override
    public List<AppraisalFee> saveAppraisalFeeList(List<AppraisalFeeCreateDto> appraisalFeeDtoList, Appraisal appraisal) {
        List<AppraisalFee> results = new ArrayList<>();
        for (AppraisalFeeCreateDto appraisalFeeDto : appraisalFeeDtoList) {
            appraisalFeeDto.setAppraisal(appraisal);
            appraisalFeeDto.setStatus(StatusEnum.ENABLE);
            results.add(this.saveAppraisalFee(appraisalFeeDto));
        }
        return results;
    }

    @Override
    public AppraisalFee findById(Long appraisalFeeId) {
        return feeRepository.findById(appraisalFeeId)
                .orElseThrow(() -> new ResourceNotFoundException("감정료를 찾을 수 없습니다."));
    }

    /**
     * 감정료 수정
     */
    @Override
    public AppraisalFee updateAppraisalFee(Long appraisalFeeId, AppraisalFeeUpdateDto updateDto) {
        AppraisalFee appraisalFee = findById(appraisalFeeId);
        Parties parties = partiesService.findByAppraisalAndPartiesCategory(updateDto.getAppraisalId(), updateDto.getFeePartiesCategoryId());
        CategoryItem feeCategory = categoryItemService.findCategoryItemById(updateDto.getFeeCategoryId());
        updateDto.setParties(parties);
        updateDto.setFeeCategory(feeCategory);

        appraisalFee.updateAppraisalFee(updateDto);

        return feeRepository.save(appraisalFee);
    }
}
