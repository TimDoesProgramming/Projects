package com.portfolio.website.model;

import java.util.List;

public class LinkResponse {


    private String status;
    private List<Link> links;
    private String message;


    public LinkResponse(String status, String message, List<Link> links) {
        this.status = status;
        this.links = links;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Link> getlinks() {
        return links;
    }

    public void setlinks(List<Link> message) {
        this.links = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
