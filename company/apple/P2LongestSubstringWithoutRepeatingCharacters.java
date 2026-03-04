package company.apple;

import java.util.HashSet;
import java.util.Set;

public class P2LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringBruteForce(String s) {
        int len = 0;
        for ( int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            for ( int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if ( set.contains(c)) break;
                else {
                    set.add(c);
                }
                len = Math.max(len, set.size());
            }
        }
        return len;
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        for ( int right =0; right <s.length(); right++){
            char c = s.charAt(right);
            while ( set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
