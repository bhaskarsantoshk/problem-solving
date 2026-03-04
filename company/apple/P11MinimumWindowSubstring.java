package company.apple;

import java.util.HashMap;
import java.util.Map;

public class P11MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if ( s== null || s.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for ( char c: t.toCharArray()) need.put(c, need.getOrDefault(c,0)+1);


        int left = 0;
        int stratIndex = -1;
        int minLen = s.length()+1;
        int matched = 0;

        for ( int right = 0; right <s.length(); right++){
            char c = s.charAt(right);
            if ( need.containsKey(c)){
                if ( need.get(c) > 0) matched++;
                need.put(c, need.get(c)-1);
            }

            while ( matched == t.length()){
                if ( minLen > (right-left+1)){
                    stratIndex = left;
                    minLen = (right-left+1);
                }

                char leftChar = s.charAt(left);
                if ( need.containsKey(leftChar)){
                    need.put(leftChar, need.get(leftChar)+1);
                    if ( need.get(leftChar) > 0) matched--;
                }
                left++;
            }
        }

        return stratIndex >=0 ? s.substring(stratIndex, stratIndex+minLen) : "";

    }
}
