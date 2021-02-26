package com.anujaneja.algorithm.educative.dfs;

import com.anujaneja.algorithm.tree.TreeNode;

/**
 * Easy - https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class TreeDiameter {

    private static int max_diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }

        calculateHeight(root);
        return max_diameter;
    }

    public static int calculateHeight(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int leftSubTreeHeight = calculateHeight(root.left);
        int rightSubTreeHeight = calculateHeight(root.right);

        int diameter = (leftSubTreeHeight+rightSubTreeHeight);

        max_diameter = Math.max(diameter,max_diameter);

        return 1+Math.max(leftSubTreeHeight,rightSubTreeHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.diameterOfBinaryTree(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.diameterOfBinaryTree(root));
    }
}
