package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTDeletion {

    public static TreeNode deleteKey(TreeNode root, int key) {
        //if root is empty then just return...
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteKey(root.left, key);
        } else if (key > root.val) {
            root.right = deleteKey(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            //find the minimum i.e. in order successor of this node...
            root.val = findMinimum(root.right);

            System.out.println("---in order successor--->>"+root.val);
            root.right = deleteKey(root.right, root.val);
        }

        return root;
    }

    public static int findMinimum(TreeNode head) {
        int minV = head.val;

        while (head.left != null) {
            minV = head.left.val;
            head = head.left;
        }

        return minV;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        //        root.left = new TreeNode(3);
        //        root.right = new TreeNode(10);
        //        root.left.left = new TreeNode(1);

        BSTInsertion.insert(root, 3);
        BSTInsertion.insert(root, 10);
        BSTInsertion.insert(root, 1);
        BSTInsertion.insert(root, 2);
        BSTInsertion.insert(root, 4);
        BSTInsertion.insert(root, 6);

        System.out.println("Before Deletion done...");
        System.out.println("In Order Traversal...");
        BSTInOrderTraversal.inOrder(root);
        System.out.println("\nValidate BST: " + BSTValidation.isValidBST(root));

        //TEST CASE 1: Deleting a node with two children....
        root = deleteKey(root, 3);
        System.out.println("Deletion done...");
        System.out.println("In Order Traversal...");
        BSTInOrderTraversal.inOrder(root);
        System.out.println("\nValidate BST: " + BSTValidation.isValidBST(root));


        //TEST CASE 2: Deleting a node with 1 children...
        root = deleteKey(root, 1);
        System.out.println("Deletion done...");
        System.out.println("In Order Traversal...");
        BSTInOrderTraversal.inOrder(root);
        System.out.println("\nValidate BST: " + BSTValidation.isValidBST(root));
    }
}
