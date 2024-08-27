package com.portfolio.website.Selenium.scraper.page;

import com.portfolio.website.Selenium.scraper.by.ByFactory;
import com.portfolio.website.Selenium.scraper.drivers.ScrapeManager;
import com.portfolio.website.Selenium.scraper.enums.CommonTags;
import com.portfolio.website.model.Link;
import org.openqa.selenium.WebElement;


import java.util.HashMap;
import java.util.List;

public class Page extends ScrapeManager {

    private String url;

    public  String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Page(){
        super();
        
    }
    /**
     * Constructor for Page
     * @param url
     */
    public Page(String url) {
        super(url);
        this.url = url;
        
    }

    /**
     * Scrapes a page and adds the scraped links to the linkAndScraped HashMap
     */
    public Link scrape(String refId){
        getDriver().get(this.url);
        return generateLink(this.url, refId);
    }

    /**
     * Scrapes a page and adds the scraped links to the linkAndScraped HashMap
     * @param url
     */
    public Link scrape(String url, String refId){
        driver.get(url);
        return generateLink(refId,url);
    }

    public Link generateLink(String refId, String url){
        List<WebElement> wes = driver.findElements(ByFactory.getByCommonTags(CommonTags.HREF));
        return new Link(refId, url, getLinks(wes));

    }
}
