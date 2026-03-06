package company.apple;

public class P37WordSearch {
    public boolean exist(char[][] board, String word) {
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( exist(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private boolean exist(char[][] board, int row, int col, String word, int index) {
        if ( index >= word.length()) return true;
        if ( row < 0 || row >= board.length || col <0 || col >= board[0].length || board[row][col] != word.charAt(index) ) return false;

        boolean found = false;
        char temp = board[row][col];
        board[row][col] = '#';
        for ( int [] dir: dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            found = found || exist(board, nRow, nCol, word, index+1);
            if ( found ) break;
        }
        board[row][col] = temp;
        return found;
    }


}
