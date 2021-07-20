package data_structures.strings;

public class LongestCommonSubstring {
    public int getLongestCommonSubstringLen(String s , String t){
        return getLongestCommonSubstringLen(s,t,0,0,0);
    }

    private int getLongestCommonSubstringLen(String s, String t, int sIndex, int tIndex, int len) {
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
}
