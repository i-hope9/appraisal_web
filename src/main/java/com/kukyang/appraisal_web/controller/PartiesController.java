package com.kukyang.appraisal_web.controller;

import com.google.gson.Gson;
import com.kukyang.appraisal_web.domain.model.Parties;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesCreateDto;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesDto;
import com.kukyang.appraisal_web.dto.appraisalParties.PartiesUpdateDto;
import com.kukyang.appraisal_web.service.PartiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/appraisal")
@RequiredArgsConstructor
public class PartiesController {
    private final PartiesService partiesService;

    final long COURT_CATEGORY_ID = 1L;
    final long APPRAISAL_CATEGORY_ID = 2L;
    final long PARTIES_CATEGORY_ID = 3L;
    final long FEE_CATEGORY_ID = 4L;
    final long PROGRESS_ID = 5L;

    final Gson gson = new Gson();

    @ResponseBody
    @GetMapping("/{appraisalId}/parties")
    public List<PartiesDto> getParties(@PathVariable Long appraisalId) {
        return partiesService.findByAppraisalId(appraisalId)
                .stream().map(PartiesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping("/{appraisalId}/parties")
    public PartiesDto createdParties(@PathVariable Long appraisalId, @RequestBody PartiesCreateDto requestDto) {
        Parties parties = partiesService.saveParties(appraisalId, requestDto);
        return PartiesDto.fromEntity(parties);
    }

    @ResponseBody
    @PutMapping("/{appraisalId}/parties/{partiesId}")
    public PartiesDto updatePartiesById(@PathVariable Long appraisalId, @PathVariable Long partiesId, @RequestBody PartiesUpdateDto requestDto) {
        Parties parties = partiesService.updateParties(partiesId, requestDto);
        return PartiesDto.fromEntity(parties);
    }
}
