package com.portfolio.website.service;


import com.portfolio.website.model.BasicResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;



@Service
public class QueueService {

    public CompletableFuture<String> processRequest(BasicResponse request) {

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }


        return CompletableFuture.completedFuture("Request processed: " + request);
    }

}
