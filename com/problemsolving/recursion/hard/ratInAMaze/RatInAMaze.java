import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInAMaze {
    List<String> result = new ArrayList<>();

    private void path(int[][] grid, int col, int row, String direction, int n) {

        /* if destination is reached, add path to result */
        if (row == n - 1 && col == n - 1) {
            result.add(direction);
            return;
        }

        /* if cell is blocked then return */
        if (grid[row][col] == 0)
            return;

        /* mark cell as visited by setting it to 0 */
        grid[row][col] = 0;

        /* move upward if possible */
        if (row > 0)
            path(grid, col, row - 1, direction + 'U', n);

        /* move left if possible */
        if (col > 0)
            path(grid, col - 1, row, direction + 'L', n);

        /* move down if possible */
        if (row < n - 1)
            path(grid, col, row + 1, direction + 'D', n);

        /* move right if possible */
        if (col < n - 1)
            path(grid, col + 1, row, direction + 'R', n);

        /* unmark cell while backtracking */
        grid[row][col] = 1;
    }

    public List<String> findPath(int[][] grid) {
        int n = grid.length;

        /* if starting or ending cell is blocked, return empty result */
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) {
            return result;
        }

        /* start finding paths from (0,0) */
        path(grid, 0, 0, "", n);

        Collections.sort(result);

        return result;
    }
}

/*
 * Time complexity : O(4^n^2) due to recursion exploring all paths in the grid
 * 
 * Space complexity : Space complexity is O(n^2) for the recursion stack and
 * result storage
 */