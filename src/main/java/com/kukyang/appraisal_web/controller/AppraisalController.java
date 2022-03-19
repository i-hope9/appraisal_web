package com.kukyang.appraisal_web.controller;

import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.dto.AppraisalCreateDto;
import com.kukyang.appraisal_web.dto.AppraisalDto;
import com.kukyang.appraisal_web.dto.AppraisalPageDto;
import com.kukyang.appraisal_web.service.AppraisalFeeService;
import com.kukyang.appraisal_web.service.AppraisalService;
import com.kukyang.appraisal_web.service.PartiesService;
import com.kukyang.appraisal_web.utils.SelectOptionUtils;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public AppraisalPageDto getAppraisalPageableList(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Appraisal> appraisals = appraisalService.findAllAppraisals(pageable);

        return AppraisalPageDto.builder()
                .totalPage(appraisals.getTotalPages())
                .data(appraisals.stream().map(AppraisalDto::fromEntity).collect(Collectors.toList()))
                .build();
    }

    @GetMapping("/info/{id}")
    public String getAppraisalById(@PathVariable Long id, Model model) {
        AppraisalDto appraisalDto = AppraisalDto.fromEntity(appraisalService.findAppraisalById(id));
        model.addAttribute("appraisal", appraisalDto);

        return "pages/appraisal/appraisalInfo";
    }

    @GetMapping("/info")
    public String getAppraisalNew(Model model) {
        final long COURT_CATEGORY_ID = 1L;
        final long APPRAISAL_CATEGORY_ID = 2L;
        final long PARTIES_CATEGORY_ID = 3L;
        final long FEE_CATEGORY_ID = 4L;

        model.addAttribute("yearOptions", new JSONObject(selectOptionUtils.generateYearOptions()));
        model.addAttribute("courtOptions", new JSONObject(selectOptionUtils.generateOptions(COURT_CATEGORY_ID)));
        model.addAttribute("appraisalCategoryOptions", new JSONObject(selectOptionUtils.generateOptions(APPRAISAL_CATEGORY_ID)));
        model.addAttribute("partiesOptions", new JSONObject(selectOptionUtils.generateOptions(PARTIES_CATEGORY_ID)));
        model.addAttribute("feeOptions", new JSONObject(selectOptionUtils.generateOptions(FEE_CATEGORY_ID)));

        return "pages/appraisal/appraisalNew";
    }

    @PostMapping("/info")
    public String saveAppraisal(@RequestBody AppraisalCreateDto requestDto) {
        Appraisal appraisal = appraisalService.saveAppraisal(requestDto);
        partiesService.savePartiesList(requestDto.getPartiesList(), appraisal);
        appraisalFeeService.saveAppraisalFeeList(requestDto.getAppraisalFeeList(), appraisal);

        return "redirect:/appraisal/all";
    }

//    @ResponseBody
//    @GetMapping("/info/options")
//    public ResponseEntity<?> getOptions(@RequestParam Long id) {
//        Map<Long, String> options = selectOptionUtils.generateOptions(id);
//        return ResponseEntity.ok(options);
//    }
}
