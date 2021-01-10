package LeetCode.explore.arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length-1;
        while ( left < right ){
            if ( A[left] % 2 == 0){
                left++;
            }
            else {
                int temp = A[left];
                A[left] = A[right];
                A[right--] = temp;
            }
        }
        return A;
    }
}