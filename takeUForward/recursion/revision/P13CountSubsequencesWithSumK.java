package takeUForward.recursion.revision;

import java.util.ArrayList;

public class P13CountSubsequencesWithSumK {
    public static void countSubsequencesWithSumK(int []a, int sum){
        System.out.println(countSubsequencesWithSumK(a, new ArrayList<>(), 0, sum, 0));
    }

    private static int countSubsequencesWithSumK(int[] a, ArrayList<Integer> list, int i, int sum, int currentSum) {
        if ( i >= a.length){
            if ( currentSum == sum){
                return 1;
            }
            return 0;
        }
        list.add(a[i]);
        int take = countSubsequencesWithSumK(a, list, i+1, sum, currentSum+a[i]);
        list.remove(list.size()-1);
        int notTake = countSubsequencesWithSumK(a, list, i+1, sum, currentSum);
        return take + notTake;

    }
    
    public static void main(String[] args){
        int []a = {1,2,1};
        countSubsequencesWithSumK(a, 2);
    }
}
