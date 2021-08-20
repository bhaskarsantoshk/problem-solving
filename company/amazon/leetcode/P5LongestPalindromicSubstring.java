package company.amazon.leetcode;

public class P5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int maxlen = Integer.MIN_VALUE;
        boolean dp[][] = new boolean[s.length()][s.length()];
        // Fill the diagonal -  length 1
        for ( int i=0; i<dp.length; i++){
            dp[i][i] = true;
        }
        // Length 2
        for ( int i=0; i<dp.length-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxlen = 2;
                start = i;
                end = i+1;

            }
        }

        for ( int k=3; k<=s.length(); k++){ // length of the substring
            for ( int i=0; i<s.length()-k+1; i++){
                int j = i+k-1;
                if ( dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if ( k > maxlen){
                        start = i;
                        end = j;
                        maxlen = k;
                    }
                }
            }
        }
        return s.substring(start, end+1);

    }
}
