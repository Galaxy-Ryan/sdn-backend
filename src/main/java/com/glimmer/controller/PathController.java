package com.glimmer.controller;

import com.glimmer.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class PathController {
    @Autowired
    private PathService pathService;

    @GetMapping("/paths")
    public String paths(){
        return pathService.getPaths();
    }
}
