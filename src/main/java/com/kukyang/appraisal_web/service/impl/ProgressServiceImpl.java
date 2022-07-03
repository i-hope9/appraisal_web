package com.kukyang.appraisal_web.service.impl;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.AppraisalProgress;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.repository.AppraisalProgressRepository;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressCreateDto;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressUpdateDto;
import com.kukyang.appraisal_web.service.AppraisalService;
import com.kukyang.appraisal_web.service.CategoryItemService;
import com.kukyang.appraisal_web.service.ProgressService;
import com.kukyang.appraisal_web.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {
    private final AppraisalProgressRepository progressRepository;
    private final AppraisalService appraisalService;
    private final CategoryItemService categoryItemService;

    /**
     * 진행상황 저장
     */
    @Override
    public AppraisalProgress saveProgress(Long appraisalId, ProgressCreateDto progressDto) {
        Appraisal appraisal = appraisalService.findAppraisalById(appraisalId);
        progressDto.setAppraisal(appraisal);

        return this.saveProgress(progressDto);
    }

    /**
     * 진행상황 저장
     */
    @Override
    public AppraisalProgress saveProgress(ProgressCreateDto progressDto) {
        CategoryItem progressCategory = categoryItemService.findCategoryItemById(progressDto.getProgressCategoryId());
        progressDto.setProgressCategory(progressCategory);

        return progressRepository.save(AppraisalProgress.toEntity(progressDto));
    }

    /**
     * 진행상황 조회: ID로 조회
     */
    @Override
    public AppraisalProgress findById(Long progressId) {
        return progressRepository.findById(progressId)
                .orElseThrow(() -> new ResourceNotFoundException("진행 상황을 찾을 수 없습니다."));
    }

    /**
     * 진행상황 조회
     */
    @Override
    public List<AppraisalProgress> findByAppraisalId(Long appraisalId) {
        return progressRepository.findByAppraisalId(appraisalId);
    }

    /**
     * 진행상황 수정
     */
    @Override
    public AppraisalProgress updateProgress(Long progressId, ProgressUpdateDto updateDto) {
        AppraisalProgress progress = findById(progressId);
        CategoryItem progressCategory = categoryItemService.findCategoryItemById(updateDto.getProgressCategoryId());
        updateDto.setProgressCategory(progressCategory);

        progress.updateProgress(updateDto);

        return progressRepository.save(progress);
    }
}
