package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Easy - https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class LevelWiseAvgBinaryTree {

    public static List<Double> averageOfLevels(TreeNode root) {
        if(root==null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int levelSize=queue.size();
            double levelAvg = 0.0d;
            double levelSum = 0;

            for(int i=0;i<levelSize;i++) {
                TreeNode node = queue.poll();
                levelSum +=node.val;
                //Add left child...to queue
                if(node.left!=null) {
                    queue.offer(node.left);
                }

                //Add right child...to queue
                if(node.right!=null) {
                    queue.offer(node.right);
                }

            }

            levelAvg = levelSum/levelSize;
            result.add(levelAvg);

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
        List<Double> result = LevelWiseAvgBinaryTree.averageOfLevels(root);

        System.out.println("Level order avg output: " + result);
    }
}
