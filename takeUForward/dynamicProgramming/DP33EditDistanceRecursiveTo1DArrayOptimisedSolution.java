package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP33EditDistanceRecursiveTo1DArrayOptimisedSolution {
    public static int editDistance(String str1, String str2) {
        return editDistance(str1, str2, str1.length()-1, str2.length()-1);
    }

    private static int editDistance(String str1, String str2, int i, int j) {
        if ( i < 0) return j+1; // insertions
        if ( j < 0) return i+1; // deletions

        if (str1.charAt(i) == str2.charAt(j)){
            return editDistance(str1, str2, i-1, j-1);
        } else {
            int insert = 1 + editDistance(str1, str2, i, j-1);
            int delete = 1 + editDistance(str1, str2, i-1, j);
            int replace = 1 + editDistance(str1, str2, i-1, j-1);
            return Math.min(Math.min(insert, delete), replace);
        }
    }

    public static int editDistanceMemo(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int [][] memo = new int[n][m];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return editDistanceMemo(str1, str2, str1.length()-1, str2.length()-1, memo);
    }

    private static int editDistanceMemo(String str1, String str2, int i, int j, int[][] memo) {
        if ( i < 0) return j+1; // insertions
        if ( j < 0) return i+1; // deletions
        if ( memo[i][j] != -1) return memo[i][j];
        if (str1.charAt(i) == str2.charAt(j)){
            return memo[i][j] = editDistanceMemo(str1, str2, i-1, j-1, memo);
        } else {
            int insert = 1 + editDistanceMemo(str1, str2, i, j-1, memo);
            int delete = 1 + editDistanceMemo(str1, str2, i-1, j, memo);
            int replace = 1 + editDistanceMemo(str1, str2, i-1, j-1, memo);
            return memo[i][j] = Math.min(Math.min(insert, delete), replace);
        }
    }
}
