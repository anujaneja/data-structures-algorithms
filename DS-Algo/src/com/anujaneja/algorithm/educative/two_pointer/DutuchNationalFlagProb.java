package com.anujaneja.algorithm.educative.two_pointer;

import java.util.Arrays;

/**
 * National Dutch national flag
 *
 * https://leetcode.com/problems/sort-colors/
 */

public class DutuchNationalFlagProb {

    public static void sortColors(int[] nums) {
        if(nums==null || nums.length<=1) {
            return;
        }

        int low=0,high=nums.length-1;
        //low -> 0 , high -> 2
        int i=0;

        while(i<=high) {
            if(nums[i]==0) {
                swap(nums,i,low);
                i++;
                low++;
            } else if(nums[i]==1) {
                i++;
            } else {
                // nums[i] ==2 and nums[high] could be 0,1 so no increment
                swap(nums,i,high);
                high--;
            }
        }
    }

    public static void swap(int[] nums,int i,int j) {
        int t= nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static void main(String[] args) {

        int[] nums = null;

        // TEST CASE 1: Negative no element
        nums = new int[] {};
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));

        // TEST CASE 2: Negative null array
        nums = null;
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));

        // TEST CASE 3: Negative one element
        nums = new int[]{1};
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));


        // TEST CASE 4: Postive
        nums = new int[]{0,1};
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));


        // TEST CASE 5: Positive
        nums = new int[]{0,1,2};
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));

        // TEST CASE 6: Positive
        nums = new int[]{2,0,1};
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));


        // TEST CASE 7: Positive
        nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));

        // TEST CASE 8: Positive
        nums = new int[]{2,2,2,2,0,0,0,0,2,1,1,1,1,1,1};
        sortColors(nums);
        System.out.println("Array after sort: "+ Arrays.toString(nums));

    }
}
