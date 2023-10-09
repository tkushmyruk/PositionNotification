package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("cookie", positionService.cookie);
        return "mainPage";
    }

    @PostMapping("/")
    public String changeJobStatus(Model model) {
        model.addAttribute("jobEnabled", positionService.isJobEnabled);
        positionService.enableJob();
        return "redirect:/";
    }

    @PostMapping("/cookie")
    public String setCookie(@RequestParam String cookie){
        positionService.cookie = cookie;
        return "redirect:/";
    }


}
