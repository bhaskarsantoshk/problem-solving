package takeUForward.recursion.revision;

import java.util.ArrayList;

public class P28KthPermutationSequence {
    public static String kthPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> nums = new ArrayList<>();
        for ( int i=1; i<n; i++){
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        k = k-1;
        StringBuilder sb = new StringBuilder();
        while (true){
            sb.append(nums.get(k/fact));
            nums.remove(k/fact);
            if ( nums.size() == 0) break;
            k = k % fact;
            fact = fact/nums.size();
        }
        return sb.toString();
    }
}
