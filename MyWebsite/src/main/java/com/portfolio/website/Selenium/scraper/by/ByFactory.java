package com.portfolio.website.Selenium.scraper.by;

import org.openqa.selenium.By;
import com.portfolio.website.Selenium.scraper.enums.CommonTags;
import java.util.ArrayList;
import java.util.List;

public class ByFactory {

    public static By getByCommonTags(CommonTags ct){

        switch (ct){
            case HREF -> {return new By.ByCssSelector("[href]");}
            case A -> {return new By.ByTagName("a");}
            case P ->{return new By.ByTagName("p");}
            case H1 -> {return new By.ByTagName("h1");}
            case H2 -> {return  new By.ByTagName("h2");}
            case H3 -> {return new By.ByTagName("h3");}
            case TITLE -> {return new By.ByTagName("title");}
            default -> {return null;}
        }
    }
    public static List<By> getByCommonTags (CommonTags... cts){
       List<By> commonTagsList = new ArrayList<By>();
        for(CommonTags ct : cts){
            commonTagsList.add(getByCommonTags(ct));
        }
        return commonTagsList;
    }
    public static By getByCssSelector(String selector){
        return By.cssSelector(selector);
    }


}
