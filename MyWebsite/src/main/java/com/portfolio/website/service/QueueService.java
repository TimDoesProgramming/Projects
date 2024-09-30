package com.portfolio.website.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.portfolio.website.Selenium.scraper.crawler.CrawlingManager;
import com.portfolio.website.Selenium.scraper.drivers.ScrapeManager;
import com.portfolio.website.model.BasicResponse;
import com.portfolio.website.model.Link;
import com.portfolio.website.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;



@Service
public class QueueService {

    @Autowired
    LinkService linkService;
    @Autowired
    LinkRepository linkRepository;
    public CompletableFuture<List<Link>> processScrape(String url) {
        CrawlingManager crawlingManager = new CrawlingManager(linkService);
        ObjectMapper mapper = new ObjectMapper();
        List<Link> links = null;
        try{
            links = linkRepository.findByReferenceId(crawlingManager.startCrawling(url, 1)).get();

        } catch (Exception e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(links);
    }

}
