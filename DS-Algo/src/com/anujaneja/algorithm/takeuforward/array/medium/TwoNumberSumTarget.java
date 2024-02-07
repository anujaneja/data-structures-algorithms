package com.anujaneja.algorithm.takeuforward.array.medium;

import java.util.HashMap;

/*
    Easy: LC: https://leetcode.com/problems/two-sum/submissions/
 */
class TwoNumberSumTarget {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numIndexes = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(numIndexes.containsKey(target-nums[i])) {
                return new int[]{numIndexes.get(target-nums[i]),i};
            }

            numIndexes.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}