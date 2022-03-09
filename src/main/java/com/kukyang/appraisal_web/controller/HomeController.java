package com.kukyang.appraisal_web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping
    public String homePage() {
        return "redirect:/appraisal";
    }
}
