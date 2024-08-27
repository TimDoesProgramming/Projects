package com.portfolio.website.Selenium.scraper.crawler;



import com.portfolio.website.Selenium.scraper.page.Page;
import com.portfolio.website.model.Link;
import com.portfolio.website.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class CrawlingManager {
    Page currentPage;
    String id;
    private CrawlingQueue<Link> urlsToCrawl;
    private CrawlingQueue<CrawlingQueue<Link>> pagesToCrawl;
    @Autowired
    LinkService linkService;
    CrawlingManager(){
        currentPage = new Page();
        urlsToCrawl = new CrawlingQueue();
        id = generateId();
    }



    public void startCrawling(String baseUrl, int depth){
        currentPage.setBaseUrl(baseUrl);
        for(int i = 0; i<depth; i++){
            urlsToCrawl.add(currentPage.scrape(id));
 
        }

    }
    public void saveLink(Link link){
        linkService.saveLink(link);
    }
    public String getId(){
        return id;
    }
    public String generateId(){
        return "Crawler-" + System.currentTimeMillis();
    }
}
