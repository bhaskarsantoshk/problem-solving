package takeUForward.recursion.revision;

import java.util.ArrayList;

public class P12PrintAnySubsequencesWithSumK {
    public static void printAnySubsequencesWithSumK(int []a, int sum){
        printAnySubsequencesWithSumK(a, new ArrayList<>(), 0, sum, 0);
    }

    private static boolean printAnySubsequencesWithSumK(int[] a, ArrayList<Integer> list, int i, int sum, int currentSum) {
        if ( i >= a.length){
            if ( currentSum == sum){
                print(list);
                return true;
            }
            return false;
        }
        list.add(a[i]);
        if (printAnySubsequencesWithSumK(a, list, i+1, sum, currentSum+a[i])) return true;
        list.remove(list.size()-1);
        if ( printAnySubsequencesWithSumK(a, list, i+1, sum, currentSum)) return true;
        return false;
    }

    private static void print(ArrayList<Integer> list) {
        for ( int num: list) System.out.print(num+" ");
        System.out.println();
    }

    public static void main(String[] args){
        int []a = {1,2,1};
        printAnySubsequencesWithSumK(a, 2);
    }
}
