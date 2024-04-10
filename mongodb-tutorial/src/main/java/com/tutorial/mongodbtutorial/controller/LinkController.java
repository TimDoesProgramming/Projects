package com.tutorial.mongodbtutorial.controller;

import com.tutorial.mongodbtutorial.model.Link;
import com.tutorial.mongodbtutorial.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class LinkController {
public final LinkService linkService;

public LinkController(LinkService linkService) {
    this.linkService = linkService;
}

    @PostMapping
    public ResponseEntity addLink(@RequestBody Link link){
        linkService.addLink(link);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
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

}
