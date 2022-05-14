package express_prep.amzn.top_voted;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        int index = 0;
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            while ( set.contains(c)){
                set.remove(s.charAt(index));
            }
            set.add(c);
            len = Math.max( len, set.size());
        }
        return len;
    }
}
