package com.anujaneja.algorithm.tree;

import com.anujaneja.algorithm.tree.BST.BSTInOrderTraversal;
import com.anujaneja.algorithm.tree.BST.BSTInsertion;

public class TreeNode {
    public int      val;
    public TreeNode left, right;

    public TreeNode() {
        this.val = 0;
        left = right = null;
    }

    public TreeNode(int data) {
        this.val = data;
        left = right = null;
    }

    public TreeNode(int[] arr) {
        if(arr.length==0) {
            return;
        }
        val = arr[0];
        int i=1;

        while (i<arr.length) {
            BSTInsertion.insert(this,arr[i]);
            i++;
        }
    }
}


