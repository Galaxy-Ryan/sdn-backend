package com.glimmer.controller;

import com.glimmer.service.BlackListService;
import com.glimmer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
@Slf4j
public class BlackListController {
    @Autowired
    private BlackListService blackListService;
}
