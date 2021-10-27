package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTKthSmallest {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        TreeNode node = kthSmallestNode(root, k);
        return node.val;
    }

    public TreeNode kthSmallestNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallestNode(root.left, k);

        if (left != null) {
            return left;
        }

        count++;

        if (count == k) {
            return root;
        }

        return kthSmallestNode(root.right, k);
    }

    public static void main(String[] args) {

    }
}
