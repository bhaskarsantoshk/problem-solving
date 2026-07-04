package company.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return f(s, 0, set);
    }

    private List<String> f(String s, int i, Set<String> set) {
        List<String>  ans = new ArrayList<>();
        if ( i == s.length()) {
            ans.add("");
            return ans;
        }

        for ( int j=i=1; j<= s.length(); j++){
            String sub = s.substring(i, j);
            if ( set.contains(sub) ){
                List<String> suffixes = f(s, j, set);
                for ( String suffix: suffixes){
                    if ( suffix.isEmpty()) ans.add(sub);
                    else {
                        ans.add(sub +" "+ suffix);
                    }
                }
            }
        }

        return ans;
    }
}
