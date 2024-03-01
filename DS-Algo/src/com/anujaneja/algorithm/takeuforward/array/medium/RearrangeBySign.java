package com.anujaneja.algorithm.takeuforward.array.medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeBySign {

    public static int[] rearrange(int[] nums) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positives.add(nums[i]);
            } else {
                negatives.add(nums[i]);
            }
        }

        int[] output = new int[nums.length];

        for (int i = 0; i < Math.min(positives.size(), negatives.size()); i++) {
            output[2 * i] = positives.get(i);
            output[2 * i + 1] = negatives.get(i);
        }

        if (negatives.size() > positives.size()) {
            int index = positives.size() * 2;
            for (int j = positives.size(); j < negatives.size(); j++) {
                output[index++] = negatives.get(j);

            }
        } else {
            int index = negatives.size() * 2;
            for (int j = negatives.size(); j < positives.size(); j++) {
                output[index++] = positives.get(j);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, -5, -3, 6, -4};
        nums = rearrange(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }

        System.out.println("\n-----------------");

        nums = new int[]{7, 1, -5, -3, 6, -4, -11, 3, 2, 4, 8};
        nums = rearrange(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
