package company.amazon;

import java.util.ArrayList;

public class BlackShapes {
    public int black(ArrayList<String> A) {
        if ( A == null || A.size() == 0){
            return 0;
        }
        char[][] grid = new char[A.size()][A.get(0).length()];
        for ( int i=0; i<A.size(); i++){
            for ( int j=0; j<A.get(i).length(); j++){
                grid[i][j] = A.get(i).charAt(j);
            }
        }
        int count = 0;
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[i].length; j++){
                if ( grid[i][j] =='X'){
                    dfs( grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if ( i < 0 || j <0 || i>=grid.length || j>= grid[0].length || grid[i][j] != 'X'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}
