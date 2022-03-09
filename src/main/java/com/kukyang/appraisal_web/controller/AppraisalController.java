package com.kukyang.appraisal_web.controller;

import com.kukyang.appraisal_web.utils.SelectOptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appraisal")
@RequiredArgsConstructor
public class AppraisalController {
    private final SelectOptionUtils selectOptionUtils;

    @GetMapping("/all")
    public String getAppraisalList(Model model) {

        return "pages/appraisal/appraisalList";
    }

    @GetMapping("/info/{id}")
    public String getAppraisalById(@PathVariable Long id) {

        return "pages/appraisal/appraisalInfo";
    }

    @GetMapping("/info")
    public String getAppraisalNew(Model model) {
        // 연도
        model.addAttribute("years", selectOptionUtils.generateYearOptions());
        // 법원
        model.addAttribute("courts", selectOptionUtils.generateCourtOptions());
        // 감정구분
        model.addAttribute("appraisalCategories", selectOptionUtils.generateAppraisalOptions());
        // 당사자
        model.addAttribute("partiesCategories", selectOptionUtils.generatePartiesOptions());
        // 감정료
        model.addAttribute("feeCategories", selectOptionUtils.generateFeeOptions());

        return "pages/appraisal/appraisalNew";
    }

}
