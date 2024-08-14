package takeuForward.recursion;

import java.util.ArrayList;

public class AllSubsequencesWithSumK {
    public void printAllSubsequencesWithSumK(int[] arr, int K){
        printAllSubsequencesWithSumK(new ArrayList<Integer>(), arr, 0, 0, K);
    }

    private void printAllSubsequencesWithSumK(ArrayList<Integer> list, int[] arr, int index, int sum, int K) {
        if ( index >= arr.length) {
            if ( sum == K) System.out.println(list);
            return;
        }
        list.add(arr[index]);
        printAllSubsequencesWithSumK(list, arr, index+1, sum+arr[index], K);
        list.removeLast();
        printAllSubsequencesWithSumK(list, arr, index+1, sum, K);
    }

    public static void main(String[] args){
        int [] arr = { 1, 2, 1, 4, 3};
        AllSubsequencesWithSumK obj = new AllSubsequencesWithSumK();
        obj.printAllSubsequencesWithSumK(arr, 4);
    }
}
