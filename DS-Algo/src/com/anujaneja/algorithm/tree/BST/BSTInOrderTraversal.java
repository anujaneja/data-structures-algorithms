package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTInOrderTraversal {

    public static void inOrder(TreeNode root) {
        if(root==null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val+"->");
        inOrder(root.right);
    }
}
