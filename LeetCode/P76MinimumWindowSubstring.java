package LeetCode;

import java.util.HashMap;

public class P76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if ( s == null || s.length() < t.length() || s.length() == 0 ){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for ( char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int left = 0;
        int minLeft = 0;
        int minLength = s.length()+1;
        int count = 0;
        for ( int right =0 ; right < s.length(); right++ ){
            char c = s.charAt(right);
            if ( map.containsKey(c )){
                map.put(c, map.get(c)-1);
                if ( map.get(c) >= 0 ){
                    count++;
                }
            }
            while ( count == t.length() ){
                if (right - left + 1  < minLength ){
                    minLeft = left;
                    minLength = right - left + 1;
                }
                char ch = s.charAt(left);
                if ( map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1);
                    if ( map.get(ch) > 0 ){
                        count--;
                    }
                }
                left++;
            }
        }
        return minLength == s.length()+1 ? "": s.substring(minLeft, minLeft+minLength);
    }
}
