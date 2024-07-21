package Recursion;

import java.util.ArrayList;

public class AnySubsequencesWithSumK {
    public void printAnySubsequencesWithSumK(int[] arr, int K){
        printAnySubsequencesWithSumK(new ArrayList<Integer>(), arr, 0, 0, K);
    }

    private boolean printAnySubsequencesWithSumK(ArrayList<Integer> list, int[] arr, int index, int sum, int K) {
        if ( index >= arr.length) {
            if ( sum == K) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[index]);
        boolean res = printAnySubsequencesWithSumK(list, arr, index+1, sum+arr[index], K);
        if ( res ) return true;
        list.removeLast();
        res = printAnySubsequencesWithSumK(list, arr, index+1, sum, K);
        if ( res ) return true;
        return false;
    }

    public static void main(String[] args){
        int [] arr = { 1, 2, 1, 4, 3};
        AnySubsequencesWithSumK obj = new AnySubsequencesWithSumK();
        obj.printAnySubsequencesWithSumK(arr, 4);
    }
}
