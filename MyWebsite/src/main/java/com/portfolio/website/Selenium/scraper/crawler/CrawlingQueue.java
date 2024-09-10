package com.portfolio.website.Selenium.scraper.crawler;

import net.bytebuddy.implementation.bytecode.Throw;

import java.util.*;

public class CrawlingQueue<T>{

    private Queue<T> currentQueue;
    private Queue<Queue<T>> queues;

    public CrawlingQueue(){
        currentQueue = new PriorityQueue<T>();
    }

    public CrawlingQueue(int size){

        for(int i = 0; i<size; i++){
            if(i == 0){
                currentQueue = new PriorityQueue<T>();
                queues.add(currentQueue);
            }else{
                queues.add(new PriorityQueue<T>());
            }
        }
    }

    /**
     * Adds an item to the current queue
     * @param item
     */
    public void add(T item){
        if(queues.isEmpty()){
            currentQueue = new PriorityQueue<T>();
        }
        currentQueue.add(item);
    }

    /**
     * returns the next queue, will return null if there is no next queue
     *
     * @return the current queue
     */
    public Queue<T> poll(){
        Queue<T> queueToReturn = queues.poll();
        currentQueue = queues.peek();
        return queueToReturn;
    }

    /**
     * Adds a queue to the list of queues
     * @param queue
     */
    public void addQueue(Queue<T> queue){
        queues.add(queue);
    }

    public int getVolume(){
        return currentQueue.size();
    }

}
