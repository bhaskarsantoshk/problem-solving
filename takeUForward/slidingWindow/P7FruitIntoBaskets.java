package takeUForward.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class P7FruitIntoBaskets {
    public int totalFruits(int[] fruits) {
        return longestSubArrayWithAtmostKDistinctNumbers(fruits, 2);
    }

    private int longestSubArrayWithAtmostKDistinctNumbers(int[] fruits, int k) {
        int n = fruits.length;
        int maxLen = 0;
        for ( int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            for ( int j=i; j<n; j++){
                set.add(fruits[j]);
                if ( set.size() <= k) maxLen = Math.max(maxLen, j-i+1);
                else break;
            }
        }
        return maxLen;
    }
}
