package com.glimmer.service.impl;

import com.glimmer.mapper.WhiteListMapper;
import com.glimmer.service.WhiteListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WhiteListServiceImpl implements WhiteListService {
    @Autowired
    private WhiteListMapper whiteListMapper;
}
