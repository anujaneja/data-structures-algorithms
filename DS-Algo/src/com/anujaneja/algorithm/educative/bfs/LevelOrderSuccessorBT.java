package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Medium -  https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/
 */
public class LevelOrderSuccessorBT {

    public static TreeNode levelOrderSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean keyFound = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (keyFound) {
                    return node;
                }

                //Add left child...to queue
                if (node.val == key) {
                    keyFound = true;
                }

                if(node.left!=null) {
                    queue.offer(node.left);
                }


                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int key = 12;
        TreeNode result = LevelOrderSuccessorBT.levelOrderSuccessor(root, key);
        System.out.println("Level order successor of : " + key + " is: " + result.val);

        key = 1;
        result = LevelOrderSuccessorBT.levelOrderSuccessor(root, key);
        System.out.println("Level order successor of : " + key + " is: " + result.val);

        key = 20;
        result = LevelOrderSuccessorBT.levelOrderSuccessor(root, key);
        System.out.println("Level order successor of : " + key + " is: " + (result!=null?result.val:null));

        key = 5;
        result = LevelOrderSuccessorBT.levelOrderSuccessor(root, key);
        System.out.println("Level order successor of : " + key + " is: " + (result!=null?result.val:null));

        key = 10;
        result = LevelOrderSuccessorBT.levelOrderSuccessor(root, key);
        System.out.println("Level order successor of : " + key + " is: " + (result!=null?result.val:null));

    }
}
