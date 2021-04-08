package com.anujaneja.algorithm.educative.binarySearch;

/**
 * Easy - https://leetcode.com/problems/binary-search/
 *
 */
public class OrderAgnosticBinarySearch {

    public static int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        boolean isAsc = nums[start]<nums[end];

        while(start<=end) {
            int mid = start+(end-start)/2;

            if(nums[mid]==target) {
                return mid;
            } else if(isAsc) {
                if(target<nums[mid]) {
                    end=mid-1;
                } else {
                    start=mid+1;
                }
            } else{
                if(target>nums[mid]) {
                    end=mid-1;
                } else {
                    start=mid+1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(OrderAgnosticBinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(OrderAgnosticBinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(OrderAgnosticBinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(OrderAgnosticBinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}
