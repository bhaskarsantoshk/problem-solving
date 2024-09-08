package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class L19RatInAMazeBacktracking {
    public List<String> findPath(int[][] grid) {
        List<String> result = new ArrayList<>();
        findPath(grid, 0, 0, grid.length-1, grid[0].length-1, "", result);
        return result;
    }

    private void findPath(int[][] grid, int i, int j, int n, int m, String s, List<String> result) {
        if ( i == n && j == m) {
            result.add(s);
        }

        if ( grid[i][j] == 0) return;

        grid[i][j] = 0;

        // Up
        if ( i-1 >= 0 && grid[i-1][j] == 1){
            findPath(grid, i-1, j, n, m, s+"U", result);
        }
        // Down
        if ( i+1 <= n && grid[i+1][j] == 1){
            findPath(grid, i+1, j, n, m, s+"D", result);
        }
        // Left
        if ( j-1 >=0 && grid[i][j-1] == 1){
            findPath(grid, i, j-1, n, m, s+"L", result);
        }

        // Right
        if ( j+1 <= m && grid[i][j+1] == 1){
            findPath(grid, i, j+1, n, m, s+"R", result);
        }
        grid[i][j] = 1;
    }
}
