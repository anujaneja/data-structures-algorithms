package com.anujaneja.algorithm.educative.k_way_merge;

import java.util.PriorityQueue;

class KthSmallestInSortedMatrix {

  public static int findKthSmallest(int[][] matrix, int k) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> matrix[o1.arrayIndex][o1.elementIndex] - matrix[o2.arrayIndex][o2.elementIndex]);

    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[i] != null) {
        minHeap.offer(new Node(0, i));
      }
    }

    int numberCount = 0;
    int result = 0;

    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();

      result = matrix[node.arrayIndex][node.elementIndex];
      numberCount++;
      node.elementIndex++;

      if(numberCount==k) {
        break;
      }

      //Just incremented element index... arrayIndex remains...
      if(node.elementIndex<matrix[node.arrayIndex].length) {
        minHeap.offer(node);
      }
    }

    return result;

  }

  public static void main(String[] args) {
    int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
    int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}