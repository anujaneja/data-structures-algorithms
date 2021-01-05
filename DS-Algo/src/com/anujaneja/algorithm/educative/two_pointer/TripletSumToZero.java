package com.anujaneja.algorithm.educative.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium - https://leetcode.com/problems/3sum/
 * Time Complexity: O(n2)
 */
public class TripletSumToZero {

    public static List<List<Integer>> threeSum(int[] nums,int target) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            int revised_target = target-nums[i];

            while(j<k) {

                //checking if current element from
                //is same as previous element...
                if(j>i+1 && nums[j]==nums[j-1]) {
                    j++;
                    continue;
                }

                //checking if current element from
                //is same as previous element...
                if(k<nums.length-1 && nums[k]==nums[k+1]) {
                    k--;
                    continue;
                }

                if(nums[j]+nums[k]==revised_target) {
                    //System.out.println("i="+i+" j="+j+" k="+k);
                    ArrayList<Integer> arr =  new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    output.add(arr);
                    j++;
                    k--;
                } else if(nums[j]+nums[k]>revised_target) {
                    k--;
                } else if(nums[j]+nums[k]<revised_target) {
                    j++;
                }
            }
        }

        return output;
    }

    public static List<List<Integer>> threeSumToZero(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;

            while(j<k) {

                //checking if current element from
                //is same as previous element...
                if(j>i+1 && nums[j]==nums[j-1]) {
                    j++;
                    continue;
                }

                //checking if current element from
                //is same as previous element...
                if(k<nums.length-1 && nums[k]==nums[k+1]) {
                    k--;
                    continue;
                }

                if(nums[i]+nums[j]+nums[k]==0) {
                    //System.out.println("i="+i+" j="+j+" k="+k);
                    ArrayList<Integer> arr =  new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    output.add(arr);
                    j++;
                    k--;
                } else if(nums[j]+nums[k]>-nums[i]) {
                    k--;
                } else if(nums[j]+nums[k]<-nums[i]) {
                    j++;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        System.out.println("output= "+threeSumToZero(nums));

        nums = new int[]{-2,0,1,1,2};

        System.out.println("output= "+threeSumToZero(nums));

        nums = new int[]{};

        System.out.println("output= "+threeSumToZero(nums));


        nums = new int[]{0};

        System.out.println("output= "+threeSumToZero(nums));


        nums = new int[]{-1,0,1,2,-1,-4};

        System.out.println("output= "+threeSum(nums,0));

        nums = new int[]{-2,0,1,1,2};

        System.out.println("output= "+threeSum(nums,0));

        nums = new int[]{};

        System.out.println("output= "+threeSum(nums,0));


        nums = new int[]{0};

        System.out.println("output= "+threeSum(nums,0));

    }
}
