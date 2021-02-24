package com.anujaneja.algorithm.educative.dfs;

import com.anujaneja.algorithm.educative.bfs.ConnectLevelOrderSiblings;
import com.anujaneja.algorithm.tree.TreeNode;

import java.util.Stack;

public class TreeSumPath {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<Integer> result = new Stack<>();
        boolean hasPathSum = hasPathSum(root, targetSum, result);
        System.out.println(result);

        return hasPathSum;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum, Stack<Integer> result) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(root.val);
            return true;
        }
        int updatedSum = targetSum - root.val;

        boolean leftHasPathSum = hasPathSum(root.left, updatedSum, result);

        if (leftHasPathSum) {
            result.add(root.val);
        }

        boolean rightHasPathSum = hasPathSum(root.right, updatedSum, result);

        if (rightHasPathSum) {
            result.add(root.val);
        }

        return leftHasPathSum || rightHasPathSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        int targetSum = 24;
        boolean hasPathSum = TreeSumPath.hasPathSum(root, targetSum);

        System.out.println("targetSum= " + hasPathSum);
    }
}
