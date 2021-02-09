package com.anujaneja.algorithm.tree.BST;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;

public class BSTAncestor {
    public static void main(String[] args) {
        int arr[] = { 20, 22, 8, 4, 10, 12, 14 };

        TreeNode root = new TreeNode(arr);

        System.out.println("ancestors==="+ancestors(root,20));
    }

    public static ArrayList<Integer> ancestors(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;
        ArrayList<Integer> arrayList =  new ArrayList<>();


        while (curr != null) {
            if (key > curr.val) {
                arrayList.add(curr.val);
                curr = curr.right;
            } else if(key < curr.val){
                arrayList.add(curr.val);
                curr = curr.left;
            } else {
                break;
            }
        }

        return arrayList;
    }


}
