package com.anujaneja.algorithm.educative.k_way_merge;

import java.util.*;

class LargestPairs {

    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> ((o1[0] + o1[1]) - (o2[0] + o2[1])));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(minHeap.size()<k) {
                    minHeap.add(new int[]{nums1[i],nums2[j]});
                } else {
                    //Terminating condition...
                    if((nums1[i]+nums2[j])<minHeap.peek()[0]+minHeap.peek()[1]) {
                        break;
                    } else {
                        minHeap.poll();
                        minHeap.offer(new int[]{nums1[i],nums2[j]});
                    }
                }
            }
        }


        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
