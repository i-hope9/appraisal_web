package com.kukyang.appraisal_web.controller;

import com.google.gson.Gson;
import com.kukyang.appraisal_web.domain.model.Parties;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesDto;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesUpdateDto;
import com.kukyang.appraisal_web.service.AppraisalFeeService;
import com.kukyang.appraisal_web.service.AppraisalService;
import com.kukyang.appraisal_web.service.PartiesService;
import com.kukyang.appraisal_web.utils.SelectOptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appraisal/detail")
@RequiredArgsConstructor
public class AppraisalDetailController {
    private final SelectOptionUtils selectOptionUtils;
    private final AppraisalService appraisalService;
    private final PartiesService partiesService;
    private final AppraisalFeeService appraisalFeeService;

    final long COURT_CATEGORY_ID = 1L;
    final long APPRAISAL_CATEGORY_ID = 2L;
    final long PARTIES_CATEGORY_ID = 3L;
    final long FEE_CATEGORY_ID = 4L;
    final long PROGRESS_ID = 5L;

    final Gson gson = new Gson();

    @ResponseBody
    @PostMapping("/{appraisalId}/parties")
    public PartiesDto createdParties(@PathVariable Long id, @RequestBody PartiesUpdateDto requestDto) {
        Parties parties = partiesService.updateParties(id, requestDto);
        return PartiesDto.fromEntity(parties);
    }

    @ResponseBody
    @PutMapping("/{appraisalId}/parties/{id}")
    public PartiesDto updateAppraisalById(@PathVariable Long id, @RequestBody PartiesUpdateDto requestDto) {
        Parties parties = partiesService.updateParties(id, requestDto);
        return PartiesDto.fromEntity(parties);
    }



}
