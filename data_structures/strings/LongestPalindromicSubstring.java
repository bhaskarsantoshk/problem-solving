package data_structures.strings;

public class LongestPalindromicSubstring {
    public int findLPSLength(String st) {
        return findLPSLengthRec(st, 0, st.length() - 1);
    }

    private int findLPSLengthRec(String s, int start, int end) {
        if ( start > end ) return 0;
        if ( start == end ) return 1;
        if ( s.charAt(start) == s.charAt(end)){
            int remainingLength = end-start+1;
            if ( remainingLength == findLPSLengthRec(s, start+1, end-1)){
                return 2+ remainingLength;
            }
        }
        int c1 = findLPSLengthRec(s, start+1, end);
        int c2 = findLPSLengthRec(s, start, end-1);
        return Math.max(c1,c2);
    }

    public int findLPSMemo( String s){
        Integer[][] memo = new Integer[s.length()+1][s.length()+1];
        return findLPSMemo(memo, s, 0, s.length()-1);
    }

    private int findLPSMemo(Integer[][] memo, String s, int start, int end) {
        if ( start > end) return 0;
        if ( start == end) return 1;
        if (memo[start][end] == null ){
            if ( s.charAt(start) == s.charAt(end)){
                int remLen = end-start+1;
                if ( remLen == findLPSMemo(memo, s, start+1, end-1)){
                    memo[start][end] = remLen+2;
                    return memo[start][end];
                }
            }
            int c1 = findLPSMemo(memo, s, start+1, end);
            int c2 = findLPSMemo(memo, s, start, end-1);
            memo[start][end] = Math.max(c1, c2);
        }
        return memo[start][end];
    }
}
