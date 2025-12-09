package takeUForward.google;

public class PFindRowWithMaximum1S {
    public int rowWithMax1sBruteForce(int[][] mat) {
        int maxRow = -1;
        int count = 0;
        int maxCount = 0;
        for ( int i=0; i<mat.length; i++){
            count = 0;
            for ( int j=0; j<mat[0].length; j++){
                count+= mat[i][j];
            }
            if ( maxCount < count){
                maxRow = i;
                maxCount = count;
            }
        }
        return maxRow;
    }

    public int rowWithMax1sBinarySearch(int[][] mat) {
        int maxRow = -1;
        int maxCount = 0;
        int m = mat.length;
        int n = mat[0].length;
        for ( int i=0; i<m; i++){
            int index = lowerBound(mat[i], 1);
            if ( index < n){
                int count = n - index;
                if (count > maxCount) {
                    maxCount = count;
                    maxRow = i;
                }
            }
        }
        return maxRow;
    }

    private int lowerBound(int[] arr, int key) {
        int start = 0, end = arr.length-1;
        int result = arr.length;
        while ( start <= end ){
            int mid = start + ( end-start)/2;
            if ( arr[mid] >= key){
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return result;
    }
}
