package takeUForward.slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P9LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for ( int i=0; i<n; i++){
            int maxFrequency = 0;
            int []hash = new int[26];
            for( int j=i; j<n; j++){
                char c = s.charAt(j);
                hash[c-'A']++;
                maxFrequency = Math.max(maxFrequency, hash[c-'A']);
                int len = j-i+1;
                if ( len - maxFrequency <= k){
                    maxLen = Math.max(maxLen, len);
                } else{
                    break;
                }
            }
        }
        return maxLen;
    }

    public int characterReplacementBetter(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> hash = new HashMap<>();
        int left = 0, right = 0, maxFreq = 0;
        while ( right < n){
            char c = s.charAt(right);
            hash.put(c, hash.getOrDefault(c,0)+1);
            maxFreq = Math.max( maxFreq, hash.getOrDefault(c,0));
            while ( (right-left+1) - maxFreq > k){
                char ch = s.charAt(left);
                hash.put(ch, hash.get(ch)-1);
                maxFreq = Collections.max(hash.values());
                if (hash.get(ch) == 0) hash.remove(ch);
                left++;
            }
            if ( (right-left+1) - maxFreq <= k) maxLen = Math.max((right-left+1), maxLen);
            right++;
        }
        return maxLen;
    }
}
