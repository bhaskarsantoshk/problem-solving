package company.google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;
        for ( int i=0; i<s.length(); i++){
            while ( set.contains(s.charAt(i))){
                set.remove(s.charAt(start++));
            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
