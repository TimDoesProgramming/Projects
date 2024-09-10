package com.portfolio.website.Selenium.scraper.crawler;



import com.portfolio.website.Selenium.scraper.by.ByFactory;
import com.portfolio.website.Selenium.scraper.drivers.ScrapeManager;
import com.portfolio.website.Selenium.scraper.enums.CommonAttributes;
import com.portfolio.website.Selenium.scraper.enums.CommonTags;
import com.portfolio.website.Selenium.scraper.page.Page;
import com.portfolio.website.model.Link;
import com.portfolio.website.service.LinkService;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class CrawlingManager {

    String id;
    private CrawlingQueue<Link> urlsToCrawl;

    private ScrapeManager scraper;
    @Autowired
    LinkService linkService;
    public CrawlingManager(){
        scraper = new ScrapeManager();
        urlsToCrawl = new CrawlingQueue();
        id = generateId();
    }

    public void startCrawling(String baseUrl, int depth){
        Link link;
        scraper.setBaseUrl(baseUrl);
        scraper.getDriver().get(baseUrl);
        link = new Link(id, baseUrl, getLinkStrings());
        urlsToCrawl.add(link);

        for(int i = 0; i<depth; i++){

            linkService.saveLink(link);
 
        }

    }

    private String[] getLinkStrings(){
        List<WebElement> wes = scraper.scrape(CommonAttributes.HREF, 10);
        int size = wes.size();

        if(size>0){
            return wes.stream().map((we)-> we.getAttribute("href")).toArray(String[]::new);
        }
        return new String[0];
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
