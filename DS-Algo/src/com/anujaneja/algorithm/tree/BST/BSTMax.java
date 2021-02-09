package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTMax {
    public static int max(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int max = root.val;

        while(root.right!=null) {
            max = root.right.val;
            root = root.right;
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 7, 2, 11,55,22,59,10};
        TreeNode root = new TreeNode(arr);

        int max = max(root);
        System.out.println("max="+max);
    }
}
