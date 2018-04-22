package com.kennyk65.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdjectiveController {

    @Value("${words}")
    private String[] words;

    @GetMapping("/adjective")
    @ResponseBody
    public String getAdjective() {

        return words[(int) (Math.random() * words.length)];
    }
}
