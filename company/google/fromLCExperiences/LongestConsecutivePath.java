package company.google.fromLCExperiences;

import java.util.*;

public class LongestConsecutivePath {
    // Directions array to move in 8 possible directions (horizontal, vertical, diagonal)
    private static final int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Up, Down, Right, Left
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Diagonals
    };

    public int longestConsecutivePath(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int maxLength = 0;

        // Perform BFS/DFS for every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, bfs(grid, i, j));
            }
        }
        return maxLength;
    }

    // BFS implementation to find the longest path starting from (i, j)
    private int bfs(int[][] grid, int startX, int startY) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        int length = 1; // Start with length 1 (current cell)

        // Keep track of visited cells
        boolean[][] visited = new boolean[rows][cols];
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                // Explore all 8 directions
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check boundaries and if the new value is consecutive
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                            !visited[newX][newY] && Math.abs(grid[newX][newY] - grid[x][y]) == 1) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        length++; // Increase the path length
                    }
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LongestConsecutivePath solution = new LongestConsecutivePath();
        int[][] grid = {
                {1, 2, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(solution.longestConsecutivePath(grid)); // Output: 9
    }
}
