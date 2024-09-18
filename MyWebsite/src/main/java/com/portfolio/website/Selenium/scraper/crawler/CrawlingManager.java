package com.portfolio.website.Selenium.scraper.crawler;



import com.portfolio.website.Selenium.scraper.drivers.ScrapeManager;
import com.portfolio.website.Selenium.scraper.enums.CommonAttributes;
import com.portfolio.website.model.Link;
import com.portfolio.website.service.LinkService;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class CrawlingManager {

    private String referenceId;
    private CrawlingQueue<Link> urlsToCrawl;

    private ScrapeManager scraper;

    private LinkService linkService;
    public CrawlingManager(LinkService linkService){
        scraper = new ScrapeManager();
        urlsToCrawl = new CrawlingQueue<Link>();
        referenceId = generateId();
        this.linkService = linkService;
    }
//The link service is null because it is not being injected by Spring. This is a problem because the link service is used in the startCrawling method.
    // Will need to refactor the code to work in the queue service
    public String startCrawling(String baseUrl, int depth){
        Link link;
        scraper.setBaseUrl(baseUrl);
        scraper.getDriver().get(baseUrl);
        link = new Link(referenceId, baseUrl, getLinkStrings());
        linkService.saveLink(link);
        urlsToCrawl.add(link);

        for(int i = 0; i<depth; i++){

            for(Link nextLink : urlsToCrawl.poll()){
                for(String nextURL : nextLink.getScrapedURLs()){
                    scraper.getDriver().get(nextURL);
                    link = new Link(referenceId, nextURL, getLinkStrings());
                    linkService.saveLink(link);
                    urlsToCrawl.add(link);
                }
            }

 
        }
        return referenceId;
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
    public String getReferenceId(){
        return referenceId;
    }
    public String generateId(){
        return "Crawler-" + System.currentTimeMillis();
    }
}
