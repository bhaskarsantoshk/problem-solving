package company.apple;

public class PLC97InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ( s1.length() + s2.length() != s3.length()) return false;
        return f(s1, s2, 0, 0, s3);
    }

    private boolean f(String s1, String s2, int i, int j, String s3) {
        int k = i+j;
        if ( k == s3.length()) return true;
        boolean take1=false, take2 = false;
        if ( i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            take1= f(s1, s2, i+1, j, s3);
        }
        if ( j < s2.length() && s3.charAt(k) == s2.charAt(j)){
            take2 = f(s1, s2, i, j+1, s3);
        }
        return take1 || take2;
    }

    public boolean isInterleaveMemo(String s1, String s2, String s3) {
        if ( s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return f(s1, s2, 0, 0, s3, dp);
    }

    private boolean f(String s1, String s2, int i, int j, String s3, Boolean[][] dp) {
        int k = i+j;
        if ( k == s3.length()) return true;
        if ( dp[i][j] != null) return dp[i][j];
        boolean take1=false, take2 = false;
        if ( i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            take1= f(s1, s2, i+1, j, s3);
        }
        if ( j < s2.length() && s3.charAt(k) == s2.charAt(j)){
            take2 = f(s1, s2, i, j+1, s3);
        }
        return dp[i][j]= take1 || take2;
    }

    public boolean isInterleaveDP(String s1, String s2, String s3) {
        if ( s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()] = true;

        for ( int i=s1.length(); i>=0; i--){
            for ( int j=s2.length(); j>=0; j--){
                int k = i+j;
                if ( i == s1.length() && j == s2.length()) continue;
                boolean take1=false, take2 = false;
                if ( i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
                    take1= dp[i+1][j];
                }
                if ( j < s2.length() && s3.charAt(k) == s2.charAt(j)){
                    take2 = dp[i][j+1];
                }
                dp[i][j]= take1 || take2;
            }
        }
        return dp[0][0];
    }
}
