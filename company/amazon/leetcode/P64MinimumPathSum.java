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

    // Approach 2: DP
    public int minPathSumDP (int[][] grid){
        if ( grid == null || grid.length == 0) return 0;
        int height = grid.length;
        int width = grid[0].length;

        for ( int row = 0; row<height; row++){
            for ( int col = 0; col <width; col++){
                if (row == 0 && col == 0){
                    continue;
                } else if ( row == 0){
                    grid[row][col] += grid[row][col-1];
                } else if ( col == 0){
                    grid[row][col] += grid[row-1][col];
                } else {
                    grid[row][col]+= Math.min(grid[row-1][col], grid[row][col-1]);
                }
            }
        }
        return grid[height-1][width-1];
    }

}
