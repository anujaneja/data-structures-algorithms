package com.anujaneja.algorithm.graph;

import java.util.LinkedList;

/**
 * Adjacency Matrix representation in Java
 * Adjacency Matrix Applications
 * Creating routing table in networks
 * Navigation tasks
 * DFS -> Depth First Search Traversal
 * The time complexity of the DFS algorithm is represented in the form of O(V + E),
 * where V is the number of nodes and E is the number of edges.
 * The space complexity of the algorithm is O(V).
 * Application of DFS Algorithm
 * For finding the path
 * To test if the graph is bipartite
 * For finding the strongly connected components of a graph
 * For detecting cycles in a graph
 * =======================================================
 * BFS Algorithm Complexity
 * The time complexity of the BFS algorithm is represented in the form of O(V + E),
 * where V is the number of nodes and E is the number of edges.
 * The space complexity of the algorithm is O(V).
 * ================================================================
 * * BFS Algorithm Applications **
 * To build index by search index
 * For GPS navigation
 * Path finding algorithms
 * In Ford-Fulkerson algorithm to find maximum flow in a network
 * Cycle detection in an undirected graph
 * In minimum spanning tree
 * ========================================================
 */
public class AdjacencyListGraph {
    private LinkedList<Integer> adjacencyList[];
    private int                 numVertices;
    private boolean             visited[];

    //Initialize the matrix...
    public AdjacencyListGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]) {
        AdjacencyListGraph g = new AdjacencyListGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());

        System.out.println("Printing DFS\n");
        g.DFS(0);

        System.out.println("\n\nPrinting BFS\n");
        g.BFS(0);
    }

    // DFS algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.println("Vertex: " + vertex);

        for (int av : adjacencyList[vertex]) {
            if (visited[av] == false) {
                DFS(av);
            }
        }
    }

    void BFS(int vertex) {
        boolean[] visited = new boolean[numVertices];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int s = queue.poll();
            System.out.println(" Vertex :" + s);
            LinkedList<Integer> adjVertexes = adjacencyList[s];

            for (int adjV : adjVertexes) {
                if (visited[adjV] == false) {
                    visited[adjV] = true;
                    queue.add(adjV);
                }
            }
        }
    }

    public void addEdge(int s, int d) {
        adjacencyList[s].add(d);
    }

    public void removeEdge(int s, int d) {
        adjacencyList[s].remove(d);
    }

    @Override public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            LinkedList<Integer> list = adjacencyList[i];

            for (int vertex : list) {
                s.append(vertex + ", ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
