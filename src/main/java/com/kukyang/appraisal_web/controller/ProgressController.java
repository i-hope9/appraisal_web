package com.kukyang.appraisal_web.controller;

import com.google.gson.Gson;
import com.kukyang.appraisal_web.domain.model.AppraisalProgress;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressCreateDto;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressDto;
import com.kukyang.appraisal_web.dto.appraisalProgress.ProgressUpdateDto;
import com.kukyang.appraisal_web.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/appraisal")
@RequiredArgsConstructor
public class ProgressController {
    final long COURT_CATEGORY_ID = 1L;
    final long APPRAISAL_CATEGORY_ID = 2L;
    final long PARTIES_CATEGORY_ID = 3L;
    final long FEE_CATEGORY_ID = 4L;
    final long PROGRESS_ID = 5L;
    final Gson gson = new Gson();
    private final ProgressService progressService;

    @ResponseBody
    @GetMapping("/{appraisalId}/progress")
    public List<ProgressDto> getProgress(@PathVariable Long appraisalId) {
        return progressService.findByAppraisalId(appraisalId)
                .stream().map(ProgressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping("/{appraisalId}/progress")
    public ProgressDto createdProgress(@PathVariable Long appraisalId, @RequestBody ProgressCreateDto requestDto) {
        AppraisalProgress progress = progressService.saveProgress(appraisalId, requestDto);
        return ProgressDto.fromEntity(progress);
    }

    @ResponseBody
    @PutMapping("/{appraisalId}/progress/{progressId}")
    public ProgressDto updateProgressById(@PathVariable Long appraisalId, @PathVariable Long progressId, @RequestBody ProgressUpdateDto requestDto) {
        AppraisalProgress progress = progressService.updateProgress(progressId, requestDto);
        return ProgressDto.fromEntity(progress);
    }
}
