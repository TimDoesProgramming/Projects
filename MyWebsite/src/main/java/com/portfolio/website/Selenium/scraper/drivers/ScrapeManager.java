package com.portfolio.website.Selenium.scraper.drivers;

import com.portfolio.website.service.LinkService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ScrapeManager extends DriverManager {



    protected WebDriver driver;
    protected String baseUrl;



    /**
     * Constructor for ScrapeManager
     */
    public ScrapeManager(){
        super();
        this.driver = getDriver();
    }

    /**
     * Constructor for ScrapeManager
     * @param baseUrl
     */
    public ScrapeManager(String baseUrl){
        super();
        this.driver = getDriver();
        this.baseUrl = baseUrl;
    }

    /**
     * Scrapes a page and adds the scraped links to the linkAndScraped HashMap for the given url
     * @param we
     * @return
     */
    public String getLink(WebElement we){
        return we.getAttribute("href");

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

    /**
     *
     * @return
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public WebDriver getDriver() {
        return getWebDriver();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }



}
