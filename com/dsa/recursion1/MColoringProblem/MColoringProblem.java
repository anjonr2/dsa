package com.dsa.recursion1.MColoringProblem;

public class MColoringProblem {
    boolean isSafe(int node, int[][] adjacencyMatrix, int[] color, int currentColor) {
        for (int vertex = 0; vertex < adjacencyMatrix.length; vertex += 1) {
            if (adjacencyMatrix[node][vertex] == 1 && color[vertex] == currentColor) {
                return false;
            }
        }
        return true;
    }

    boolean graphColoringUtil(int node, int[][] adjacencyMatrix, int[] color, int m, int n) {
        if (node == n) {
            return true;
        }

        // Try every color for the current node
        for (int currentColor = 1; currentColor <= m; currentColor += 1) {
            if (isSafe(node, adjacencyMatrix, color, currentColor)) {
                color[node] = currentColor;
                if (graphColoringUtil(node + 1, adjacencyMatrix, color, m, n)) {
                    return true;
                }

                // Backtrack
                color[node] = 0;
            }
        }
        return false;
    }

    boolean graphColoring(int[][] edges, int m, int n) {
        int[] color = new int[m];
        int adjacencyMatrix[][] = new int[n][n];
        for (int[] edge : edges) {
            adjacencyMatrix[edge[0]][edge[1]] = 1;
            adjacencyMatrix[edge[1]][edge[0]] = 1;
        }
        return graphColoringUtil(0, adjacencyMatrix, color, m, n);
    }
}
