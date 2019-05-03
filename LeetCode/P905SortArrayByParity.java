package LeetCode;

public class P905SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length-1;
        while(start <= end ){
            if(A[start] %2 == 0 || A[end]%2 != 0){
                if(A[start] % 2 == 0){
                    start++;
                }
                if(A[end] % 2 != 0){
                    end--;
                }
            }
            else{
                int temp= A[start];
                A[start] = A[end];
                A[end]= temp;
                start++;
                end--;
            }
        }
        return A;
    }
}
