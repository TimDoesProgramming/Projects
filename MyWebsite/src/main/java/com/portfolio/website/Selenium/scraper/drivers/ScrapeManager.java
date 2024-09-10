package com.portfolio.website.Selenium.scraper.drivers;

import com.mongodb.internal.time.Timeout;
import com.portfolio.website.Selenium.scraper.by.ByFactory;
import com.portfolio.website.Selenium.scraper.enums.CommonAttributes;
import com.portfolio.website.Selenium.scraper.enums.CommonTags;
import com.portfolio.website.Selenium.scraper.enums.ICommon;
import com.portfolio.website.Selenium.scraper.page.Page;
import com.portfolio.website.model.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ScrapeManager extends Page {


    protected String baseUrl;

    /**
     * Constructor for ScrapeManager
     */
    public ScrapeManager() {
        super();
    }

    /**
     * Constructor for ScrapeManager
     *
     * @param baseUrl
     */
    public ScrapeManager(String baseUrl) {
        super();
        this.baseUrl = baseUrl;
    }



    public List<WebElement> scrape(ICommon common, int timeout) {
        By by = ByFactory.getByCommonBys(common);
        this.waitWithExpectedConditions(ExpectedConditions.presenceOfElementLocated(by), timeout);
        return this.getWebDriver().findElements(by);
    }
    public List<WebElement> scrape(ICommon common, String url, int timeout) {
        this.getDriver().get(url);
        return scrape(common, timeout);
    }


    public String getAttributeValue(WebElement we, CommonAttributes attribute) {
        return we.getAttribute(attribute.getAttribute());
    }

    public String[] getAttributeValues(List<WebElement> wes, CommonAttributes attribute) {
        int size = wes.size();
        if (size > 0) {
            return wes.stream().map((we) -> we.getAttribute(attribute.getAttribute())).toArray(String[]::new);
        }
        return new String[0];
    }

    /**
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


}
