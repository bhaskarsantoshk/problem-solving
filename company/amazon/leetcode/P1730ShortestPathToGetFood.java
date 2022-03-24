package company.amazon.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class P1730ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        if ( grid == null || grid.length == 0){
            return -1;
        }
        int[] start = findStart(grid);
        int m = grid.length, n= grid[0].length;
        if ( !isValid(start[0], start[1], grid)){
            return -1;
        }
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int steps = 0;
        boolean[][] visited = new boolean[m][n];
        while ( !queue.isEmpty()){
            int len = queue.size();
            for ( int i=0; i<len; i++){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if ( grid[x][y] == '#') return steps;

                for ( int[] dir : dirs){
                    int newX= x+ dir[0];
                    int newY = y + dir[1];
                    if ( isValid(newX, newY, grid) && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isValid(int i, int j, char[][] grid) {
        return ( i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] !='X');
    }

    private int[] findStart(char[][] grid) {
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[0].length; j++){
                if ( grid[i][j] == '*'){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
