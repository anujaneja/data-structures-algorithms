package com.anujaneja.algorithm.interview;

import com.anujaneja.algorithm.array.BinarySearchRecursive;

public class BiotonicArray {

    public static int findBiotonicPoint(int[] arr,int start,int end) {


        int mid = (start+end)/2;

//        if((mid+1)>end || (mid-1)<start) {
//            return -1;
//        }
//
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
            return mid;
        } else if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]) {
            return findBiotonicPoint(arr,start,mid-1);
        } else if(arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1]) {
            return findBiotonicPoint(arr,mid+1,end);
        }

        return -1;
    }

    public static int biotonicSearch(int[] arr,int key) {
        int index = -1;
        int biotonicPoint = findBiotonicPoint(arr,0,arr.length-1);

        if(biotonicPoint>0) {
            if(key == arr[biotonicPoint]) {
                index=biotonicPoint;
            }else if(key>arr[biotonicPoint]){
                //Greater then biotonic point not possible
                return -1;
            } else if(key<arr[biotonicPoint]) {
                //find left of biotonic index.....
                System.out.println("Searching in left side");
                index = BinarySearchRecursive.binarySearch(arr,key,0,biotonicPoint-1);

                if(index<0) {
                    //find in right of biotonic index...
                    System.out.println("Searching in right side");
                    index = BinarySearchRecursive.binarySearchDesc(arr,biotonicPoint+1,arr.length-1,key);
                }
            }
        } else {
            index=-1;
        }

        return  index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9, 10, 12, 11, 4,3,2,1};
        int key = 0;
        int biotonicPoint = findBiotonicPoint(arr,0,arr.length-1);

        System.out.println("biotonicPoint: "+biotonicPoint);

        int index  = biotonicSearch(arr,key);

        System.out.println("index = "+index);

    }
}
