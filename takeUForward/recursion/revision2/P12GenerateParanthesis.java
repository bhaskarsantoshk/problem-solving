package takeUForward.recursion.revision2;

import java.util.ArrayList;
import java.util.List;

public class P12GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, 0, 0, n, new StringBuilder());
        return res;
    }

    private void generateParenthesis(List<String> res, int open, int closed, int n, StringBuilder sb) {
        if ( open + closed == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if ( open < n){
            sb.append("(");
            generateParenthesis(res, open+1, closed, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if ( closed < open){
            sb.append(")");
            generateParenthesis(res, open, closed+1,n, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
