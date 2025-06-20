package takeUForward.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P8LongestSubstringWithAtMostKDistinctCharacters {
    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for ( int i=0; i<n; i++){
            Set<Character> set = new HashSet<>();
            for( int j=i; j<n; j++){
                char c = s.charAt(j);
                if (!set.contains(c)) set.add(c);
                if ( set.size() <= k) maxLen = Math.max(maxLen, j-i+1);
                else break;
            }
        }
        return maxLen;
    }

    public int kDistinctCharBetter(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        int left = 0, right=0;
        Map<Character, Integer> hash = new HashMap<>();
        while ( right < n){
            char c = s.charAt(right);
            hash.put(c, hash.getOrDefault(c,0)+1);
            while ( hash.size() > k){
                char ch = s.charAt(left);
                hash.put(ch, hash.getOrDefault(ch,0)-1);
                if ( hash.get(ch) == 0) hash.remove(ch);
                left++;
            }
            if ( hash.size() <= k) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public int kDistinctCharOptimal(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        int left = 0, right=0;
        Map<Character, Integer> hash = new HashMap<>();
        while ( right < n){
            char c = s.charAt(right);
            hash.put(c, hash.getOrDefault(c,0)+1);
            while ( hash.size() > k){
                char ch = s.charAt(left);
                hash.put(ch, hash.getOrDefault(ch,0)-1);
                if ( hash.get(ch) == 0) hash.remove(ch);
                left++;
            }
            if ( hash.size() <= k) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
