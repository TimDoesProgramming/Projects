package com.portfolio.website.controller;

import com.portfolio.website.model.Link;
import com.portfolio.website.model.LinkResponse;
import com.portfolio.website.service.LinkService;
import com.portfolio.website.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
    public LinkResponse submitLink(@RequestParam(value = "baseUrl", required = false) String baseUrl,
                                    @RequestParam(value = "option", required = false) String option,
                                    @RequestParam(value = "depth", required = false) int depth) throws ExecutionException, InterruptedException {

        if(depth> 3){
            return new LinkResponse("ERROR", "Depth cannot be greater than 3", null);
        }
        // Handle the incoming data (e.g., log it, process it, etc.)
        System.out.println("Received option: " + option + "\nreceived link: " + baseUrl);

        LinkResponse linkResponse;

        linkResponse = new LinkResponse("SUCCESS","We went through a depth of " + depth, queueService.processScrape(baseUrl, depth).get());

        return linkResponse;
    }



}
