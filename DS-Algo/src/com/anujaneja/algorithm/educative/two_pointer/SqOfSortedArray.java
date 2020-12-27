package com.anujaneja.algorithm.educative.two_pointer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SqOfSortedArray {
    public static int[] sortedSquares(int[] nums) {

        if(nums.length==0) {
            return new int[]{};
        }
        int[] arr = new int[nums.length];
        int fisrt_pos_index = -1;
        int last_neg_index=-1;
        int i=0;

        while(i<nums.length) {
            if(nums[i]>=0) {
                fisrt_pos_index=i;
                //System.out.println("fisrt_pos_index="+fisrt_pos_index+" last_neg_index="+last_neg_index);
                break;
            } else {
                last_neg_index=i;
            }

            i++;
        }

        //System.out.println("fisrt_pos_index="+fisrt_pos_index+" last_neg_index="+last_neg_index);

        if(fisrt_pos_index<0 && last_neg_index>=0) {
            for(int k=0;k<nums.length;k++) {
                arr[k]=nums[last_neg_index]*nums[last_neg_index];
                last_neg_index--;
            }
        } else if(fisrt_pos_index>=0 && last_neg_index<0) {
            //all negative present... or all negative present...
            for(int k=0;k<nums.length;k++) {
                arr[k]=nums[fisrt_pos_index]*nums[fisrt_pos_index];
                fisrt_pos_index++;
            }
        } else {
            //mix present...
            int k=0;

            while(last_neg_index>=0 && fisrt_pos_index<nums.length) {
                if(nums[last_neg_index]*nums[last_neg_index] >=nums[fisrt_pos_index]*nums[fisrt_pos_index]){
                    arr[k++]=nums[fisrt_pos_index]*nums[fisrt_pos_index];
                    fisrt_pos_index++;
                } else if(nums[last_neg_index]*nums[last_neg_index] <nums[fisrt_pos_index]*nums[fisrt_pos_index]) {
                    arr[k++]=nums[last_neg_index]*nums[last_neg_index];
                    last_neg_index--;
                }
            }

            //System.out.println("fisrt_pos_index="+fisrt_pos_index+" last_neg_index="+last_neg_index);

            //remaining -ve ones...
            if(last_neg_index>=0) {

                while(last_neg_index>=0) {
                    arr[k++]=nums[last_neg_index]*nums[last_neg_index];
                    last_neg_index--;
                }
            } else if(fisrt_pos_index<nums.length){
                //remaining +ve ones...
                while(fisrt_pos_index<nums.length) {
                    arr[k++]=nums[fisrt_pos_index]*nums[fisrt_pos_index];
                    fisrt_pos_index++;
                }

            }

        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,1};
        System.out.println("output = "+ Arrays.toString(sortedSquares(nums)));

        nums = new int[] {-1};
        System.out.println("output = "+ Arrays.toString(sortedSquares(nums)));

        nums = new int[] {-4,-1,0,3,10};
        System.out.println("output = "+ Arrays.toString(sortedSquares(nums)));

        nums = new int[] {-7,-3,2,3,11};
        System.out.println("output = "+ Arrays.toString(sortedSquares(nums)));

        nums = new int[] {1,2,4,5,6,6,7,8,9};
        System.out.println("output = "+ Arrays.toString(sortedSquares(nums)));

    }
}
