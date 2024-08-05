package com.portfolio.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/scraper")
    public String projects() {
        return "scraper";
    }
    @GetMapping("/networkManager")
    public String networkManager() {
        return "networkManager";
    }
}
