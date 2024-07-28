package company.google.recursion;

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String prefix, int open, int closed, int max) {
        if ( open + closed == 2* max){
            res.add(prefix);
        }
        if ( open < max ){
            backtrack(res, prefix+"(", open+1, closed, max);
        }
        if ( closed < open){
            backtrack(res, prefix+")", open, closed, max);
        }
    }
}
