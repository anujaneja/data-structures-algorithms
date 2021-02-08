package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTSearchRecursive {

    public static Integer searchBST(TreeNode root,int key) {
        if(root==null) {
            return null;
        }

        if(root.val==key) {
            return root.val;
        }

        if(key<root.val) {
            return searchBST(root.left,key);
        } else {
            return searchBST(root.right,key);
        }
    }

    public static void main(String[] args) {
        //Valid BST...
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        Integer key = 3;
        System.out.println("SearchBST : key= "+key+" found: "+(key.equals(searchBST(root,key))));

        key = 11;

        System.out.println("SearchBST : key= "+key+" found: "+(key.equals(searchBST(root,key))));

    }
}

