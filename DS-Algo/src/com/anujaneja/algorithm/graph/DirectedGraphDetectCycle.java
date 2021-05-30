package com.anujaneja.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=uzVUw90ZFIg
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
 */
class DirectedGraphDetectCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new DirectedGraphDetectCycle().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] dfsVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (checkCycle(i, adj, vis, dfsVis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkCycle(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfsVis) {
        vis[i] = 1;
        dfsVis[i] = 1;

        for (Integer av : adj.get(i)) {
            if (vis[av] == 0) {
                if (checkCycle(av, adj, vis, dfsVis)) {
                    return true;
                }
            } else if (dfsVis[av] == 1) {
                return true;
            }
        }

        dfsVis[i] = 0;
        return false;
    }
}



