package data_structures.strings;

public class LongestPalindromicSubSequence {
    public static int longestPalindromicSubsequenceRecursive ( String s){
        return longestPalindromicSubsequenceRecursive(s, 0, s.length()-1);
    }

    private static int longestPalindromicSubsequenceRecursive(String s, int start, int end) {
        if ( start > end) return 0;
        if ( start == end ) return 1;
        if ( s.charAt(start) == s.charAt(end) ){
            return 2 + longestPalindromicSubsequenceRecursive(s, start+1, end-1);
        }
        int c1 = longestPalindromicSubsequenceRecursive(s, start+1, end);
        int c2 = longestPalindromicSubsequenceRecursive(s, start, end-1);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequenceRecursive("abdbca"));
        System.out.println(longestPalindromicSubsequenceRecursive("cddpd"));
        System.out.println(longestPalindromicSubsequenceRecursive("pqr"));
        System.out.println(longestPalindromicSubsequenceDP("abdbca"));
        System.out.println(longestPalindromicSubsequenceDP("cddpd"));
        System.out.println(longestPalindromicSubsequenceDP("pqr"));
    }

    public static int longestPalindromicSubsequenceDP ( String s){
        Integer[][] memo = new Integer[s.length()][s.length()];
        return longestPalindromicSubsequenceDP(s, memo, 0, s.length()-1);
    }

    private static int longestPalindromicSubsequenceDP(String s, Integer[][] memo, int start, int end) {
        if ( start > end) return 0;
        if ( start == end ) return 1;
        if ( memo[start][end] == null ){
            if ( s.charAt(start) == s.charAt(end)){
                memo[start][end] = 2 + longestPalindromicSubsequenceDP(s, memo, start+1, end-1);
            }
            else{
                int c1 = longestPalindromicSubsequenceDP(s, memo, start+1, end);
                int c2 = longestPalindromicSubsequenceDP(s, memo, start, end-1);
                memo[start][end] = Math.max(c1, c2);
            }
        }
        return memo[start][end];
    }
}
