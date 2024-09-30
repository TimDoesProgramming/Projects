package com.portfolio.website.Selenium.scraper.crawler;

import java.util.*;

public class CrawlingQueue<T> {

    private Queue<T> currentQueue;
    private Queue<T> nextQueue;


    public CrawlingQueue(){
        currentQueue = new LinkedList<T>();
    }


    /**
     * Adds an item to the current queue
     * @param item
     */
    public void add(T item){
        if(currentQueue == null || currentQueue.isEmpty()){
            currentQueue = new LinkedList<T>();
        }
        currentQueue.add(item);
    }



    public void addNextQueue(T item){
        if(nextQueue == null || currentQueue.isEmpty()){
            nextQueue = new LinkedList<T>();
        }
        nextQueue.add(item);
    }
    /**
     * returns the next queue, will return null if there is no next queue
     *
     * @return the current queue
     */
    public T poll(){
        return currentQueue.poll();

    }
    public void switchQueues(){
        currentQueue = nextQueue;
        nextQueue = new LinkedList<T>();
    }

    public int getVolume(){
        return currentQueue.size();
    }
    public int getNextVolume(){
        return nextQueue.size();
    }

    public Queue<T> getCurrentQueue() {
        return currentQueue;
    }

    public Queue<T> getNextQueue() {
        return nextQueue;
    }
}
