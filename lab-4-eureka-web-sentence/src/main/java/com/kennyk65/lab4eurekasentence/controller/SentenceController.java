package com.kennyk65.lab4eurekasentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/sentence")
    @ResponseBody
    public String getSentence() {

        return String.format(
                "%s %s %s %s %s.",
                getWord("LAB-4-SUBJECT", "subject"),
                getWord("LAB-4-VERB", "verb"),
                getWord("LAB-4-ARTICLE", "article"),
                getWord("LAB-4-ADJECTIVE", "adjective"),
                getWord("LAB-4-NOUN", "noun")
        );
    }

    private String getWord(String service, String path) {

        List<ServiceInstance> list = client.getInstances(service);

        if (list != null && list.size() > 0) {

            URI uri = list.get(0).getUri();
            if (uri != null) {

                return (new RestTemplate()).getForObject(String.format("%s/%s", uri, path), String.class);
            }
        }
        return null;
    }
}
