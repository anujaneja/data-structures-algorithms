package com.anujaneja.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by anuj on 26/10/17.
 */

class Pair {
    int key;
    int value;

    public Pair(int key,int value) {
        this.key = key;
        this.value= value;
    }

    public String toString() {
        return "( "+key+" , "+value+" )";
    }
}

public class SumOfTwoInArrays {

    ArrayList<Pair> pairs = new ArrayList<>();

    public void findSumPairOfValuesSol1(int[] arr,int key) {

        arr = QuickSortAlgorithm.quickSort(arr,0,arr.length-1);

        int left = 0;
        int right = arr.length-1;

        while(left<right) {
            int sum = arr[left]+arr[right];

            if(key==sum) {
                pairs.add(new Pair(arr[left],arr[right]));
                left++;
                right++;
            } else if(sum>key) {
                right--;
            } else if(sum<key) {
                left++;
            }
        }
    }

    public void findSumPairOfValuesSol2(int[] arr,int key) {


        int left = 0;
        int right = arr.length-1;

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i=0;i<arr.length;i++) {
            int diff = key - arr[i];

            if(hashSet.contains(diff)) {
                pairs.add(new Pair(arr[i],diff));
            }

            hashSet.add(arr[i]);

        }
    }

    public static void main(String[] s) {

        int[] arr = new int[]{1,3,5,2,4,7,11,8,6,9,10,22,12};
        int key = 10;

        SumOfTwoInArrays sumOfTwoInArrays = new SumOfTwoInArrays();
        sumOfTwoInArrays.findSumPairOfValuesSol1(arr,key);

        System.out.println("Solution1 output: "+sumOfTwoInArrays.pairs);


        SumOfTwoInArrays sumOfTwoInArrays1 = new SumOfTwoInArrays();
        sumOfTwoInArrays1.findSumPairOfValuesSol2(arr,key);

        System.out.println("Solution2 output: "+sumOfTwoInArrays1.pairs);
    }
}
