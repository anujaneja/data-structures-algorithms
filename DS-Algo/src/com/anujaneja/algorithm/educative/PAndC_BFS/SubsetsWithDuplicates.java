package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium - https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>()); //Adding an empty one...

        int startIndex = 0, endIndex = 0;

        for (int i=0;i<nums.length;i++) {
            int currNum = nums[i];
            //Found a duplicates
            if(i>0 && nums[i]==nums[i-1]) {
                startIndex = endIndex+1;
            } else {
                //in case of no duplicate it should start from 0th index...
                startIndex = 0;
            }
            endIndex = subsets.size()-1;

            for(int j = startIndex;j<=endIndex;j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(currNum);
                subsets.add(set);
            }
        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
