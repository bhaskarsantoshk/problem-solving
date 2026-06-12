package company.microsoft.two_pointers;

import java.util.HashSet;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for ( int right=0; right <s.length(); right++){
            char c = s.charAt(right);
            while ( set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
