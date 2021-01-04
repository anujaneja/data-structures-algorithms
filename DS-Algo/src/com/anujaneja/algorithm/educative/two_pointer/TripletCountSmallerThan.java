package com.anujaneja.algorithm.educative.two_pointer;

import java.util.Arrays;

public class TripletCountSmallerThan {

    public static int threeCountSmaller(int[] nums, int target) throws IllegalArgumentException {
        if(nums ==null || nums.length<3 ) {
            throw new IllegalArgumentException("Insufficient numbers in array");
        }

        int count = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++) {
            int j=i+1;
            int k=nums.length-1;
            int revised_target = target-nums[i];

            while(j<k){
                if(revised_target>nums[j]+nums[k]) {
//                    System.out.println(nums[i]+","+nums[j]+","+nums[k]);
                    count+=(k-j);
                    j++;
                } else {
                    //System.out.println(nums[i]+","+nums[j]+","+nums[k]);
                    k--;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        //Test Case: 1 +ve
        int[] nums = new int[]{-1,0,2,3};
        int target=3;
        int testCaseNo=0;

        System.out.println("Test Case #: "+(testCaseNo++)+" - Count= "+threeCountSmaller(nums,target));

        //Test Case: 2 +ve
        nums = new int[]{-1,4,2,1,3};
        target=5;

        System.out.println("Test Case #: "+(testCaseNo++)+" - Count= "+threeCountSmaller(nums,target));

        //Test Case: 3 -ve
        nums = new int[]{-1};
        target=5;

        try{
            System.out.println("Test Case #: "+(testCaseNo++)+" - Count= "+threeCountSmaller(nums,target));
        } catch (IllegalArgumentException ex) {
            System.out.println("Test case #: "+(testCaseNo++)+" - Exception: "+ex.getMessage()+" for "+Arrays.toString(nums));
        }


        //Test Case: 4 -ve
        nums = new int[]{-5,5};
        target=5;

        try{
            System.out.println("Test Case #: "+(testCaseNo++)+" - Count= "+threeCountSmaller(nums,target));
        } catch (IllegalArgumentException ex) {
            System.out.println("Test case #: "+(testCaseNo++)+" - Exception: "+ex.getMessage()+" for "+Arrays.toString(nums));
        }


        //Test Case: 5 -ve
        nums = new int[]{-5,5,7};
        target=5;

        System.out.println("Test Case #: "+(testCaseNo++)+" - Count= "+threeCountSmaller(nums,target));
    }
}
