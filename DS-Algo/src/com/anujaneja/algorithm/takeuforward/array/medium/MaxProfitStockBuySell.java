package com.anujaneja.algorithm.takeuforward.array.medium;

public class MaxProfitStockBuySell {

    public static int maxProfitStockBuySell(int[] nums) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            minPrice = Math.min(minPrice, nums[i]);
            maxProfit = Math.max(maxProfit, nums[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};

        int maxProfit = maxProfitStockBuySell(nums);

        System.out.println(maxProfit);
    }
}
