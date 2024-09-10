package com.portfolio.website.Selenium.scraper.drivers;

import com.portfolio.website.utils.OsUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriverManager {
    private static WebDriver webDriver = null;

    private static char ls = File.separatorChar;
    private static String resourcePath = ""+ls+"src"+ls+"main"+ls+"resources" + ls+"drivers"+ ls+"chromedriver.exe";
    private static String driverPathWindows = ""+ls+"src"+ls+"main"+ls+"resources" + ls+"drivers"+ ls+"windows"+ls+"chrome-win64"+ls+"chrome-win64"+ls+"chrome.exe";
    private static String driverPathLinux = ""+ls+"src"+ls+"main"+ls+"resources" + ls+"drivers"+ ls+"linux"+ls+"chrome-win64"+ls+"chrome-win64"+ls+"chrome.exe";

    /**
     * Constructor for DriverManager
     */
    public DriverManager(){
    }

    public static WebDriver getWebDriver(){
        WebElement we;

        if (webDriver != null){
            return webDriver;
        }
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path + resourcePath);
        webDriver = new ChromeDriver(getChromeOptions());
        return webDriver;

    }
    public void waitWithExpectedConditions(ExpectedCondition ec, int timeout){
        try{
            new WebDriverWait(webDriver, Duration.ofSeconds(timeout)).until(ec);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Constructor for DriverManager
     */
    private static ChromeOptions getChromeOptions(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless=new");
        if(OsUtils.isWindows()) {
            co.setBinary(driverPathWindows);
        }else if(OsUtils.isLinux()){
            co.setBinary(driverPathLinux);
        }
        return co;
    }
    public void quit(){
        if(webDriver != null)
            webDriver.quit();
    }

}
