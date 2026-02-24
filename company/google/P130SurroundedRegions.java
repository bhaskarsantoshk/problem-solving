package company.google;

import java.util.LinkedList;
import java.util.Queue;

public class P130SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( i == 0 || i == n-1 || j == 0 || j == m-1){
                    if ( board[i][j] == 'O') queue.add(new int[]{i,j});
                }
            }
        }

        int [][] dirs = { {1,0}, {0,1}, {-1,0}, {0,-1}};

        while ( !queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            board[row][col] = 'o';

            for ( int [] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if ( nRow >=0 && nRow < n && nCol >=0  && nCol < m && board[nRow][nCol] == 'O' ){
                    queue.offer(new int[]{nRow, nCol});
                }
            }
        }

        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( board[i][j] == 'o') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
}
