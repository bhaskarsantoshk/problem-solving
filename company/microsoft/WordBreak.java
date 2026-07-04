package company.microsoft;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return f(s, 0, set);
    }

    private boolean f(String s, int i, Set<String> set) {
        if ( i == s.length()) return true;
        for ( int j=i+1; j<=s.length(); j++){
            String sub = s.substring(i, j);
            if ( set.contains(sub) && f(s, j, set)) return true;
        }

        return false;
    }

    public boolean wordBreakMemoized(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()+1];
        return f(s, 0, set, memo);
    }

    private boolean f(String s, int i, Set<String> set, Boolean[] memo) {
        if ( i == s.length()) return true;
        if ( memo[i] != null) return memo[i];
        for ( int j=i+1; j<=s.length(); j++){
            String sub = s.substring(i, j);
            if ( set.contains(sub) && f(s, j, set, memo)) return memo[i]= true;
        }

        return memo[i]= false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n]= true;
        for ( int i=n-1; i>=0; i--){
            for ( int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i, j);
                if ( set.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
