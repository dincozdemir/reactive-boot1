package com.dinco.reactiveboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dinco-WORK on 19.05.2017.
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.html.test";
    }
}