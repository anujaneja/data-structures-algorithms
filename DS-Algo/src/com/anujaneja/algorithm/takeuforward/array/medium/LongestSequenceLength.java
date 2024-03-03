package com.anujaneja.algorithm.takeuforward.array.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSequenceLength {
    public static int longestSuccessiveElements(int[] a) {
        int current_count = 0;
        int longest_count = 1;
        int last_element = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int i : a) {
            set.add(i);
        }

        for (int num : set) {
            current_count = 1;
            if (!set.contains(num - 1)) {
                int current_num = num;
                while (set.contains(current_num + 1)) {
                    current_count++;
                    current_num++;
                }
                longest_count = Math.max(longest_count, current_count);
            }

        }

        return longest_count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 22, 12, 3, 6, 2, 1, 1, 1, 1};
        int l = longestSuccessiveElements(arr);
        System.out.println(l);
    }
}
