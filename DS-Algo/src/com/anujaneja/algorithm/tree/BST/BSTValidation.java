package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

/**
 * Medium - https://leetcode.com/problems/validate-binary-search-tree/
 */
public class BSTValidation {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    static  boolean isValidBST(TreeNode root,long min,long max) {
        if(root==null) {
            return  true;
        }


        if(root.val<=min || root.val>=max) {
            return false;
        }

        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }


    public static void main(String[] args) {
        //[8,3,10,1,6,null,null,null,null,2]
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(2);

        System.out.println("Is BST = "+isValidBST(root));

        //Boundary condition of int..
        root = new TreeNode(2147483647);

        System.out.println("Is BST = "+isValidBST(root));

        //Boundary condition of int negative..
        root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);

        System.out.println("Is BST = "+isValidBST(root));
    }
}
