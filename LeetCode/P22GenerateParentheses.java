package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    private void backtrack(List<String> list, String s, int open, int closed, int max) {
        if(open+ closed == 2 * max){
            list.add(s);
        }
        if(open < max){
            backtrack(list, s+"(", open+1, closed, max);
        }
        if(closed < open){
            backtrack(list, s+")", open, closed+1, max);
        }
    }
}
