package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTSuccessor {

    public static void main(String[] args) {
        int arr[] = { 20, 22, 8, 4, 10, 12, 14 };

        TreeNode root = new TreeNode(arr);

        System.out.println(inOrderSuccessor(root, 14));
    }

    public static TreeNode minNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static int inOrderSuccessor(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }

        TreeNode curr = root;
        TreeNode succ = null;
        TreeNode target = null;

        while (curr.left != null || curr.right != null) {
            if (key < curr.val) {
                curr = curr.left;
            } else if (key > curr.val) {
                curr = curr.right;
            } else {
                //Equal found...
                if (curr.right != null) {
                    //find the min node of right subtree...
                    succ = minNode(curr.right);
                    return succ.val;
                }
            }

        }

        target = curr;
        curr = root;
        succ = null;

        while (curr != null) {
            if (curr.val > target.val) {
                succ = curr;
                curr = curr.left;
            } else if (curr.val < target.val) {
                curr = curr.right;
            } else {
                break;
            }
        }

        return succ != null ? succ.val : -1;
    }

}
