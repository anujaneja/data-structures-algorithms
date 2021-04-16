package com.anujaneja.algorithm.educative.top_elements;

import java.util.*;

/**
 * Easy - https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 * Medium - https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */
class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        int totalCost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < ropeLengths.length; i++) {
            minHeap.offer(ropeLengths[i]);
        }

        while (minHeap.size() >= 2) {
            int currentJoinCost = minHeap.poll() + minHeap.poll();
            totalCost = totalCost + currentJoinCost;
            minHeap.offer(currentJoinCost);

        }

        return totalCost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}