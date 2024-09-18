package com.portfolio.website.Selenium.scraper.crawler;

import java.util.*;

public class CrawlingQueue<T>{

    private LinkedList<T> currentQueue;
    private Queue<LinkedList<T>> currentDepthqueues;
    private Queue<LinkedList<T>> nextDepthQueues;

    public CrawlingQueue(){
        currentQueue = new LinkedList<T>();
        currentDepthqueues = new LinkedList<LinkedList<T>>();
        nextDepthQueues = new LinkedList<LinkedList<T>>();
    }

    public CrawlingQueue(int size){

        for(int i = 0; i<size; i++){
            if(i == 0){
                currentQueue = new LinkedList<>();
                currentDepthqueues = new LinkedList<LinkedList<T>>();
                nextDepthQueues = new LinkedList<LinkedList<T>>();
                currentDepthqueues.add(currentQueue);
            }else{
                currentDepthqueues.add(new LinkedList<>());
            }
        }
    }

    /**
     * Adds an item to the current queue
     * @param item
     */
    public void add(T item){
        if(currentDepthqueues == null || currentDepthqueues.isEmpty()){
            currentQueue = new LinkedList<T>();
            currentDepthqueues.add(currentQueue);
        }
        currentQueue.add(item);
    }
    public void addNextDepth(T item){
        if(currentDepthqueues == null || currentDepthqueues.isEmpty()){
            currentQueue = new LinkedList<T>();
            nextDepthQueues.add(currentQueue);
        }
        currentQueue.add(item);
    }
    /**
     * returns the next queue, will return null if there is no next queue
     *
     * @return the current queue
     */
    public Queue<T> poll(){
        Queue<T> queueToReturn = currentDepthqueues.poll();
        currentQueue = currentDepthqueues.peek();
        return queueToReturn;
    }

    /**
     * Adds a queue to the list of queues
     * @param queue
     */
    public void addQueue(LinkedList<T> queue){
        currentDepthqueues.add(queue);
    }

    public int getVolume(){
        return currentQueue.size();
    }

}
