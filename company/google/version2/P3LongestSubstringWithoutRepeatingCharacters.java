package company.google.version2;

import java.util.HashSet;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringBruteforce(String s) {
        int maxLen = 0;
        for ( int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            for ( int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if ( set.contains(c)){
                    break;
                }
                set.add(c);
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
