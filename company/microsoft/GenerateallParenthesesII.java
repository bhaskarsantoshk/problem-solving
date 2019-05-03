package company.microsoft;

import java.util.ArrayList;

public class GenerateallParenthesesII {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        backtrack(result, "",0, 0, n);
        return result;
    }

    private void backtrack(ArrayList<String> result, String s, int open, int close, int max) {
        if(s.length()==2*max){
            result.add(s);
            return;
        }
        if(open<max){
            backtrack(result, s+"(", open+1, close, max);
        }
        if(close < open){
            backtrack(result,s+")", open, close+1, max);
        }
    }
}
