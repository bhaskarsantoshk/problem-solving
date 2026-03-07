package company.apple;

public class P48RegularExpressionMatching {
    public boolean iswildCardMatch(String s, String pattern) {
        return f(s,pattern, s.length()-1, pattern.length()-1);
    }

    private boolean f(String s, String pattern, int i, int j) {

        if ( i < 0 && j < 0) return true;
        if ( i < 0 && j >=0 ){
            for ( int index=0; index<=j; index++){
                if ( pattern.charAt(index) != '*') return false;
            }
            return true;
        }
        if ( i >=0 && j < 0) return false;
        if ( s.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?'){
            return f(s, pattern, i-1, j-1);
        }
        if ( pattern.charAt(j) == '*'){
            return f(s, pattern, i-1, j) || f(s, pattern, i, j-1);
        }
        return false;
    }

    public boolean iswildCardMatchMemo(String s, String pattern) {
        Boolean[][] dp = new Boolean[s.length()][pattern.length()];
        return f(s,pattern, s.length()-1, pattern.length()-1, dp);
    }

    private boolean f(String s, String pattern, int i, int j, Boolean[][] dp) {

        if ( i < 0 && j < 0) return true;
        if ( i < 0 && j >=0 ){
            for ( int index=0; index<=j; index++){
                if ( pattern.charAt(index) != '*') return false;
            }
            return true;
        }
        if ( i >=0 && j < 0) return false;
        if ( dp[i][j] != null) return dp[i][j];

        if ( s.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?'){
            return dp[i][j]= f(s, pattern, i-1, j-1, dp);
        }
        if ( pattern.charAt(j) == '*'){
            return dp[i][j]=f(s, pattern, i-1, j, dp) || f(s, pattern, i, j-1, dp);
        }
        return dp[i][j]=false;
    }

    public boolean isMatch(String s, String p) {
        return isRegexMatch(s, p, 0, 0);
    }

    private boolean isRegexMatch(String s, String p, int i, int j) {
        if ( j == p.length()) return i == s.length();

        boolean currentMatch = ( i < s.length() && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if ( j+1 < p.length() && p.charAt(j+1) == '*'){
            return isRegexMatch(s, p, i, j+2) || ( currentMatch && f(s,p, i+1, j));
        }
        return currentMatch && f(s, p, i+1, j+1);
    }


    public boolean isMatchMemo(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return isRegexMatch(s, p, 0, 0, dp);
    }

    private boolean isRegexMatch(String s, String p, int i, int j, Boolean[][] dp) {
        if ( j == p.length()) return i == s.length();
        if ( dp[i][j] != null) return dp[i][j];

        boolean currentMatch = ( i < s.length() && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if ( j+1 < p.length() && p.charAt(j+1) == '*'){
            return dp[i][j] = isRegexMatch(s, p, i, j+2, dp) || ( currentMatch && isRegexMatch(s,p, i+1, j, dp));
        }
        return dp[i][j] = currentMatch && f(s, p, i+1, j+1);
    }

    public boolean isMatchDP(String s, String p) {
        int n = s.length(), m= p.length();
        boolean[][] dp = new boolean[n+2][m+2];
        dp[n][m] = true;

        for(int i=n; i>=0; i--){
            for ( int j=m-1; j>=0; j--){
                boolean currentMatch = ( i < s.length() && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                if ( j+1 < p.length() && p.charAt(j+1) == '*'){
                     dp[i][j] = dp[i][j+2] || ( currentMatch && dp[i+1][j]);
                }
                else dp[i][j] = currentMatch && dp[i+1][j+1];
            }
        }
        return dp[0][0];
    }
}
