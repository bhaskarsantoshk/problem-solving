package company.google;

public class P5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if ( s== null || s.length() < 2) return s;
        int [] res = new int[2];
        for ( int i=0; i<s.length()-1; i++){
            expandPalindrome(s, i, i, res);
            expandPalindrome(s, i, i+1, res);
        }
        return s.substring(res[0], res[0]+res[1]);
    }

    private void expandPalindrome(String s, int left, int right, int[] res) {
        while ( left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if ( res[1] < right-left-1){
            res[1] = right-left-1;
            res[0] = left+1;
        }
    }
}
