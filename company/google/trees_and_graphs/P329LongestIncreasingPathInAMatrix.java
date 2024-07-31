package company.google.trees_and_graphs;

public class P329LongestIncreasingPathInAMatrix {
    private static final int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        if ( matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for ( int i=0; i<matrix.length; i++){
            for ( int j=0; j<matrix[0].length; j++){
                int len = dfs( matrix, i, j , cache);
                max = Math.max( len, max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if ( cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for ( int dir[] : dirs){
            int x = i+ dir[0], y = j+dir[1];
            if ( x < 0 || x >= matrix.length || y <0 || y>= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs( matrix, x, y, cache);
            max = Math.max (len, max);
        }
        cache[i][j] = max;
        return max;
    }
}

/*
Without Cache: 𝑂 ( ( 4 𝑚 𝑛 ) O((4 mn ) (exponential time complexity).
With Cache: 𝑂 ( 𝑚 × 𝑛 ) O(m×n) (polynomial time complexity).
 */
