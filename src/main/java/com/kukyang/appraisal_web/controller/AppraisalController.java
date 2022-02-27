package com.kukyang.appraisal_web.controller;

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

    @GetMapping("/list")
    public String getAppraisalList(Model model) {

        return "pages/appraisal/appraisalList";
    }

    @GetMapping("/info/{id}")
    public String getAppraisalById(@PathVariable Long id) {

        return "pages/appraisal/appraisalInfo";
    }

    @GetMapping("/info")
    public String getAppraisalNew(Model model) {

        return "pages/appraisal/appraisalNew";
    }

}
