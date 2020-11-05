package com.anujaneja.algorithm.array;

import java.util.Arrays;

public class BinarySearchRecursive {

    public static int binarySearch(int[] arr,int element,int low, int high) {

        if(low>high) {
            return -1;
        }

        int mid = (low+high)/2;


        if(arr[mid]==element) {
            return mid;
        } else if(element<arr[mid]) {
            return binarySearch(arr,element,low,mid-1);
        } else {
            return binarySearch(arr,element,mid+1,high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,7,9,10,12,14,20,22,25};
        int element = 28;
        int index = binarySearch(arr,element,0,arr.length-1);

        if(index>=0) {
            System.out.println(element+" Found at index: "+index);
        } else {
            System.out.println(element+" Not Found");
        }
    }
}
