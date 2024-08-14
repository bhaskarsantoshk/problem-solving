package takeUForward.recursion;

import java.util.ArrayList;

public class PRatInAMazeProblemI {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res = new ArrayList<>();
        if ( mat[0][0] == 0) return res;
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        vis[0][0] = true;
        findPath(mat, 0, 0, new StringBuilder(), res, vis);
        return res;
    }

    private void findPath(int[][] mat, int row, int col, StringBuilder sb, ArrayList<String> res, boolean [][] vis) {
        if ( row == mat.length-1 && col == mat[0].length-1){
            res.add(sb.toString());
            return;
        }

        // Down , Left, Right , Up
        int [][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        char[] dir = {'D', 'L', 'R', 'U'};
        for ( int i=0; i<4; i++){
            int newRow = row+dirs[i][0];
            int newCol = col+dirs[i][1];
            if ( newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                    && mat[newRow][newCol] != 0  && !vis[newRow][newCol]) {
                sb.append(dir[i]);
                vis[newRow][newCol] = true;
                findPath(mat, newRow, newCol, sb, res, vis);
                sb.deleteCharAt(sb.length() - 1);
                vis[newRow][newCol] = false;
            }
        }

    }
}
