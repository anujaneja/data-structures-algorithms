package com.anujaneja.algorithm.educative.two_pointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumSortedOrder {
    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end=nums.length-1;

        while(start<end) {
            if(nums[start]+nums[end]==target) {
                return new int[]{start+1,end+1};
            } else if(nums[start]+nums[end]>target) {
                end--;
            } else if(nums[start]+nums[end]<target){
                start++;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0};
        int target = -1;

        System.out.println("indexs: "+ Arrays.toString(twoSum(nums,target)));

        nums = new int[]{2,7,11,15};
        target = 9;

        System.out.println("indexs: "+ Arrays.toString(twoSum(nums,target)));
    }
}
