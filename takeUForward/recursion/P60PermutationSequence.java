package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class P60PermutationSequence {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for ( int i=1; i<n; i++){
            nums.add(i);
            fact *= i; // up to (n-1)!
        }
       nums.add(n);
        StringBuilder sb = new StringBuilder();
        k = k-1;
        while ( true){
            sb.append(nums.get(k/fact));
            nums.remove(k/fact);
            if (nums.isEmpty()) break;
            k = k%fact;
            fact = fact/nums.size();
        }
        return sb.toString();
    }

    // n = 4 , k = 17
    // k -> 16th number
    // 1 ( 6 )
    // 2 ( 6 )
    // 3 ( 6 )
    // 4 ( 6 )

    // 3 ( 1 2 4 )
    // k = 4 , { 1 2 4}
    // 3 1 ( 2 )
    // 3 2 ( 2 )
    // 3 4 ( 2 )
    // 3 4 1 2
}
