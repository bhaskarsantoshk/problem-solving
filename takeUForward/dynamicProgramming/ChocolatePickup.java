package takeUForward.dynamicProgramming;

import java.util.PriorityQueue;

public class ChocolatePickup {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        return maximumChocolates(0, 0, c-1, r, c, grid);
    }

    private static int maximumChocolates(int i, int j1, int j2, int r, int c, int[][] grid){
        if ( j1 < 0 || j1>= c || j2 <0 || j2 >= c) return (int) -1e9;
        if ( i == r-1 ){
            if ( j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        int max = 0;
        for ( int dj1=-1; dj1<=1; dj1++){
            for ( int dj2= -1; dj2<=1; dj2++){
                if ( j1 == j2) max = Math.max( max, grid[i][j1]+ maximumChocolates(i+1, j1+dj1, j2+dj2, r, c, grid));
                else max = Math.max( max, grid[i][j1]+ grid[i][j2]+ maximumChocolates(i+1, j1+dj1, j2+dj2, r, c, grid));
            }
        }
        return max;
    }

    public static int maximumChocolatesMemoized(int r, int c, int[][] grid) {
        int [][][] memo = new int[r][c][c];
        for ( int i=0; i<memo.length; i++){
            for ( int j=0; j<memo[0].length; j++){
                for ( int k=0; k<memo[0][0].length; k++){
                    memo[i][j][k] = -1;
                }
            }
        }
        return maximumChocolatesMemoized(0, 0, c-1, r, c, grid, memo);
    }

    private static int maximumChocolatesMemoized(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] memo){
        if ( j1 < 0 || j1>= c || j2 <0 || j2 >= c) return (int) -1e9;
        if ( i == r-1 ){
            if ( j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if ( memo[i][j1][j2] == -1) return memo[i][j1][j2];
        int max = 0;
        for ( int dj1=-1; dj1<=1; dj1++){
            for ( int dj2= -1; dj2<=1; dj2++){
                int value = 0;
                if ( j1 == j2) value= grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += maximumChocolatesMemoized(i+1, j1+dj1, j2+dj2, r, c, grid, memo);
                max = Math.max( value, max);
            }
        }
        return memo[i][j1][j2]=max;
    }

    public static int maximumChocolatesTabular(int r, int c, int[][] grid) {
        int [][][] dp = new int[r][c][c];
        for ( int j1=0; j1<c; j1++){
            for ( int j2=0; j2<c; j2++){
                if ( j1 == j2 ) dp[r-1][j1][j2] = grid[r-1][j1];
                else dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }
        for ( int i=r-2; i>=0 ; i--){
            for ( int j1=0; j1<c; j1++){
                for ( int j2=0; j2<c; j2++){
                    int max = (int) -1e9;
                    for ( int dj1=-1; dj1<=1; dj1++){
                        for ( int dj2= -1; dj2<=1; dj2++){
                            int value = 0;
                            if ( j1 == j2) value= grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if ( j1+dj1 >= 0 && j1+dj1 < c &&  j2+dj2 >=0 && j2+dj2 < c) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else value += (int)-1e9;
                            max = Math.max( max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][c-1];
    }

    public static int maximumChocolatesTabularSpaceOptimized(int r, int c, int[][] grid) {
        int [][] front = new int[c][c];
        int [][] cur = new int[c][c];
        for ( int j1=0; j1<c; j1++){
            for ( int j2=0; j2<c; j2++){
                if ( j1 == j2 ) front[j1][j2] = grid[r-1][j1];
                else front[j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }
        for ( int i=r-2; i>=0 ; i--){
            for ( int j1=0; j1<c; j1++){
                for ( int j2=0; j2<c; j2++){
                    int max = (int) -1e9;
                    for ( int dj1=-1; dj1<=1; dj1++){
                        for ( int dj2= -1; dj2<=1; dj2++){
                            int value = 0;
                            if ( j1 == j2) value= grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if ( j1+dj1 >= 0 && j1+dj1 < c &&  j2+dj2 >=0 && j2+dj2 < c) {
                                value += front[j1 + dj1][j2 + dj2];
                            } else value += (int)-1e9;
                            max = Math.max( max, value);
                        }
                    }
                    cur[j1][j2] = max;
                }
            }
            int[][] temp = front;
            front = cur;
            cur = temp;
        }
        return front[0][c-1];
    }

}
