package com.anujaneja.algorithm.array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by anuj on 15/10/17.
 */
public class QuickSortAlgorithm {

    public static int partition(int[] arr,int start,int end) {

//        System.out.println("start= "+start);
//        System.out.println("end= "+end);
        int pivot = end;
        int pivotPosition = pivot;
        int left = start;
        int right = end-1;

        while(left<=right) {

//            System.out.println("arr[left]= "+arr[left]+ " arr[right]=="+arr[right]+" arr[pivot]=="+arr[pivot]);

            if(arr[left]>arr[pivot] && arr[right]<arr[pivot] )  {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            if(arr[left]<=arr[pivot]) {
                left++;
            }

            if(arr[right]>=arr[pivot]) {
                right--;
            }
        }

        int temp = arr[left];
        arr[left] = arr[pivot];
        arr[pivot] = temp;

//        printArrayElements(arr);

//        System.out.println(arr[left]);

        return left;
    }

    public static void printArrayElements(int arr[]){

        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1) {
                System.out.print(arr[i]+",");
            } else {
                System.out.println(arr[i]);
            }

        }
    }

    public static int[] quickSort(int arr[],int start,int end) {

        if(start<end) {
            int partition = partition(arr,start,end);

            quickSort(arr,start,partition-1);
            quickSort(arr,partition+1,end);
        }

        return arr;

    }

    public static void main(String[] s) {
        int arr[] = new int[] {1,44,3,5,5,-5,2,-1,7,4,5,14};
        arr= quickSort(arr,0,arr.length-1);
        printArrayElements(arr);
    }
}
