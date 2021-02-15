package leetcode_problems;

import java.util.HashSet;
import java.util.Set;

public class Problem_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int index = 0;
        for ( int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while ( set.contains(c)){
                set.remove(s.charAt(index++));
            }
            set.add(c);
            max = Math.max(set.size(), max);
        }
        return max;
    }
}
