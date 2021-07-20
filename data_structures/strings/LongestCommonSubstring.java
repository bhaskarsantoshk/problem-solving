package data_structures.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstring {
    public static int getLongestCommonSubstringLen(String s , String t){
        return getLongestCommonSubstringLen(s,t,0,0,0);
    }

    private static int getLongestCommonSubstringLen(String s, String t, int sIndex, int tIndex, int len) {
        if ( sIndex == s.length() || tIndex == t.length() ){
            return len;
        }
        if ( s.charAt(sIndex) == t.charAt(tIndex)){
            len = getLongestCommonSubstringLen(s,t, sIndex+1, tIndex+1, len+1);
        }
        int c1 = getLongestCommonSubstringLen(s, t, sIndex+1, tIndex, 0);
        int c2 = getLongestCommonSubstringLen(s, t, sIndex, tIndex+1, 0);
        return Math.max(len, Math.max(c1,c2));
    }

    public static void main(String[] args) {
        System.out.println(getLongestCommonSubstringLen("batman", "catwoman"));
        System.out.println(getLongestCommonSubstringLen("brucewayne", "alfredpennyworth"));
        System.out.println(getLCSubstringDP("batman", "catwoman"));
        System.out.println(getLCSubstringDP("brucewayne", "alfredpennyworth"));
    }

    public static int getLCSubstringDP(String s, String t){
        Map<String, Integer> memo = new HashMap<>();
        return getLCSubstringDP(memo, s, t, 0, 0, 0);
    }

    private static int getLCSubstringDP(Map<String, Integer> memo, String s, String t, int sIndex, int tIndex, int len) {
        if ( sIndex == s.length() || tIndex == t.length() ){
            return len;
        }
        String key = sIndex+"|"+tIndex+"|"+len;
        if ( !memo.containsKey(key)){
            int len1 = len;
            if ( s.charAt(sIndex) == t.charAt(tIndex) ){
                len1 = getLCSubstringDP(memo, s, t, sIndex+1, tIndex+1, len+1);
            }
            int len2 = getLCSubstringDP(memo, s, t, sIndex+1, tIndex, 0);
            int len3 = getLCSubstringDP(memo, s, t, sIndex, tIndex+1, 0);
            memo.put(key, Math.max(len1, Math.max(len2, len3 )));
        }
        return memo.get(key);
    }
}
