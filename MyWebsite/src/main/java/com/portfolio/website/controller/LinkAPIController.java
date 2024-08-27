package com.portfolio.website.controller;

import com.portfolio.website.model.BasicResponse;
import com.portfolio.website.model.Link;
import com.portfolio.website.service.LinkService;
import com.portfolio.website.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("/api/link")
public class LinkAPIController {

    private LinkService linkService;

    private QueueService queueService;

    @Autowired
    public LinkAPIController(LinkService linkService, QueueService queueService) {
        this.linkService = linkService;
        this.queueService = queueService;
    }


    @PostMapping
    public ResponseEntity addLink(@RequestBody Link link) {
        linkService.addLink(link);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Link>> getAllLinks() {

        return ResponseEntity.ok(linkService.getAllLinks());
    }

    @PutMapping("/update")
    public ResponseEntity updateLink(@RequestBody Link link) {
        linkService.updateLink(link);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLink(@PathVariable String id) {
        linkService.deleteLink(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Link> getLinkByLink(@PathVariable String id) {

        return ResponseEntity.ok(linkService.getLinkById(id));
    }

    @GetMapping("/submitLink")
    public BasicResponse submitLink(@RequestParam(value = "link", required = false) String link,
                                    @RequestParam(value = "option", required = false) String option) throws ExecutionException, InterruptedException {
        // Handle the incoming data (e.g., log it, process it, etc.)
        System.out.println("Received option: " + option + "\nreceived link: " + link);
        BasicResponse response;

        // Handle the incoming data (e.g., log it, process it, etc.)
        switch (option) {
            case "1":
                response = new BasicResponse("Success", "HI CHRISTINE!" + "\n" + link);
                break;
            case "2":
                response = new BasicResponse("Success", "BYE CHRISTINE" + "\n" + link);
                break;
            case "3":
                response = new BasicResponse("Success", "Nobody can poop like Christine" + "\n" + link);
                break;
            case "4":
                response = new BasicResponse("Success", "GET NAYNAYED ON" + "\n" + link);
                break;
            default:
                response = new BasicResponse("ERROR", "Invalid option selected" + "\n" + link);
                break;
        }



        return queueService.processRequest(response).get();
    }



}
