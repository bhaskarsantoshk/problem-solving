package company.apple;
import java.util.Arrays;
import java.util.List;

public class P51WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return f(s, 0, wordDict);

    }

    private boolean f(String s, int start, List<String> wordDict) {
        if ( start >= s.length() ) return true;

        for( String word: wordDict){
            int len = word.length();
            if ( start+len <= s.length() && s.substring(start, start+len).equals(word)){
                if (f(s, start+len, wordDict)) return true;
            }
        }
        return false;
    }



    public boolean wordBreakMemo(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return f(s, 0, wordDict, dp);

    }

    private boolean f(String s, int start, List<String> wordDict, Boolean[] dp) {
        if ( start >= s.length() ) return true;
        if ( dp[start] != null) return dp[start];

        for( String word: wordDict){
            int len = word.length();
            if ( start+len <= s.length() && s.substring(start, start+len).equals(word)){
                if (f(s, start+len, wordDict, dp)) {
                    dp[start] = true;
                    return true;
                }
            }
        }
        return dp[start]= false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()]= true;
        for ( int start=s.length(); start >=0 ; start--){
            for( String word: wordDict){
                int len = word.length();
                if ( start+len <= s.length() && s.substring(start, start+len).equals(word)){
                    if (dp[start+len]) {
                        dp[start] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}


// applepenapple

// apple pen


