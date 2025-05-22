package com.dsa.recursion1.RatInAMaze;

import java.util.ArrayList;
import java.util.List;

public class RatInaMaze {
    public void findAllPossiblePath(int[][] grid, int row, int col, String path, List<String> result) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            result.add(path);
            return;
        }
        grid[row][col] = 0; // Mark the cell as visited
        if (row > 0)
            findAllPossiblePath(grid, row - 1, col, path + "U", result);
        if (col > 0)
            findAllPossiblePath(grid, row, col - 1, path + "L", result);
        if (row < grid.length - 1)
            findAllPossiblePath(grid, row + 1, col, path + "D", result);
        if (col < grid[0].length - 1)
            findAllPossiblePath(grid, row, col + 1, path + "R", result);
        grid[row][col] = 1; // Backtrack to unmark the cell
    }

    public List<String> findPath(int[][] grid) {
        List<String> result = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 0 || grid[n - 1][m - 1] == 0) {
            return result;
        }
        String path = "";
        findAllPossiblePath(grid, 0, 0, path, result);
        return result;
    }
}
