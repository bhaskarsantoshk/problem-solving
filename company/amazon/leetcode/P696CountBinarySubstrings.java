package company.amazon.leetcode;

public class P696CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int cur =0, prev = 0, res = 0;
        for ( int i=1; i<s.length(); i++){
            if ( s.charAt(i-1) == s.charAt(i)) cur++;
            else {
                res+= Math.min(prev, cur);
                prev= cur;
                cur = 1;
            }
        }
        return res+ Math.min(prev, cur);
    }
}
