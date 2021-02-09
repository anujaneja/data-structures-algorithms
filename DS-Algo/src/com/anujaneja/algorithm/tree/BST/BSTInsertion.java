package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTInsertion {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        //        root.left = new TreeNode(3);
        //        root.right = new TreeNode(10);
        //        root.left.left = new TreeNode(1);

        insert(root, 3);
        insert(root, 10);
        insert(root, 1);

        System.out.println("Insersion done...");
        System.out.println("In Order Traversal...");
        BSTInOrderTraversal.inOrder(root);
        System.out.println("\nValidate BST: " + BSTValidation.isValidBST(root));

    }

    public static void insert(TreeNode root, int key) {
        insertKey(root, key);
    }

    public static TreeNode insertKey(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.val) {
            root.left =  insertKey(root.left, key);
        } else if (key > root.val) {
            root.right  =  insertKey(root.right, key);
        }

        return root;
    }
}
