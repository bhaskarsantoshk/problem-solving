package takeUForward.recursion;

import java.util.ArrayList;

public class CountSubsequencesWithSumK {
    public int countSubsequencesWithSumK(int[] arr, int K){
       return countSubsequencesWithSumK(new ArrayList<Integer>(), arr, 0, 0, K);
    }

    private int countSubsequencesWithSumK(ArrayList<Integer> list, int[] arr, int index, int sum, int K) {
        if ( index >= arr.length) {
            if ( sum == K) return 1;
            return 0;
        }
        list.add(arr[index]);
        int left = countSubsequencesWithSumK(list, arr, index+1, sum+arr[index], K);
        list.removeLast();
        int right = countSubsequencesWithSumK(list, arr, index+1, sum, K);
        return left+right;
    }

    public static void main(String[] args){
        int [] arr = { 1, 2, 1, 4, 3};
        CountSubsequencesWithSumK obj = new CountSubsequencesWithSumK();
        System.out.println(obj.countSubsequencesWithSumK(arr, 4));
    }
}
