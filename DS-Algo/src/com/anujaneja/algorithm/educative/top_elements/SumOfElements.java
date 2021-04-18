package com.anujaneja.algorithm.educative.top_elements;

import java.util.PriorityQueue;

class SumOfElements {

  public static int findSumOfElements(int[] nums, int k1, int k2) {
    int sum = 0;

    if(nums.length<k1) {
      return 0;
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1.intValue()-o2.intValue());

    for(int i=0;i<nums.length;i++) {
      minHeap.add(nums[i]);
    }

//    System.out.println("minHeap="+minHeap);
    int i=1;

    while(!minHeap.isEmpty()) {
      int number = minHeap.poll();
//      System.out.println("number="+number);

      if(i>=k2) {
        break;
      } else if(i<=k1) {
        i++;
      } else if(i>k1 && i<k2){
        sum+=number;
        i++;
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 5);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
  }
}
