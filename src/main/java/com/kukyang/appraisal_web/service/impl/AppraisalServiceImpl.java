package com.kukyang.appraisal_web.service.impl;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.domain.model.CategoryItem;
import com.kukyang.appraisal_web.domain.model.enums.StatusEnum;
import com.kukyang.appraisal_web.domain.repository.AppraisalRepository;
import com.kukyang.appraisal_web.dto.AppraisalCreateDto;
import com.kukyang.appraisal_web.service.AppraisalService;
import com.kukyang.appraisal_web.service.CategoryItemService;
import com.kukyang.appraisal_web.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppraisalServiceImpl implements AppraisalService {
    private final AppraisalRepository appraisalRepository;
    private final CategoryItemService categoryItemService;

    /**
     * 감정 관리 저장
     */
    @Override
    public Appraisal saveAppraisal(AppraisalCreateDto createDto) {
        CategoryItem courtCategory = categoryItemService.findCategoryItemById(createDto.getCourtCategoryId());
        CategoryItem appraisalCategory = categoryItemService.findCategoryItemById(createDto.getAppraisalCategoryId());
        createDto.setCourtCategory(courtCategory);
        createDto.setAppraisalCategory(appraisalCategory);

        return appraisalRepository.save(Appraisal.toEntity(createDto));
    }

    /**
     * 감정 관리 목록 조회: 삭제 상태가 아닌 모든 감정 관리 목록
     */
    @Override
    public List<Appraisal> findAllAppraisals() {
        return appraisalRepository.findAllByStatusNot(StatusEnum.DELETED);
    }

    /**
     * 감정 관리 목록 페이징 조회: 삭제 상태가 아닌 모든 감정 관리 목록
     */
    @Override
    public Page<Appraisal> findAllAppraisals(Pageable pageable) {
        return appraisalRepository.findAllByStatusNot(StatusEnum.DELETED, pageable);
    }

    /**
     * 감정 관리 조회: ID로 1개
     */
    @Override
    public Appraisal findAppraisalById(Long id) {
        return appraisalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("감정 관리를 찾을 수 없습니다. (ID: " + id + ")"));
    }
}
