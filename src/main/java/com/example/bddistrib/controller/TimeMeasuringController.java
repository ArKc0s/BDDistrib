package com.example.bddistrib.controller;

import com.example.bddistrib.service.TimeMeasuringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time")
public class TimeMeasuringController {

    @Autowired
    private TimeMeasuringService timeMeasuringService;

    @GetMapping("/find/all")
    public String getTime() {
        return "Time to find all items (" + timeMeasuringService.getRows() + ") : " + timeMeasuringService.measureTime() + " ms";
    }

}
