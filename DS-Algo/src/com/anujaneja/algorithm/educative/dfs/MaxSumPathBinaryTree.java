package com.anujaneja.algorithm.educative.dfs;

import com.anujaneja.algorithm.tree.TreeNode;

/**
 * Hard - https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxSumPathBinaryTree {

    private static int result = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return result;
    }

    public static int maxPathSumUtil(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);

        int max_value = Math.max((Math.max(left,right)+root.val),root.val);
        int max_total = Math.max(max_value,left+right+root.val);
        result = Math.max(result,max_total);
        return max_value;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaxSumPathBinaryTree.maxPathSum(root));

        //re-set
        result = Integer.MIN_VALUE;

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaxSumPathBinaryTree.maxPathSum(root));

        //re-set
        result = Integer.MIN_VALUE;

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaxSumPathBinaryTree.maxPathSum(root));
    }
}
