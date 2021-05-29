package com.anujaneja.algorithm.graph;

/**
 * Adjacency Matrix representation in Java
 * Adjacency Matrix Applications
 * Creating routing table in networks
 * Navigation tasks
 */
public class Graph {
    private boolean adjacencyMatrix[][];
    private int     numVertices;

    //Initialize the matrix...
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());
    }

    public void addEdge(int s, int d) {
        adjacencyMatrix[s][d] = true;
        adjacencyMatrix[d][s] = true;
    }

    public void removeEdge(int s, int d) {
        adjacencyMatrix[s][d] = false;
        adjacencyMatrix[d][s] = false;
    }

    @Override public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjacencyMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
