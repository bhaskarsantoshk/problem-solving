package company.amazon.interviewbit;

import java.util.ArrayList;

public class RegionInBinaryMatrix {
    public int solve(int[][] A) {
        if ( A == null || A.length == 0 ){
            return 0;
        }
        int max_length = 0;
        for ( int i=0; i<A.length; i++){
            for ( int j=0; j<A[0].length; j++){
                if ( A[i][j] == 1) max_length = Math.max(max_length, max_length(A, i, j));
            }
        }
        return max_length;
    }

    private int max_length(int[][] a, int i, int j) {
        if ( i>=0 && i< a.length && j>=0 && j< a[0].length && a[i][j] == 1){
            a[i][j] = 0;
            return 1+max_length(a,i+1,j)+max_length(a,i-1,j)+max_length(a,i,j+1)+max_length(a,i, j-1)+
                    max_length(a,i-1,j-1) + max_length(a,i-1,j+1)+max_length(a,i+1,j-1)+max_length(a,i+1,j+1);
        }
        return 0;
    }
}

// https://www.interviewbit.com/problems/region-in-binarymatrix/
