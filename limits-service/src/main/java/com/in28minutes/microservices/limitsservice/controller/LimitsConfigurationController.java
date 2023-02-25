package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.Configuration;
import com.in28minutes.microservices.limitsservice.bean.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimitsFromConfigurations() {
        return new Limits(configuration.getMaximum(), configuration.getMinimum());
    }
}
