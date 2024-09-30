package com.portfolio.website.Selenium.scraper.crawler;



import com.portfolio.website.Selenium.scraper.drivers.ScrapeManager;
import com.portfolio.website.model.Link;
import com.portfolio.website.service.LinkService;

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
        link = new Link(referenceId, baseUrl, null);
        urlsToCrawl.add(link);

        for(int i = 0; i<depth; i++){
            for(Link nextLink : urlsToCrawl.getCurrentQueue()){
                scrapeAndSave(nextLink);
                if(i < depth-1)
                    for(String nextURL : nextLink.getScrapedURLs()){
                        urlsToCrawl.addNextQueue(new Link(referenceId, nextURL, null));
                    }
            }
            urlsToCrawl.switchQueues();
        }
        scraper.quit();
        return referenceId;
    }
    private void scrapeAndSave(Link link){
        String scrapedUrls[];

        scraper.getDriver().get(link.getBaseUrl());
        if((scrapedUrls = scraper.scrapeUrls()) != null && scrapedUrls.length >0) {
            link.setScrapedURLs(scrapedUrls);
            linkService.saveLink(link);
        }
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
