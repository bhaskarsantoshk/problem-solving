package company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        dfs(a, 0);
    }

    private boolean dfs(ArrayList<ArrayList<Character>> board, int d) {
        if(d==81){
            return true;
        }
        int i=d/9, j=d%9;
        //Skip pre-filled number
        if(board.get(i).get(j)!='.'){
            return dfs(board, d+1);
        }

        boolean flag[] = new boolean[10];
        validate(board, i, j, flag);

        for(int k=1;k<=9; k++){
            if(flag[k]){
                board.get(i).set(j, (char)('0'+k));
                if(dfs(board, d+1)){
                    return true;
                }
            }
        }
        board.get(i).set(j,'.'); //If cannot solve, change back to '.' and out
        return false;

    }

    private void validate(ArrayList<ArrayList<Character>> board, int i, int j, boolean[] flag) {
        Arrays.fill(flag,true);
        for (int k=0; k<9; k++) {
            if (board.get(i).get(k)!='.') flag[board.get(i).get(k)-'0']=false;
            if (board.get(k).get(j)!='.') flag[board.get(k).get(j)-'0']=false;
            int r=i/3*3+k/3;
            int c=j/3*3+k%3;
            if (board.get(r).get(c)!='.') flag[board.get(r).get(c)-'0']=false;
        }
    }
}
