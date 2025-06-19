package takeUForward.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P7FruitIntoBaskets {
    public int totalFruits(int[] fruits) {
        // return longestSubArrayWithAtmostKDistinctNumbers(fruits, 2);
        return longestSubArrayWithAtmostKDistinctNumbersBetter(fruits, 2);
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

    private int longestSubArrayWithAtmostKDistinctNumbersBetter(int[] fruits, int k) {
        int n = fruits.length;
        int maxLen = 0;
        int left =0, right =0;
        Map<Integer, Integer> hash = new HashMap<>();
        while ( right < n){
            hash.put(fruits[right], hash.getOrDefault(fruits[right],0)+1);
            while ( hash.size() > k){
                hash.put(fruits[left], hash.getOrDefault(fruits[left],0)-1);
                if ( hash.get(fruits[left]) == 0) hash.remove(fruits[left]);
                left++;
            }
            if ( hash.size() <=k ) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    private int longestSubArrayWithAtmostKDistinctNumbersOptimal(int[] fruits, int k) {
        int n = fruits.length;
        int maxLen = 0;
        int left =0, right =0;
        Map<Integer, Integer> hash = new HashMap<>();
        while ( right < n){
            hash.put(fruits[right], hash.getOrDefault(fruits[right],0)+1);
            if ( hash.size() > k){
                hash.put(fruits[left], hash.getOrDefault(fruits[left],0)-1);
                if ( hash.get(fruits[left]) == 0) hash.remove(fruits[left]);
                left++;
            }
            if ( hash.size() <=k ) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
