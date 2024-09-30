package com.portfolio.website.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//Document annotation is used to define the name of the collection in MongoDB
@Document("Links")
public class Link {
    @Id
    private String id;
    @Field("baseUrl")
    private String baseUrl;
    @Field("scrapedURLs")
    private String[] scrapedURLs;

    @Field("referenceId")
    private String referenceId;

    public Link(String referenceId, String baseUrl, String[] scrapedURLs){
        this.baseUrl = baseUrl;
        this.scrapedURLs = scrapedURLs;
        this.referenceId = referenceId;
    }
    public String getId() {
        return id;
    }
    public String getBaseUrl() {
        return baseUrl;
    }

    public String getReferenceId() {return referenceId;}
    public String[] getScrapedURLs() {
        return scrapedURLs;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public void setScrapedURLs(String[] scrapedURLs) {
        this.scrapedURLs = scrapedURLs;
    }
    public void setReferenceId(String referenceId) {this.referenceId = referenceId;}
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, link='%s', scrapedLinks='%s']",
                id, baseUrl, scrapedURLs);
    }
}
