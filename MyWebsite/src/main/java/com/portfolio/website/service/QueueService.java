package com.portfolio.website.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.portfolio.website.Selenium.scraper.crawler.CrawlingManager;
import com.portfolio.website.Selenium.scraper.drivers.ScrapeManager;
import com.portfolio.website.model.BasicResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;



@Service
public class QueueService {

    public CompletableFuture<ObjectNode> processScrape(String url) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode request = objectMapper.createObjectNode();
        CrawlingManager crawlingManager = new CrawlingManager();
        try{

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }


        return CompletableFuture.completedFuture(request);
    }

}
