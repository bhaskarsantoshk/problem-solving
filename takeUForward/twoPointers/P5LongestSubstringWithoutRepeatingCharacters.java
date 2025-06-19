package takeUForward.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class P5LongestSubstringWithoutRepeatingCharacters {
    public int longestNonRepeatingSubstringBruteForce(String s) {
        int n = s.length();
        int maxLen = 0;
        for ( int i=0; i<n; i++){
            int[] hash = new int[256];
            for ( int j=i; j<n; j++){
                if ( hash[s.charAt(j)] == 0) {
                    maxLen = Math.max(maxLen, j-i+1);
                    hash[s.charAt(j)] =1;
                } else {
                  break;
                }
            }
        }
        return maxLen;
    }

    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> hash = new HashMap<>();
        int left = 0, right = 0;
        while ( right < n){
            char c = s.charAt(right);
            if ( hash.containsKey(c) ){
                hash.put(c, right);
            } else {
                left = hash.getOrDefault(c, 0)+1;
                hash.put(c, right);
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
