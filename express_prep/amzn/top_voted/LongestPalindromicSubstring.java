package express_prep.amzn.top_voted;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String max = "";
        for ( int i=0; i<s.length(); i++){
            String s1 = extend(s, i, i);
            String s2 = extend(s, i, i+1);
            if ( max.length() < s1.length() ){
                max = s1;
            }
            if ( max.length() < s2.length() ){
                max = s2;
            }
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        while ( i>= 0 && j<=s.length()-1){
            if ( s.charAt(i) != s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }

    public String longestPalindromeDP(String s){
        // https://www.youtube.com/watch?v=UflHuQj6MVA
        int start = 0, end = 0;
        int maxlen = Integer.MIN_VALUE;
        boolean[][] dp = new boolean[s.length()][s.length()];

        // len 1
        for ( int i=0; i<s.length(); i++){
            dp[i][i] = true;
        }

        // len 2
        for ( int i=0; i<s.length()-1; i++){
            if ( s.charAt(i) == s.charAt(i+1) ) dp[i][i+1]=true;
            start = i;
            end= i+1;
            maxlen = 2;
        }

        for ( int len=3; len<=s.length(); len++){
            for ( int i=0; i<s.length()-len+1; i++){
                int j= i+len-1;
                if ( dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if ( len > maxlen ){
                        start = i;
                        end = j;
                        maxlen = len;
                    }
                }

            }
        }
        return s.substring(start, end+1);
    }
}
