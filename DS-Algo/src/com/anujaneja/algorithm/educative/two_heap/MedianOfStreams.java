package com.anujaneja.algorithm.educative.two_heap;

import java.util.PriorityQueue;

/**
 * Hard - https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianOfStreams {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfStreams() {
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>((a,b)->a-b);
    }

    public void insertNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek()>=num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size()>minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        } else if(maxHeap.size()<minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        double median = 0L;

        if(maxHeap.size()==minHeap.size()) {
            median = maxHeap.peek()/2.0+minHeap.peek()/2.0;
        } else {
            median = (double)maxHeap.peek();
        }

        return median;
    }

    public static void main(String[] args) {
        MedianOfStreams medianOfAStream = new MedianOfStreams();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
