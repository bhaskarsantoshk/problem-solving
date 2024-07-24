package company.google.arrays;

import java.util.HashSet;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int start = 0; // take end as well if we need to return the string
        Set<Character> set = new HashSet<>();
        int max = 0;
        for ( char c: s.toCharArray()){ // take index if we need the string
            while ( set.contains(c)){
                set.remove(s.charAt(start++));
            }
            set.add(c);
            max = Math.max( max, set.size()); // update end
        }
        return max; // return substring(start, end)
    }
}
