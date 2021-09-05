package company.amazon.leetcode;

public class P289GameOfLife {
    int [][] dirs = {{0,1},{0,-1}, {-1,0}, {1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
    public void gameOfLife(int[][] board) {
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                int live = 0;
                for ( int[] d : dirs){
                    if ( d[0]+i <0 || d[0]+i >= board.length || d[1]+j <0 || d[1]+j>= board[0].length) continue;
                    if ( board[i+d[0]][j+d[1]] == 1 || board[i+d[0]][j+d[1]] == 2) live++;
                }
                if ( board[i][j] == 0 && live == 3) board[i][j] = 3;
                if ( board[i][j] == 1 && (live<2 || live>3)) board[i][j] = 2;
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %=2;
            }
        }
    }
}
