package com.portfolio.website.Selenium.scraper.crawler;

import net.bytebuddy.implementation.bytecode.Throw;

import java.util.*;

public class CrawlingQueue<T>{

    private Queue<T> currentQueue;
    private Queue<Queue<T>> queues;

    public CrawlingQueue(){
        currentQueue = new PriorityQueue<T>();
    }

    /**
     * Adds an item to the current queue
     * @param item
     */
    public void add(T item){
        currentQueue.add(item);
    }

    /**
     * returns the next queue
     *
     * @return the current queue
     */
    public Queue<T> poll(){
        return queues.poll();
    }

    /**
     * Adds a queue to the list of queues
     * @param queue
     */
    public void addQueue(Queue<T> queue){
        queues.add(queue);
    }


}
