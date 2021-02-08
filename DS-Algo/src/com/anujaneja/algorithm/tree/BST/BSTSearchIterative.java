package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

public class BSTSearchIterative {

    public static Integer searchBST(TreeNode root,int key) {
        if(root==null) {
            return null;
        }

        TreeNode curr = root;

        while(curr!=null) {
            if(curr.val==key) {
                return curr.val;
            } else if(key<curr.val) {
                curr=curr.left;
            } else {
                curr=curr.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        //Valid BST...
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        Integer key = 3;
        System.out.println("SearchBST : key= "+key+" found: "+(key.equals(searchBST(root,key))));

        key = 1;

        System.out.println("SearchBST : key= "+key+" found: "+(key.equals(searchBST(root,key))));

    }
}
