package striver_sde_sheet.dynamic_programming;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Memoization map to store the minimum path sum from each point
        Map<String, Integer> memo = new HashMap<>();
        return minimumTotal(triangle, 0, 0, memo);
    }

    private int minimumTotal(List<List<Integer>> triangle, int i, int j, Map<String, Integer> memo) {
        // Base case: if we're at the bottom row, return the element at that position
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        // Check if the result is already computed
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursively compute the minimum path sum for the current element
        int down = minimumTotal(triangle, i + 1, j, memo);
        int diag = minimumTotal(triangle, i + 1, j + 1, memo);
        int minPath = triangle.get(i).get(j) + Math.min(down, diag);

        // Store the result in the memoization map
        memo.put(key, minPath);

        return minPath;
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        return minimumTotal(0,0, triangle, n-1);
    }

    private static int minimumTotal(int i, int j, int[][] triangle, int n) {
        if ( i == n) return  triangle[i][j];
        int down = Integer.MAX_VALUE, diag = Integer.MAX_VALUE;
        down = triangle[i][j] + minimumTotal(i+1, j, triangle, n);
        diag =  triangle[i][j] + minimumTotal(i+1, j+1, triangle, n);
        return Math.min(down, diag);
    }

    public static int minimumPathSumMemoized(int[][] triangle, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return minimumPathSumMemoized(0,0, triangle, n-1, memo);
    }

    private static int minimumPathSumMemoized(int i, int j, int[][] triangle, int n, Map<String, Integer> memo) {
        if ( i == n) return  triangle[i][j];
        if ( memo.containsKey(i+""+j) ) return memo.get(i+""+j);
        int down = Integer.MAX_VALUE, diag = Integer.MAX_VALUE;
        down = triangle[i][j] + minimumPathSumMemoized(i+1, j, triangle, n, memo);
        diag =  triangle[i][j] + minimumPathSumMemoized(i+1, j+1, triangle, n, memo);
        int ans = Math.min(down, diag);
        memo.put(i+""+j, ans);
        return ans;
    }

    public static int minimumPathSumTabular(int[][] triangle, int n) {
        int [][] dp = new int[n][n];
        for ( int j=0; j<n; j++) dp[n-1][j] = triangle[n-1][j];
        for ( int i=n-2; i>=0; i--){
            for ( int j=i; j>=0; j--){
                int down = triangle[i][j] + dp[i+1][j];
                int diag = triangle[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}
