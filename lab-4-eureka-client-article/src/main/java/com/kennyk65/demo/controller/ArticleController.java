package com.kennyk65.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Value("${words}")
    private String[] words;

    @GetMapping("/article")
    @ResponseBody
    public String getArticle() {

        return words[(int) (Math.random() * words.length)];
    }
}
