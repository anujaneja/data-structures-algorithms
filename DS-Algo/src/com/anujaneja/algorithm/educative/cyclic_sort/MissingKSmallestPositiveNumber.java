package com.anujaneja.algorithm.educative.cyclic_sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingKSmallestPositiveNumber {

    public static List<Integer> findNumbers(int[] nums,int k) {

        List<Integer> missingNumber =  new ArrayList<>();

        int i=0;

        while(i<nums.length) {
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]) {
                swap(nums,i, nums[i]-1);
            } else {
                i++;
            }
        }

        Set<Integer> extraNumbers = new HashSet<>();

        for(int j=0;j<nums.length;j++) {
            if(nums[j]!=j+1) {
                missingNumber.add(j+1);
                extraNumbers.add(nums[j]);
            }
        }

        for(i=nums.length+1;missingNumber.size()<k;i++) {
            if (!extraNumbers.contains(i)) {
                missingNumber.add(i);
            }
        }

        return missingNumber;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
