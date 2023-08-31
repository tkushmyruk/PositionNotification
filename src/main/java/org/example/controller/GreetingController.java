package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class GreetingController {
    private PositionService positionService;

    @Autowired
    public GreetingController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        log.info("greeting");
        model.addAttribute("jobEnabled", positionService.isJobEnabled);
        return "main";
    }

    @PostMapping("/")
    public String toggleJobStatus(Model model) {
        model.addAttribute("jobEnabled", positionService.isJobEnabled);
        positionService.enableJob();
        return "main";
    }


}
