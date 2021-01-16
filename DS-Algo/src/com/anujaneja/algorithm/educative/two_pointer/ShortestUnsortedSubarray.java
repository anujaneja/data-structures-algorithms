package com.anujaneja.algorithm.educative.two_pointer;

public class ShortestUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length==1) {
            return 0;
        }
        int i=0,j=nums.length-1;
        int min_subarr=Integer.MAX_VALUE;
        int max_subarr=Integer.MIN_VALUE;
        //find the first lesser element than the previous one...
        while(i<nums.length-1 && nums[i]<=nums[i+1]) {
            i++;
        }

        if(i==nums.length-1) {
            return 0; //Already sorted...
        }

        //find the first greater element than the previous one...
        while(j>0 && nums[j]>=nums[j-1]) {
            j--;
        }


        for(int k=i;k<=j;k++) {
            min_subarr=Math.min(min_subarr,nums[k]);
            max_subarr=Math.max(max_subarr,nums[k]);
        }

        System.out.println("i="+i+" j="+j);


        while(i>0) {
            if(min_subarr<nums[i-1]){
                i--;
            } else {
                break;
            }
        }


        while(j<nums.length-1) {
            if(max_subarr>nums[j+1]){
                j++;
            } else {
                break;
            }
        }




        System.out.println("i="+i+" j="+j);
        return i>j?0:j-i+1;
    }

    public static void main(String[] args) {
        // TODO: 14/01/21 add test cases...
    }
}
