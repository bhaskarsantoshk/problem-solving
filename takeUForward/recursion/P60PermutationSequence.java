package takeuForward.recursion;

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
}
