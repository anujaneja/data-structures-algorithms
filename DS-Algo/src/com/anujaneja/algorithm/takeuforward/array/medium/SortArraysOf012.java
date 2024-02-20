package com.anujaneja.algorithm.takeuforward.array.medium;

import java.util.Arrays;

/*
Dutch national flag problem :

https://leetcode.com/problems/sort-colors/description/

 */
public class SortArraysOf012 {

    public static int[] sort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};

        Arrays.stream(sort(arr)).forEach(value -> System.out.print(value + ","));
    }
}
