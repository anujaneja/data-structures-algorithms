package com.anujaneja.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Highlight
 * At any point of time we are maintaining the first element as the minimum or maximum element of the Dqeue.
 *
 */
public class SlidingWindowAlgorithm {

    public static void printArrayElements(int arr[]){

        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1) {
                System.out.print(arr[i]+",");
            } else {
                System.out.println(arr[i]);
            }

        }
    }

    public static ArrayList<Integer> maxSlidingWindowUsingDqueue(int arr[],int windowSize) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        Deque<Integer> tempQueue = new LinkedList<Integer>();

        int i=0;

        for( i=0;i<windowSize;i++) {
//            System.out.println("tempQueue=="+tempQueue);
            while(!tempQueue.isEmpty() && (arr[tempQueue.peekLast()]<=arr[i])) {
                tempQueue.removeLast();
            }
            tempQueue.addLast(i);
        }

        for(;i<arr.length;i++) {
//            System.out.println("tempQueue=="+tempQueue);

//            System.out.println(tempQueue.peekFirst() + " ");
            result.add(arr[tempQueue.peekFirst()]);

            //remove the element from queue which are out of this window.

            while(!tempQueue.isEmpty() && tempQueue.peek()<=(i-windowSize)) {
                tempQueue.removeFirst();
            }


            while(!tempQueue.isEmpty() && arr[tempQueue.peekLast()]<=arr[i]) {
                tempQueue.removeLast();
            }
            tempQueue.addLast(i);
//            System.out.println(tempQueue+"====="+arr[i]);
        }

        //System.out.println(tempQueue.peekFirst() + " ");
        result.add(arr[tempQueue.peekFirst()]);

        return result;
    }


    public static ArrayList<Integer> minSlidingWindowUsingDqueue(int arr[],int windowSize) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        Deque<Integer> tempQueue = new LinkedList<Integer>();

        int i=0;

        for( i=0;i<windowSize;i++) {
//            System.out.println("tempQueue=="+tempQueue);
            while(!tempQueue.isEmpty() && (arr[tempQueue.peekLast()]>=arr[i])) {
                tempQueue.removeLast();
            }
            tempQueue.addLast(i);
        }

        for(;i<arr.length;i++) {
//            System.out.println("tempQueue=="+tempQueue);
//            System.out.println(tempQueue.peekFirst() + " ");

            result.add(arr[tempQueue.peekFirst()]);

            //remove the element from queue which are out of this window.
            while(!tempQueue.isEmpty() && tempQueue.peek()<=(i-windowSize)) {
                tempQueue.removeFirst();
            }


            while(!tempQueue.isEmpty() && arr[tempQueue.peekLast()]>=arr[i]) {
                tempQueue.removeLast();
            }
            tempQueue.addLast(i);
//            System.out.println(tempQueue+"====="+arr[i]);

        }
//        System.out.println(tempQueue.peekFirst() + " ");


        result.add(arr[tempQueue.peekFirst()]);


        return result;
    }

    public static void main(String[] s) {
        int[] arr = new int[] {1,44,3,5,5,-5,2,-1,7,4,5,14};
        int windowSize = 3;

        System.out.println("Max sliding window output=="+SlidingWindowAlgorithm.maxSlidingWindowUsingDqueue(arr,windowSize));
        System.out.println("Min sliding window output=="+SlidingWindowAlgorithm.minSlidingWindowUsingDqueue(arr,windowSize));
    }
}
