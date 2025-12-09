package takeUForward.google;

public class PFindRowWithMaximum1S {
    public int rowWithMax1sBruteForce(int[][] mat) {
        int maxRow = 0;
        int count = 0;
        int maxCount = -1;
        for ( int i=0; i<mat.length; i++){
            count = 0;
            for ( int j=0; j<mat[0].length; j++){
                count+= mat[i][j];
            }
            if ( maxCount > count){
                maxRow = i;
                maxCount = count;
            }
        }
        return maxRow == 0 ? -1: maxRow;
    }

    public int rowWithMax1sBinarySearch(int[][] mat) {
        int maxRow = 0;
        int count = 0;
        int maxCount = -1;
        for ( int i=0; i<mat.length; i++){

        }
        return maxRow == 0 ? -1: maxRow;
    }
}
