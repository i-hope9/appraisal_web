package com.kukyang.appraisal_web.controller;

import com.google.gson.Gson;
import com.kukyang.appraisal_web.domain.model.Appraisal;
import com.kukyang.appraisal_web.dto.appraisal.AppraisalCreateDto;
import com.kukyang.appraisal_web.dto.appraisal.AppraisalDto;
import com.kukyang.appraisal_web.dto.appraisal.AppraisalPageDto;
import com.kukyang.appraisal_web.dto.appraisal.AppraisalUpdateDto;
import com.kukyang.appraisal_web.service.AppraisalFeeService;
import com.kukyang.appraisal_web.service.AppraisalService;
import com.kukyang.appraisal_web.service.PartiesService;
import com.kukyang.appraisal_web.utils.SelectOptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AppraisalController {
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

    @GetMapping
    public String getAppraisalListPage() {

        return "pages/appraisal/appraisalList";
    }

    /**
    * 감정관리 리스트를 불러 옵니다. (appraisalList.js)
    * */
    @ResponseBody
    @GetMapping("/appraisal/all")
    public AppraisalPageDto getAppraisalPageableList(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Appraisal> appraisals = appraisalService.findAllAppraisals(pageable);

        return AppraisalPageDto.builder()
                .totalPage(appraisals.getTotalPages())
                .data(appraisals.stream().map(AppraisalDto::fromEntity).collect(Collectors.toList()))
                .build();
    }

    /**
     * 감정관리 상세 정보를 불러 옵니다. (appraisalList.js)
     * */
    @GetMapping("/appraisal/{id}")
    public String getAppraisalById(@PathVariable Long id, Model model) {
        model.addAttribute("yearOptions", gson.toJson(selectOptionUtils.generateYearOptions()));
        model.addAttribute("courtOptions", gson.toJson(selectOptionUtils.generateCategoryMap(COURT_CATEGORY_ID)));
        model.addAttribute("appraisalCategoryOptions", gson.toJson(selectOptionUtils.generateCategoryMap(APPRAISAL_CATEGORY_ID)));
        model.addAttribute("partiesOptions", gson.toJson(selectOptionUtils.generateCategoryMap(PARTIES_CATEGORY_ID)));
        model.addAttribute("feeOptions", gson.toJson(selectOptionUtils.generateCategoryMap(FEE_CATEGORY_ID)));
        model.addAttribute("progressOptions", gson.toJson(selectOptionUtils.generateCategoryMap(PROGRESS_ID)));

        AppraisalDto appraisalDto = AppraisalDto.fromEntity(appraisalService.findAppraisalById(id));
        List<AppraisalDto> appraisalDtoList = new ArrayList<>();
        appraisalDtoList.add(appraisalDto);

        Gson gson = new Gson();
        model.addAttribute("appraisal", gson.toJson(appraisalDtoList));

        return "pages/appraisal/appraisalInfo";
    }

    /**
     * 감정관리 신규 추가 페이지로 이동합니다. (appraisalList.html)
     * */
    @GetMapping("/appraisal")
    public String getAppraisalNew(Model model) {
        model.addAttribute("yearOptions", gson.toJson(selectOptionUtils.generateYearOptions()));
        model.addAttribute("courtOptions", gson.toJson(selectOptionUtils.generateCategoryMap(COURT_CATEGORY_ID)));
        model.addAttribute("appraisalCategoryOptions", gson.toJson(selectOptionUtils.generateCategoryMap(APPRAISAL_CATEGORY_ID)));
        model.addAttribute("partiesOptions", gson.toJson(selectOptionUtils.generateCategoryMap(PARTIES_CATEGORY_ID)));
        model.addAttribute("feeOptions", gson.toJson(selectOptionUtils.generateCategoryMap(FEE_CATEGORY_ID)));

        return "pages/appraisal/appraisalNew";
    }

    /**
     * 신규 감정관리를 추가합니다. (appraisalNew.js)
     * */
    @PostMapping("/appraisal")
    public String saveAppraisal(@RequestBody AppraisalCreateDto requestDto) {
        Appraisal appraisal = appraisalService.saveAppraisal(requestDto);
        partiesService.savePartiesList(requestDto.getPartiesList(), appraisal);
        appraisalFeeService.saveAppraisalFeeList(requestDto.getAppraisalFeeList(), appraisal);

        return "redirect:/appraisal/all?page=1";
    }

    /**
     * 감정관리를 수정합니다. (appraisalNew.js)
     * */
    @ResponseBody
    @PutMapping("/appraisal/{id}")
    public AppraisalDto updateAppraisalById(@PathVariable Long id, @RequestBody AppraisalUpdateDto requestDto) {
        Appraisal appraisal = appraisalService.updateAppraisal(id, requestDto);
        return AppraisalDto.fromEntity(appraisal);
    }

//    @ResponseBody
//    @GetMapping("/info/options")
//    public ResponseEntity<?> getOptions(@RequestParam Long id) {
//        Map<Long, String> options = selectOptionUtils.generateOptions(id);
//        return ResponseEntity.ok(options);
//    }
}
