package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy - https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(int i=0;i<nums.length;i++) {
            int currentNumber = nums[i];
            int n = subsets.size();
            for(int j=0;j<n;j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(currentNumber);
                subsets.add(set);
            }
        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
