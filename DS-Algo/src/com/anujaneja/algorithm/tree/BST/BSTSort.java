package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTSort {

    public static void sortBST(int[] arr) {
        if(arr.length==1) {
            return;
        }

        TreeNode root = new TreeNode(arr[0]);
        int i=1;

        while (i<arr.length) {
            BSTInsertion.insert(root,arr[i]);
            i++;
        }

        BSTInOrderTraversal.inOrder(root);

    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 7, 2, 11};
        sortBST(arr);
    }
}
