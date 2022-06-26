package com.colossus.projectmanagement.controller;

import com.colossus.projectmanagement.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ApiController {

    private final ApiService service;

    public ApiController(ApiService service) {
        this.service = service;
    }

    @GetMapping("/api/month")
    public String getApiReportForPreviousMonth(){

        return service.getPreviousMonthReport();
    }
}
