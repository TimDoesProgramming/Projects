package com.portfolio.website.controller;

import com.portfolio.website.model.Link;
import com.portfolio.website.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class LinkAPIController {
public final LinkService linkService;

public LinkAPIController(LinkService linkService) {
    this.linkService = linkService;
}

    @PostMapping
    public ResponseEntity addLink(@RequestBody Link link){
        linkService.addLink(link);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<Link>> getAllLinks(){

        return ResponseEntity.ok(linkService.getAllLinks());
    }
    @PutMapping("/update")
    public ResponseEntity updateLink(@RequestBody Link link){
        linkService.updateLink(link);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteLink(@PathVariable String id){
        linkService.deleteLink(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Link> getLinkByLink(@PathVariable String id){

        return ResponseEntity.ok(linkService.getLinkById(id));
    }
    @GetMapping("/submit")
    public Response submitOption(@RequestParam(value = "option", required = false) String option) {
        // Handle the incoming data (e.g., log it, process it, etc.)
        System.out.println("Received option: " + option);

        // Create a response
        Response response = new Response("Success", "Option received successfully "+
                option);
        return response;
    }

    class Response {
        private String status;
        private String message;

        public Response(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
