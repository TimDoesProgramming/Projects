package com.portfolio.website.Selenium.scraper.enums;

public enum CommonAttributes implements ICommon {
    HREF("href"),
    VALUE("value"),
    CLASS("class"),
    STYLE("style"),
    ID("id"),
    SRC("src"),
    TYPE("type"),
    TITLE("title");

    String attribute;
    CommonAttributes(String attribute){
        this.attribute = attribute;
    }
    public String getAttribute(){
        return attribute;
    }
}
