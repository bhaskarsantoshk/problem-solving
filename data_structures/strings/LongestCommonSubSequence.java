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

        System.out.println(getLCSubsequenceDP("abdca", "cbda"));
        System.out.println(getLCSubsequenceDP("passport", "ppsspt"));
    }

    public static int getLCSubsequenceDP(String s, String t){
        Integer[][] memo = new Integer[s.length()+1][s.length()+1];
        return getLCSubsequenceDP(memo, s, t, 0, 0);
    }

    private static int getLCSubsequenceDP(Integer[][] memo, String s, String t, int sIndex, int tIndex) {
        if ( sIndex == s.length() || tIndex == t.length() ){
            return 0;
        }
        if ( memo[sIndex][tIndex] == null ){
            if ( s.charAt(sIndex) == t.charAt(tIndex)){
                memo[sIndex][tIndex] = 1 + getLCSubsequenceDP(memo, s, t, sIndex+1, tIndex+1);
            }
            else{
                int c1 = getLCSubsequenceDP(memo, s, t, sIndex+1, tIndex);
                int c2 = getLCSubsequenceDP(memo, s, t, sIndex, tIndex+1);
                memo[sIndex][tIndex] = Math.max(c1, c2);
            }
        }
        return memo[sIndex][tIndex];
    }
}
