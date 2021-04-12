package com.anujaneja.algorithm.educative.binarySearch;

public class FindNoOfRotation {

    public static int countRotations(int[] arr) {
        if(arr.length<=1) {
            return 0;
        }


        return countRotationsRec(arr,0,arr.length-1);
    }

    public static int countRotationsRec(int[] arr,int start,int end) {
        if(start>end) {
            return 0;
        }

        if (arr[start] <= arr[end]) {
            return start;
        }

        int mid= start+(end-start)/2;

        int nextIndex = (mid+1)%arr.length;
        int preIndex = (mid-1+arr.length)%arr.length;

        if(arr[mid]<=arr[preIndex] && arr[mid]<=arr[nextIndex]) {
            return mid;
        } else if(arr[start]<arr[mid]) {
            //found in asc sorted order...
            return countRotationsRec(arr,mid+1,end);
        } else {
            return countRotationsRec(arr,start,mid-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(FindNoOfRotation.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(FindNoOfRotation.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(FindNoOfRotation.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}
