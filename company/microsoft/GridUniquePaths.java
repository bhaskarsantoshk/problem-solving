package company.microsoft;

public class GridUniquePaths {
    public int uniquePaths(int A, int B) {
        int gridUniquePaths[][] = new int[A][B];

        // first row
        for(int i=0;i<B;i++){
            gridUniquePaths[0][i]=1;
        }
        
        // first column
        for(int i=0;i<A;i++){
            gridUniquePaths[i][0] = 1;
        }

        for(int i=1;i<A;i++){
            for(int j=1;j<B;j++){
                gridUniquePaths[i][j] = gridUniquePaths[i-1][j]+gridUniquePaths[i][j-1];
            }
        }
        return gridUniquePaths[A-1][B-1];
    }
}
