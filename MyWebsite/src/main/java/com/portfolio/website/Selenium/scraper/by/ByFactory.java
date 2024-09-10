package com.portfolio.website.Selenium.scraper.by;

import com.portfolio.website.Selenium.scraper.enums.CommonAttributes;
import com.portfolio.website.Selenium.scraper.enums.ICommon;
import org.openqa.selenium.By;
import com.portfolio.website.Selenium.scraper.enums.CommonTags;
import java.util.ArrayList;
import java.util.List;

public class ByFactory {

    public static By getByCommonTagBys(CommonTags ct){

        switch (ct){
            case A -> {return new By.ByTagName("a");}
            case P ->{return new By.ByTagName("p");}
            case H1 -> {return new By.ByTagName("h1");}
            case H2 -> {return  new By.ByTagName("h2");}
            case H3 -> {return new By.ByTagName("h3");}
            case TITLE -> {return new By.ByTagName("title");}
            default -> {return null;}
        }
    }
    public static List<By> getByCommonTagBys(CommonTags... cts){
       List<By> commonTagsList = new ArrayList<By>();
        for(CommonTags ct : cts){
            commonTagsList.add(getByCommonTagBys(ct));
        }
        return commonTagsList;
    }
    public static By getByCommonAttributeBys(CommonAttributes ca){
        switch (ca){
            case HREF -> {return By.cssSelector("href");}
            case VALUE -> {return By.cssSelector("value");}
            case CLASS -> {return  By.cssSelector("class");}
            case STYLE -> {return By.cssSelector("style");}
            case ID -> {return By.cssSelector("id");}
            case SRC -> {return By.cssSelector("src");}
            case TYPE -> {return By.cssSelector("type");}
            case TITLE -> {return By.cssSelector("title");}
            default -> {return null;}
        }

    }
    public static By getByCssSelector(String selector){
        return By.cssSelector(selector);
    }


    public static By getByCommonBys(ICommon common) {
        if(common instanceof CommonTags){
            return getByCommonTagBys((CommonTags) common);
        }else if(common instanceof CommonAttributes){
            return getByCommonAttributeBys((CommonAttributes) common);
        }
        return null;
    }
}
