package express_prep.amzn.top_voted;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String prefix, int open, int closed, int max){
        if ( open + closed == 2 * max ){
            result.add(prefix);
        }
        if ( open < max ){
            backtrack(result, prefix+"(", open+1, closed, max);
        }
        if ( closed < open ){
            backtrack(result, prefix+")", open, closed+1, max);
        }
    }
}
