package company.google.arrays;

import java.util.HashMap;
import java.util.Map;

public class P159LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinctBruteForce(String s) {
        int maxLen = 0;
        for ( int i=0; i<s.length(); i++){
            int[] hash = new int[256];
            int count = 0;
            for ( int j=i; j<s.length(); j++){
                if ( hash[s.charAt(j)] == 0 ) count++;
                if ( count <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
                hash[s.charAt(j)]++;
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        int left = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for ( int right = 0; right <s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            if ( map.get(c) == 1) count++;
            while ( count > 2){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar,0)-1);
                if ( map.get(leftChar) == 0) count--;
                left++;
            }
            maxLen = Math.max( maxLen, right-left+1);
        }
        return maxLen;
    }
}
