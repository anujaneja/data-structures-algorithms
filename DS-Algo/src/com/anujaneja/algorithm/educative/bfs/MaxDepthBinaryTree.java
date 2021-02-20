package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Easy - https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthBinaryTree {

    public static int findDepthMin(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            maxDepth++;

            for (int i=0;i<levelSize;i++) {
                TreeNode node = queue.poll();

                //add left child...
                if(node.left!=null) {
                    queue.offer(node.left);
                }

                //add right child...
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }

        }

        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(5);
        int result = MaxDepthBinaryTree.findDepthMin(root);
        System.out.println("Min Depth is: " + result);

    }
}
