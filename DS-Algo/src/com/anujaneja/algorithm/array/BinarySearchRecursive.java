package com.anujaneja.algorithm.array;

public class BinarySearchRecursive {

    public static int binarySearchDesc(int[] arr,int low,int high,int element) {

        if(low>high) {
            return -1;
        }

        int mid = (low+high)/2;

        if(arr[mid]==element) {
            return mid;
        } else if(arr[mid]>element) {
            return binarySearchDesc(arr,mid+1,high,element);
        } else {
            return binarySearchDesc(arr,low,mid-1,element);
        }
    }

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

        arr = new int[] {25,22,20,14,12,10,9,8,7,6,5,4,3,2,1,-1};

        element = -1;

        index = binarySearchDesc(arr,0,arr.length-1,element);

        if(index>=0) {
            System.out.println(element+" Found at index: "+index);
        } else {
            System.out.println(element+" Not Found");
        }

    }
}
