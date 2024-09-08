package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class L18KThPermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for ( int i=0; i<n; i++){
            nums.add(i+1);
            if ( i < n-1) {
                fact *= (i + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        k--;
        while (true){
            sb.append(nums.get(k/fact));
            nums.remove(k/fact);
            if (nums.isEmpty()) break;
            k = k%fact;
            fact = fact/nums.size();
        }
        return sb.toString();
    }

    // 1 2 3 4 -> 24

    // 1 { 2 3 4 } - 1st 6 - indexes: 0-5
    // 2 { 1 3 4 } - 7-12 - indexes: 6-11
    // 3 { 1 2 4 } - 13 - 18 - indexes- 12 - 17
    // 4 { 1 2 3 } - 19- 24 - 18-23

    // if k is 17
    // 17 / 6 = 2
    // 3 , k = 17 %6 = 5
    // 3 + {1 2 4 } , k = 5
    // 3 + 1 { 2 4 }
    // 3 + 2 { 1 4}
    // 3 + 4 { 1 2}
    // 5/2 = 2
    // 3 4 + {1 2 }
    // k = 1
    // 3 4 1 2
}
