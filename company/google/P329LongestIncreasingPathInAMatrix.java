package company.google;

import java.util.Arrays;

public class P329LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int max = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                int length = dfs(n, m, matrix, i, j);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    private int dfs(int n, int m, int[][] matrix, int i, int j) {
        int max = 1;
        for ( int[] dir: dirs){
            int newRow = i+dir[0];
            int newCol = j+ dir[1];
            if ( newRow < 0 || newRow >= n || newCol <0 || newCol >= m || matrix[newRow][newCol] <= matrix[i][j]) continue;
            int len = 1 + dfs(n, m, matrix, newRow, newCol);
            max = Math.max(len, max);
        }
        return max;
    }

    public int longestIncreasingPathMemoized(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int max = 0;
        int [][] memo = new int[n][m];
        for ( int[] row: memo){
            Arrays.fill(row, -1);
        }
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                int length = dfsMemoized(n, m, matrix, i, j, memo);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    // private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    private int dfsMemoized(int n, int m, int[][] matrix, int i, int j, int[][] memo) {
        int max = 1;
        if ( memo[i][j] != -1 ) return memo[i][j];
        for ( int[] dir: dirs){
            int newRow = i+dir[0];
            int newCol = j+ dir[1];
            if ( newRow < 0 || newRow >= n || newCol <0 || newCol >= m || matrix[newRow][newCol] <= matrix[i][j]) continue;
            int len = 1 + dfsMemoized(n, m, matrix, newRow, newCol, memo);
            max = Math.max(len, max);
        }
        return  memo[i][j]= max;
    }

    public int longestIncreasingPathTabular(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int [][] dp = new int[n][m];
        int globalMax = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                int max = 1;
                int up, down, left, right;
                up = down = left = right = (int) -1e9;
                if ( i > 0 ) up = 1+ dp[i-1][j];
                if ( j > 0) left = 1 + dp[i][j-1];
                if ( i < n) down = 1 + dp[i+1][j];
                if ( j < m) right = 1 + dp[i][j+1];
                max = Math.max (max , Math.max(Math.max ( up, down), Math.max(left, right)));
                globalMax = Math.max( globalMax, max);
            }
        }
        return globalMax;
    }
}
