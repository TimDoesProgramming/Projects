package com.portfolio.website.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//Document annotation is used to define the name of the collection in MongoDB
@Document("Links")
public class Link {
    @Id
    private String id;
    @Field("link")
    private String link;
    @Field("scrapedURLs")
    private String[] scrapedURLs;

    @Field("referenceId")
    private String referenceId;

    public Link(String referenceId, String link, String[] scrapedURLs){
        this.link = link;
        this.scrapedURLs = scrapedURLs;
        this.referenceId = referenceId;
    }
    public String getId() {
        return id;
    }
    public String getLink() {
        return link;
    }

    public String getReferenceId() {return referenceId;}
    public String[] getScrapedURLs() {
        return scrapedURLs;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public void setScrapedURLs(String[] scrapedURLs) {
        this.scrapedURLs = scrapedURLs;
    }
    public void setReferenceId(String referenceId) {this.referenceId = referenceId;}
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, link='%s', scrapedLinks='%s']",
                id, link, scrapedURLs);
    }
}
