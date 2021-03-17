package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Medium -  https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Queue<List<Integer>> currPermutations = new LinkedList();
        currPermutations.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int n = currPermutations.size();

            for (int j = 0; j < n; j++) {
                List<Integer> oldPermutation = currPermutations.poll();

                for (int k = 0; k < oldPermutation.size() + 1; k++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(k, currNum);

                    if (newPermutation.size() == nums.length) {
                        permutations.add(newPermutation);
                    } else {
                        currPermutations.add(newPermutation);
                    }

                }
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.permute(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
