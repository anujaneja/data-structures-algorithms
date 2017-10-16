package com.anujaneja.algorithm;

/**
 * Created by anuj on 16/10/17.
 */
public class BinarySearchExtended {
    public int binarySearchExtended(int[] arr,int start,int end,int key) {

        int index=-1;
        int mid = (start+end)/2;

//        System.out.println("Going to find "+key+" start="+start+" end="+end+" arr[mid]="+arr[mid]);

        if(start>end) {
            return -1;
        }

        if(arr[mid]==key) {
            return mid;
        }

        /**
         * Check for sorted array in first half
         */

        if(arr[start]<=arr[mid]) {
            //Sorted
            //lies in first half otherwise search in second half
            if(key>=arr[start] && key<=arr[mid]) {
                return binarySearchExtended(arr,start,mid-1,key);
            } else {
                return binarySearchExtended(arr,mid+1,end ,key);
            }
            //lies in second half
        } else if(key>=arr[mid] && key<=arr[end]) {
            return binarySearchExtended(arr,mid+1,end,key);
            //search in unsorted first half
        } else {
            return binarySearchExtended(arr,start,mid-1,key);
        }


    }

    public static void main(String[] s){

//        int arr[] = new int[]{8,9,10,1,2,3,4,5,6,7};
        int arr[] = new int[]{4,5,6,7,8,9,10,1,2,3};
        //Search for existing ones.

        for(int key:arr) {
            int index =  new BinarySearchExtended().binarySearchExtended(arr,0,arr.length-1,key);

            if(index==-1) {
                System.out.println("Element "+key+" not found!!!");
            } else {
                System.out.println("Element "+key+" found at position: "+index);
            }

        }

        System.out.println("Negative test case:");

        System.out.println("22 is found at position "+new BinarySearchExtended().binarySearchExtended(arr,0,arr.length-1,22));
        System.out.println("-22 is found at position "+new BinarySearchExtended().binarySearchExtended(arr,0,arr.length-1,-22));

    }


}
