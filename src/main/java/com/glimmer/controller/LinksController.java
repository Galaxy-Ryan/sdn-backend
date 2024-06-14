package com.glimmer.controller;

import com.glimmer.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class LinksController {
    @Autowired
    private LinksService linksService;

    @GetMapping("/links")
    public String Links(){
        return linksService.getLinks();
    }
}
