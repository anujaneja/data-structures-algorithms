package com.anujaneja.algorithm.educative.dfs;

import com.anujaneja.algorithm.tree.TreeNode;

/**
 * Medium - https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumOfPathNums {

    public static int findSumOfPaths(TreeNode root) {
        return findSumOfPathsRec(root, 0);
    }

    public static int findSumOfPathsRec(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum*10+root.val;

        //leaf node...
        if (root.left == null && root.right == null) {
            return sum;
        }

        return findSumOfPathsRec(root.left,sum)+findSumOfPathsRec(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        int result = SumOfPathNums.findSumOfPaths(root);
        System.out.println("Tree paths with sum is: " + result);
    }
}
