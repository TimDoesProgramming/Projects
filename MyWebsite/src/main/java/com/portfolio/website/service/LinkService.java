package com.portfolio.website.service;

import com.portfolio.website.model.Link;
import com.portfolio.website.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public void addLink(Link link){
        linkRepository.insert(link);
    }

    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }
    public void updateLink(Link link){
        Link savedLink = linkRepository.findById(link.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Link by ID %s", link.getId())));
        savedLink.setLink(link.getLink());
        savedLink.setScrapedURLs(link.getScrapedURLs());

        linkRepository.save(link);
    }
    public void deleteLink(String id){
        linkRepository.deleteById(id);
    }
    public Link getLinkById(String id){
        Link savedLink = linkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Cannot Find Link by ID " + id));
        return savedLink;
    }
}
