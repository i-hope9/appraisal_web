package com.kukyang.appraisal_web.controller;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.dto.AppraisalCreateDto;
import com.kukyang.appraisal_web.dto.AppraisalDto;
import com.kukyang.appraisal_web.service.AppraisalFeeService;
import com.kukyang.appraisal_web.service.AppraisalService;
import com.kukyang.appraisal_web.service.PartiesService;
import com.kukyang.appraisal_web.utils.SelectOptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/appraisal")
@RequiredArgsConstructor
public class AppraisalController {
    private final SelectOptionUtils selectOptionUtils;
    private final AppraisalService appraisalService;
    private final PartiesService partiesService;
    private final AppraisalFeeService appraisalFeeService;

    @GetMapping
    public String getAppraisalListPage() {

        return "pages/appraisal/appraisalList";
    }

    @ResponseBody
    @GetMapping("/all")
    public List<AppraisalDto> getAppraisalList(Model model) {

        return appraisalService.findAllAppraisals()
                .stream()
                .map(AppraisalDto::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/info/{id}")
    public String getAppraisalById(@PathVariable Long id, Model model) {
        AppraisalDto appraisalDto = AppraisalDto.fromEntity(appraisalService.findAppraisalById(id));
        model.addAttribute("appraisal", appraisalDto);

        return "pages/appraisal/appraisalInfo";
    }

    @GetMapping("/info")
    public String getAppraisalNew(Model model) {

        return "pages/appraisal/appraisalNew";
    }

    @PostMapping("/info")
    public String saveAppraisal(@RequestBody AppraisalCreateDto requestDto) {
        Appraisal appraisal = appraisalService.saveAppraisal(requestDto);
        partiesService.savePartiesList(requestDto.getPartiesList(), appraisal);
        appraisalFeeService.saveAppraisalFeeList(requestDto.getAppraisalFeeList(), appraisal);

        return "redirect:/appraisal/all";
    }

    @ResponseBody
    @GetMapping("/info/options")
    public ResponseEntity<?> getOptions(@RequestParam Long id) {
        Map<Long, String> options = selectOptionUtils.generateOptions(id);
        return ResponseEntity.ok(options);
    }
}
