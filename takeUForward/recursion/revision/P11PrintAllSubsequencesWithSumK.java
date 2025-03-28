package takeUForward.recursion.revision;

import java.sql.Array;
import java.util.ArrayList;

public class P11PrintAllSubsequencesWithSumK {
    public static void printAllSubsequencesWithSumK(int []a, int sum){
        printAllSubsequencesWithSumK(a, new ArrayList<>(), 0, sum, 0);
    }

    private static void printAllSubsequencesWithSumK(int[] a, ArrayList<Integer> list, int i, int sum, int currentSum) {
        if ( i >= a.length){
            if ( currentSum == sum){
                print(list);
            }
            return;
        }
        list.add(a[i]);
        printAllSubsequencesWithSumK(a, list, i+1, sum, currentSum+a[i]);
        list.remove(list.size()-1);
        printAllSubsequencesWithSumK(a, list, i+1, sum, currentSum);
    }

    private static void print(ArrayList<Integer> list) {
        for ( int num: list) System.out.print(num+" ");
        System.out.println();
    }

    public static void main(String[] args){
        int []a = {1,2,1};
        printAllSubsequencesWithSumK(a, 2);
    }
}
