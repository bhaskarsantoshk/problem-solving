package LeetCode;

public class P1007MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        if(A.length != B.length) return -1;
        int n = A.length;
        int rotationsA = check(A[0], n, A, B);
        int rotationsB= check(B[0], n, A, B);
        System.out.println(rotationsB+" "+ rotationsA);
        if(rotationsA == -1 && rotationsB == -1) return -1;
        else if ( rotationsA != -1 && rotationsB != -1) return Math.min(rotationsA, rotationsB);
        else return rotationsA != -1 ? rotationsA : rotationsB;

    }

    private int check(int x, int n, int[] a, int[] b) {
        int ra=0;
        int rb=0;
        for(int i=0; i<n; i++){
            if(a[i] != x && b[i]!= x){
                return -1;
            }
            else if( a[i] != x){
                ra++;
            }
            else if(b[i] != x){
                rb++;
            }
        }
        return Math.min(ra, rb);
    }
}
