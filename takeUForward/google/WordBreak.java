package takeUForward.google;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary= new HashSet<>(wordDict);
        return canBreak(0, s, dictionary);
    }

    private boolean canBreak(int start, String s, Set<String> dictionary) {
        if ( start == s.length()) return true;

        for ( int end = start+1; end < s.length(); end ++){
            String sub = s.substring(start, end);
            if ( dictionary.contains(sub) && canBreak(end, s, dictionary)) return true;
        }
        return false;
    }

    public boolean wordBreakMemoized(String s, List<String> wordDict) {
        Set<String> dictionary= new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return canBreak(0, s, dictionary, memo);
    }

    private boolean canBreak(int start, String s, Set<String> dictionary, Boolean[] memo) {
        if ( start == s.length()) return true;
        if ( memo[start] != null ) return memo[start];
        for ( int end = start+1; end <= s.length(); end ++){
            String sub = s.substring(start, end);
            if ( dictionary.contains(sub) && canBreak(end, s, dictionary, memo)) return memo[start]= true;
        }
        return memo[start]= false;
    }
}
