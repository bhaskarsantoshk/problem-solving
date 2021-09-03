package company.amazon.leetcode;

public class P529Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0]==null || board[0].length == 0
                || click == null || click.length == 0 ){
            return board;
        }

        int x = click[0], y = click[1], m = board.length, n = board[0].length;
        if ( board[x][y] == 'M'){
            board[x][y] = 'X';
        } else {
            int[][] dirs = {{1,0}, {-1,0},{0,1}, {1,1}, {1, -1}, {-1,1}, {-1, -1}, {0,-1}};
            dfs(board,x,y,m,n, dirs);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y, int m, int n, int[][] dirs) {
        if ( x < 0 || x>= m || y < 0 || y>= n || board[x][y] != 'E'){
            return;
        }
        int adjMineCount = getAdjMineCount(board, x, y, m, n);
        if ( adjMineCount > 0){
            board[x][y] = (char)('0'+adjMineCount);
        } else {
            board[x][y] = 'B';
            for ( int[] d: dirs){
                dfs(board, x+d[0], y+d[1], m, n, dirs);
            }
        }
    }

    private int getAdjMineCount(char[][] board, int x, int y, int m, int n) {
        int count =0;
        for ( int i=x-1; i<=x+1; i++){
            for (int j=y-1; j<=y+1; j++){
                if ( i>=0 && i<m && j>=0 && j<n && board[i][j] =='M'){
                    count++;
                }
            }
        }
        return count;
    }
}
