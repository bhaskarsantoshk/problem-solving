package LeetCode;

public class P1252CellsWithOddValuesInAMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int a [][] = new int[n][m];

        for ( int [] index : indices){
            for (int j=0; j<m; j++){
                a[index[0]][j]++;
            }
            for ( int i =0; i<n; i++){
                a[i][index[1]]++;
            }
        }
        int res = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( a[i][j] % 2 != 0){
                    res++;
                }
            }
        }
        return res;
    }
}
