package data_structures.strings;

public class LongestCommonSubSequence {
    public static int getLCSubsequence(String s, String t){
        return getLCSubsequence(s,t,0,0);
    }

    private static int getLCSubsequence(String s, String t, int sIndex, int tIndex) {
        if (sIndex == s.length() || tIndex == t.length()){
            return 0;
        }
        if ( s.charAt(sIndex) == t.charAt(tIndex)){
            return 1+ getLCSubsequence(s,t,sIndex+1, tIndex+1);
        }
        int c1 = getLCSubsequence(s, t, sIndex+1, tIndex);
        int c2 = getLCSubsequence(s, t, sIndex, tIndex+1);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        System.out.println(getLCSubsequence("abdca", "cbda"));
        System.out.println(getLCSubsequence("passport", "ppsspt"));
    }
}
