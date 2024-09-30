package com.portfolio.website.model;

import java.util.List;

public class LinkResponse {


        private String status;
        private List<Link> links;

        public LinkResponse(String status, List<Link> message) {
            this.status = status;
            this.links = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<Link> getMessage() {
            return links;
        }

        public void setMessage(List<Link> message) {
            this.links = message;
        }


}
