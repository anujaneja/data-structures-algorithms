package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTMin {

    public static int min(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int min = root.val;

        while(root.left!=null) {
            min = root.left.val;
            root = root.left;
        }

        return min;
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 7, 2, 11,55,22,59,10,-1};
        TreeNode root = new TreeNode(arr);

        int min = min(root);
        System.out.println("min="+min);
    }
}
