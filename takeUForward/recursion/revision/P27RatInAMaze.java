package takeUForward.recursion.revision;

import java.util.ArrayList;

public class P27RatInAMaze {
    public static ArrayList<String> findSum(int[][] arr, int n) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        if ( arr[0][0] == 1){
            vis[0][0] = true;
            generatePaths(arr, n, ans , 0, 0, new StringBuilder(), vis);
        }
        return ans;
    }

    private static void generatePaths(int[][] arr, int n, ArrayList<String> ans, int i, int j,
                                      StringBuilder stringBuilder, boolean[][] vis) {
        if ( i == n-1 && j == n-1){
            ans.add(new String(stringBuilder.toString()));
        }

        // Down
        if ( i+1 <arr.length && !vis[i+1][j] && arr[i+1][j] == 1){
            vis[i+1][j] = true;
            stringBuilder.append("D");
            generatePaths(arr, n, ans, i+1, j, stringBuilder, vis);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            vis[i+1][j] = false;
        }

        // Left
        if ( j-1 >=0 && !vis[i][j-1] && arr[i][j-1] == 1){
            vis[i][j-1] = true;
            stringBuilder.append("L");
            generatePaths(arr, n, ans, i, j-1, stringBuilder, vis);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            vis[i][j-1] = false;
        }

        // Right
        if ( j+1 <arr.length && !vis[i][j+1] && arr[i][j+1] == 1){
            vis[i][j+1] = true;
            stringBuilder.append("R");
            generatePaths(arr, n, ans, i, j+1, stringBuilder, vis);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            vis[i][j+1] = false;
        }

        // Up
        if ( i-1 >=0 && !vis[i-1][j] && arr[i-1][j] == 1){
            vis[i-1][j] = true;
            stringBuilder.append("U");
            generatePaths(arr, n, ans, i-1, j, stringBuilder, vis);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            vis[i-1][j] = false;
        }

    }
}
