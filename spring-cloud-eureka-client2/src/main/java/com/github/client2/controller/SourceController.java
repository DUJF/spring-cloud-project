package com.github.client2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dellll
 */
@RestController
public class SourceController {

    @GetMapping
    public String hello() {
        return "hello world2";
    }
}
