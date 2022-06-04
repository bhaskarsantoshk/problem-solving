package express_prep.amzn.top_voted;

public class DesignTicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int antiDiag;
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1: -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if ( row == col ) diag += toAdd;
        if ( row + col == cols.length-1 ) antiDiag += toAdd;
        int size = rows.length;
        if ( Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs ( diag) == size ||
                Math.abs(antiDiag) == size){
            return player;
        }
        return 0;
    }
}
