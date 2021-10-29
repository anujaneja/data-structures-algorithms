package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Similiar to:
 * Medium - https://leetcode.com/problems/binary-tree-right-side-view/
 * Medium - https://www.geeksforgeeks.org/print-left-view-binary-tree/
 */
public class LeftViewBinaryTree {

    public static List<Integer> leftView(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            //queue size is levelSize...
            int levelSize = queue.size();
            //1. level wise dequeue
            //2. add its left and right childs...
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i<levelSize;i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if(node.left!=null) {
                    queue.add(node.left);
                }

                if(node.right!=null) {
                    queue.add(node.right);
                }
            }

            result.add(currentLevel.get(0));
        }

        return result;

    }


    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            List<Integer> levelElements = new ArrayList<>();

            for(int i=0;i<levelSize;i++) {
                TreeNode node = queue.poll();
                levelElements.add(node.val);

                //add its childs to queue...
                if(node.left!=null) {
                    queue.offer(node.left);
                }

                if(node.right!=null) {
                    queue.offer(node.right);
                }

            }

            result.add(levelElements.get(levelElements.size()-1));
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = LeftViewBinaryTree.leftView(root);
        System.out.println("Left view of binary tree: " + result);
    }
}
