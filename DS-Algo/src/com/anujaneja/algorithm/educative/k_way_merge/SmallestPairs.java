package com.anujaneja.algorithm.educative.k_way_merge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Medium - https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
class SmallestPairs {

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> ((o2[0] + o2[1]) - (o1[0] + o1[1])));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(maxHeap.size()<k) {
                    maxHeap.add(new int[]{nums1[i],nums2[j]});
                } else {
                    //Terminating condition...
                    if((nums1[i]+nums2[j])>maxHeap.peek()[0]+maxHeap.peek()[1]) {
                        break;
                    } else {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i],nums2[j]});
                    }
                }
            }
        }


        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 1,7,11};
        int[] l2 = new int[] { 2,4,6 };
        List<int[]> result = SmallestPairs.kSmallestPairs(l1, l2, 3);
        System.out.print("Pairs with smallest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
