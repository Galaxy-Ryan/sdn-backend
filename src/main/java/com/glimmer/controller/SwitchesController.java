package com.glimmer.controller;

import com.glimmer.service.SwitchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class SwitchesController {
    @Autowired
    private SwitchesService switchesService;
    @GetMapping("/switches")
    public String switches(){
        return switchesService.getSwitches();
    }

}
