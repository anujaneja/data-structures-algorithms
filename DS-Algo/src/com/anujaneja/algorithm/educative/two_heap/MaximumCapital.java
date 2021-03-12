package com.anujaneja.algorithm.educative.two_heap;

import java.util.PriorityQueue;

/**
 * Hard - https://leetcode.com/problems/ipo/
 * Min-Heap and Max-Heap pattern...
 */
class Pair {
    int profit;
    int capital;

    public Pair(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

public class MaximumCapital {

    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        PriorityQueue<Pair> minCapitalHeap = new PriorityQueue<>((a,b)->(a.capital-b.capital));
        PriorityQueue<Pair> maxCapitalHeap = new PriorityQueue<>((a,b)->(b.profit-a.profit));

        for(int i=0;i<capital.length;i++) {
            minCapitalHeap.offer(new Pair(profits[i],capital[i]));
        }

        int availableCapital = initialCapital;

        for(int i=0;i<numberOfProjects;i++) {
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital<=availableCapital) {
                maxCapitalHeap.offer(minCapitalHeap.poll());
            }

            if(maxCapitalHeap.isEmpty()) {
                break;
            }

            availableCapital += maxCapitalHeap.poll().profit;
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximumCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximumCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
