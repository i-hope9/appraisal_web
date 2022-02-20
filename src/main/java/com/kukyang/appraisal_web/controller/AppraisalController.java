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

    @GetMapping
    public String getAppraisals(Model model) {

        return "pages/appraisal/appraisalMain";
    }

    @GetMapping("/{id}")
    public String getAppraisalById(@PathVariable Long id) {

        return "pages/appraisal/appraisalDetails";
    }

}
