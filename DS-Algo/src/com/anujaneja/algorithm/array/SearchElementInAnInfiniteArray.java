package com.anujaneja.algorithm.array;

/**
 * Created by anuj on 17/10/17.
 *
 * Ref: http://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 *
 * Find position of an element in a sorted array of infinite numbers

 Suppose you have a sorted array of infinite numbers, how would you search an element in the array?

 Source: Amazon Interview Experience.

 Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of array.
 If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key, first we find bounds and then apply binary search algorithm.

 Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
 ->if it is greater than high index element then copy high index in low index and double the high index.
 ->if it is smaller, then apply binary search on high and low indices found.

 */
public class SearchElementInAnInfiniteArray {

    public int searchElement(int arr[],int key,int low,int high) {

//        System.out.println("low= "+low+" high="+high);

        if(low>high) {
            return -1;
        }

        if(key>arr[high]) {
            return searchElement(arr,key,high+1,high*2);
        } else if(key<=arr[high] && key>=arr[low]) {
//            System.out.println("low="+low+" high="+high+" key="+key);

            int mid = (low+high)/2;


            if(arr[mid] == key){
                return mid;
            } else if(arr[mid]<key){
                return searchElement(arr,key,mid+1,high);
            } else if(arr[mid]>key) {
                return searchElement(arr,key,low,mid-1);
            }

        }

        return -1;
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

    public static void main(String[] s) {
        int arr[] = new int[1000];
        for(int i=0,k=0; k<1000;i++,i++,k++) {
            arr[k] = i;
        }

        printArrayElements(arr);

        int key = 100000;

        int position = new SearchElementInAnInfiniteArray().searchElement(arr,key,0,1);

        if(position!=-1) {
            System.out.println(key+" Position found: "+position);
        } else {
            System.out.println(key + " Not Found!!!");
        }


        if(position!=-1 && arr[position]==key ) {
            System.out.println("Test case passed");
        }  else if(position!=-1 && arr[position]!=key){
            System.out.println("Test case FAIL!!!");
        }


    }
}
