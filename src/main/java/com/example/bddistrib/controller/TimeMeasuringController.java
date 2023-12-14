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
        String line1 = "Time to find all items (" + timeMeasuringService.getRows() + ") : " + timeMeasuringService.measureTimeForAll() + " ms";
        String line2 = "Time to find all items from France (" + timeMeasuringService.getRowsFr() + ") : " + timeMeasuringService.measureTimeForFr() + " ms";
        String line3 = "Time to find all items from Great Britain (" + timeMeasuringService.getRowsGb() + ") : " + timeMeasuringService.measureTimeForGB() + " ms";

        return line1 + "<br>" + line2 + "<br>" + line3;
    }

}
