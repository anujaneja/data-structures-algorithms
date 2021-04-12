package com.anujaneja.algorithm.educative.binarySearch;

public class SearchInRotatedArray {

    public static int search(int[] nums, int target) {

        if(nums.length==0) {
            return -1;
        }

        if(nums.length==1) {
            if(nums[0]==target) {
                return 0;
            } else {
                return -1;
            }
        }
        return searchRec(nums,target, 0,nums.length-1);
    }

    public static int searchRec(int[] nums,int target,int start,int end) {
        if(start>end) {
            return -1;
        }


        int mid=(start+end)/2;


        //System.out.println("Going to find "+target+" start="+start+" end="+end+" nums[mid]="+nums[mid]);

        if(nums[mid]==target) {
            return mid;
        }

        //checking in the first half sorted...
        if(nums[start]<=nums[mid]) {
            if(target>=nums[start] && target<nums[mid]) {
                return searchRec(nums,target,start,mid-1);
            } else {
                return searchRec(nums,target,mid+1,end);
            }
        } else if(target>nums[mid] && target<=nums[end]) {
            //checking in second half if sorted...
            return searchRec(nums,target,mid+1,end);
        } else {
            return searchRec(nums,target,start,mid-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(SearchInRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchInRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
