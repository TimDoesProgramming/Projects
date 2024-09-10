package com.portfolio.website.service;

import com.portfolio.website.model.Link;
import com.portfolio.website.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
    public void saveLink(Link link){

        linkRepository.insert(link);
    }
    public void saveLink(List<Link> links){
        linkRepository.insert(links);

    }
    public Link getLinkByLink(String link){
        Link savedLink = linkRepository.findByLink(link)
                .orElseThrow(() -> new RuntimeException(
                        "Cannot Find Link by Link " + link));
        return savedLink;
    }
    public List<Link> getLinksByReferenceId(String referenceId){
        List<Link> savedLinks = linkRepository.findByReferenceId(referenceId)
                .orElseThrow(() -> new RuntimeException(
                        "Cannot Find Link by Reference ID " + referenceId));
        return savedLinks;
    }
}
