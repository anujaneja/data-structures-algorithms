package com.anujaneja.algorithm.educative.dfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Medium -  https://www.geeksforgeeks.org/count-all-k-sum-paths-in-a-binary-tree/
 * Medium - https://leetcode.com/problems/path-sum-iii/
 * Solution- https://github.com/ojasmaru/LetsAlgoTogether/blob/master/Path%20Sum%20III/Java/QuickStart.java
 * VIDEO EXPLANATION -  https://www.youtube.com/watch?v=uZzvivFkgtM&feature=youtu.be
 * It has two approach one is Brute force: O(n^2) other is O(n) with space complexity: O(n)
 */
public class CountPathForSumBinaryTree {

    public static int pathSum(TreeNode root, int S) {
        if(root==null) {
            return 0;
        }

        Map<Integer, Integer> sumFreq = new HashMap<>();
        //Base case in case match found from root->left/right example 12->7 and target is 19
        sumFreq.put(0, 1);
        return pathSum_2(root, 0, S, sumFreq);
    }

    public static int pathSum_2(TreeNode root, int runningSum, int S, Map<Integer, Integer> sumFreq) {
        if (root == null) {
            return 0;
        }

        runningSum += root.val;
        int prefixSum = runningSum - S;
        int count = sumFreq.getOrDefault(prefixSum, 0);
        sumFreq.put(runningSum, sumFreq.getOrDefault(runningSum, 0) + 1);

        count+= pathSum_2(root.left,runningSum,S,sumFreq)+pathSum_2(root.right,runningSum,S,sumFreq);

        //Decrement it from sumFreq
        sumFreq.put(runningSum,sumFreq.get(runningSum)-1);

        return count;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 11;
        int result = CountPathForSumBinaryTree.pathSum(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

    /**
     * This is Brute-force - O(n^2) Time complexity
     * Image a Tree with only left childs... and count no of comparision
     * n(n+1)/2 -> O(n2)
     *
     * @param root
     * @param sum
     * @return
     */

    /*public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root.left, sum) +
                pathSum(root.right, sum) + pathSum_2(root, sum);
    }

    public int pathSum_2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val == sum) {
            count = 1;
        }
        int updatedSum = sum - root.val;
        count += pathSum_2(root.left, updatedSum);
        count += pathSum_2(root.right, updatedSum);
        return count;
    }

    */
}
