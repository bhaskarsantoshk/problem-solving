package LeetCode;

public class P867TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if(A.length == 0 ) return A;
        if(A.length== A[0].length){
            return transpose(A, true);
        }
        else{
            return transpose(A, false);
        }
    }
    public int[][] transpose(int[][] A, boolean isSquare){
        if(isSquare){
            for(int i=0; i<A.length; i++){
                for(int j=i+1; j<A.length; j++){
                    int temp= A[i][j];
                    A[i][j]= A[j][i];
                    A[j][i]= temp;
                }
            }
            return A;
        }
        else{
            int result[][]= new int[A[0].length][A.length];
            for(int i=0; i<A[0].length; i++){
                for(int j=0; j< A.length; j++){
                    result[i][j]=A[j][i];
                }
            }
            return result;
        }
    }
}
