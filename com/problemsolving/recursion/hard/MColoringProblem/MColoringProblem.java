import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {
    private boolean isSafe(int col, int node, int[] colors, List<List<Integer>> adj) {
        for (int neighbor : adj.get(node)) {
            /* if an adjacent node has the color return false */
            if (colors[neighbor] == col)
                return false;
        }
        /* return true if none of the adjacent node has given color */
        return true;
    }

    private boolean checkIfCanBeColored(int node, int m, int n, int[] colors, List<List<Integer>> adj) {
        /* base condition if all the nodes are colored */
        if (node == n)
            return true;

        /* try all colors from 1 to m */
        for (int i = 1; i <= m; i += 1) {
            isSafe(i, node, colors, adj){
                colors[node] = i; // assign the ith color to node
                
                //recurisvely check if the next node can be colored
                if(checkIfCanBeColored(node+1, m, n, colors, adj)) return true; 

                //rest color if it doesn't lead to a solution while back tracking
                colors[node] = 0;
            }
        }

        /*
         * if none of the color has returned true inside for loop then it can not be
         * possible to color n nodes using colors from 1 to m so return false
         */
        return false;
    }

    /* Function to check if a graph with n nodes can be colored with m colors */
    public boolean graphColoring(int[][] edges, int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i += 1) {
            adj.add(new ArrayList<>());
        }

        /* Build graph from given edges */
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int colors[] = new int[n]; // initialize all colors to 0 uncolored

        return checkIfCanBeColored(0, m, n, colors, adj);
    }
}

/*
 * time complexity : O(M^N) where m is the number of colors and n is the number
 * of nodes , since each node can be colored in m ways and there n node to color
 * 
 * space complexxity : O(n) for the colors array and O(n) for the adjacency
 * list, resulting in total O(n) space complexity
 */