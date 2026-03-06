package company.apple;

public class P47LongestPalindromicSubstring {
    int start = 0, length = 0;
    public String longestPalindrome(String s) {
        if ( s.length() < 2) return s;
        for ( int i=0; i<s.length()-1; i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, start+length+1);
    }

    private void expand(String s, int left, int right) {
        while ( left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = ( right-1) -(left+1)+1;
        if ( length < len ){
            length = len;
            start = left+1;
        }
    }
}
