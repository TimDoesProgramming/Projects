package com.portfolio.website.Selenium.scraper.page;

import com.portfolio.website.Selenium.scraper.by.ByFactory;
import com.portfolio.website.Selenium.scraper.drivers.DriverManager;
import com.portfolio.website.Selenium.scraper.enums.CommonTags;
import com.portfolio.website.model.Link;
import org.openqa.selenium.WebElement;


import java.util.List;

public class Page extends DriverManager {

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
        super();
        this.url = url;
        
    }



    /**
     * Scrapes a page and adds the scraped links to the linkAndScraped HashMap
     * @param wes
     * @return
     */
    public String[] getLinks(List<WebElement> wes){
        String[] links = new String[0];
        int size = wes.size();

        if(size>0){
            return wes.stream().map((we)-> we.getAttribute("href")).toArray(String[]::new);
        }
        return links;
    }
}
