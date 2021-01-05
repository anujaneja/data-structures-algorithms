package com.anujaneja.algorithm.educative.two_pointer;

import java.util.Arrays;

/**
 * Medium - https://leetcode.com/problems/3sum-closest/submissions/
 *
 */
public class TripletSumClosestToTarget {

    /**
     * Does not handle overflows...or would not
     * work in case of large number..
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<2) {
            throw new IllegalArgumentException();
        }
        int smallestSum =  100000; // If use INTEGER.MAX_VALUE/MIN_VALUE could cause overflow/underflow
        int largestSum =  -100000;
        int output= 0;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++) {
            int j=i+1;
            int k=nums.length-1;
            int revised_target= target-nums[i];


            while(j<k) {
                if(nums[j]+nums[k]==revised_target) {
                    return target;
                } else if(nums[j]+nums[k]>revised_target){
                    smallestSum = Math.min(smallestSum,nums[i]+nums[j]+nums[k]);
                    //largestSum = Math.max(largestSum,nums[i]+nums[j]+nums[k]);
                    k--;
                } else if(nums[j]+nums[k]<revised_target) {
                    //smallestSum = Math.min(smallestSum,nums[i]+nums[j]+nums[k]);
                    largestSum = Math.max(largestSum,nums[i]+nums[j]+nums[k]);
                    j++;
                }

                //System.out.println("smallestSum="+smallestSum+" largestSum="+largestSum);
            }


        }

        //System.out.println("FINAL: smallestSum="+smallestSum+" largestSum="+largestSum);

        if(Math.abs(smallestSum-target)>Math.abs(largestSum-target)) {
            //System.out.println("Math.abs(smallestSum-target)="+Math.abs(target-smallestSum)+"  Math.abs(largestSum-target)="+Math.abs(largestSum)*-1);
            output= largestSum;
        } else {
            output= smallestSum;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        System.out.println("output= "+threeSumClosest(nums,1));
    }
}
