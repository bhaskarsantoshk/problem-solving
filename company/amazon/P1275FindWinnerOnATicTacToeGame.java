package company.amazon;

public class P1275FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int [] rows = new int[n];
        int[] cols = new int[n];
        int diag1 = 0;
        int diag2 = 0;
        int curPlayer = 1 ; // 1 for A, -1 for B
        for ( int[] curMove : moves){
            rows[curMove[0]] += curPlayer;
            cols[curMove[1]] += curPlayer;
            diag1 = ( curMove[0] == curMove[1]) ? diag1+ curPlayer: diag1;
            diag2 = ( curMove[0] + curMove[1] == n-1) ? diag2 + curPlayer: diag2;

            if ( Math.abs(rows[curMove[0]]) == n || Math.abs(cols[curMove[1]]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n) {
                return curPlayer == 1 ? "A" : "B";
            }
            curPlayer *= -1;
        }
       return (moves.length <9) ? "Pending":"Draw";
    }
}
