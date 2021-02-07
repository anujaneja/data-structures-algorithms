package com.anujaneja.algorithm.tree;

/**
 * Height balanced binary tree...
 * https://www.programiz.com/dsa/balanced-binary-tree
 * EASY - https://leetcode.com/problems/balanced-binary-tree/
 */

class Height {
    int height = 0;
}

public class BalancedBinaryTree {

    public static boolean checkHeightBalance(TreeNode root, Height height) {
        if(root==null) {
            height.height=0;
            return true;
        }

        Height leftHeightObj = new Height();
        Height rightHeightObj = new Height();

        boolean isLeftSubTreeHeightBalanced = checkHeightBalance(root.left,leftHeightObj);
        boolean isRightSubTreeHeightBalanced = checkHeightBalance(root.right,rightHeightObj);
        int leftSubTreeHeight = leftHeightObj.height;
        int rightSubTreeHeight = rightHeightObj.height;
        height.height = Math.max(leftSubTreeHeight,rightSubTreeHeight)+1;
        System.out.println("DF="+Math.abs(leftSubTreeHeight-rightSubTreeHeight)+" val="+root.val);

        if(Math.abs(leftSubTreeHeight-rightSubTreeHeight)>=2) {
            return false;
        } else {
            return isLeftSubTreeHeightBalanced && isRightSubTreeHeightBalanced;
        }

    }

    public static void main(String args[]) {
        Height height = new Height();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        if (checkHeightBalance(root, height)) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }
    }
}
