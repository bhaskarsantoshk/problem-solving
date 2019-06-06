package LeetCode;

public class P5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if ( s == null || s.length() == 0){
            return s;
        }
        int length = 0;
        int resultStart = 0, resultEnd = 0;

        for (int i =0; i< s.length(); i++){
            if ( isPalindrome(s, i-length-1, i)){
                resultStart = i - length - 1;
                resultEnd = i;
                length += 2;
            }
            else if ( isPalindrome(s, i-length, i)){
                resultStart = i-length;
                resultEnd = i;
                length += 1;
            }
        }

        return s.substring(resultStart, resultEnd+1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        if ( start < 0 ) return false;
        while ( start < end ){
            if ( s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }


}
