package LeetCode;

public class P961NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        for(int i=2; i<A.length; i++){
            if(A[i]== A[i-1] || A[i]== A[i-2]){
                return A[i];
            }
        }
        return A[0];
    }
}
