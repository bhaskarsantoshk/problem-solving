package company.amazon.leetcode;

public class P64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        return minPathsumRec(grid, height-1, width-1);
    }

    private int minPathsumRec(int[][] grid, int row, int col) {
        if ( row == 0 && col == 0) return grid[0][0];
        if ( row == 0) return grid[row][col] + minPathsumRec(grid, row, col-1);
        if ( col == 0) return grid[row][col] + minPathsumRec(grid, row-1, col);
        return grid[row][col]+Math.min (minPathsumRec(grid, row-1, col), minPathsumRec(grid, row, col-1));
    }

}
