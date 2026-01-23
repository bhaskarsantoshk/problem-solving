package takeUForward.recursion.revision4;

import java.util.ArrayList;
import java.util.List;

public class P19GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, 0, "", n, result );
        return result;
    }

    private void generate(int i, int open, int closed, String s, int n, List<String> result) {
        if ( open > n) return;
        if ( open < closed) return;
        if ( open + closed == 2 * n && open == closed){
            result.add(s);
        }
        generate(i+1, open+1, closed, s+"(", n, result);
        generate(i+1, open, closed+1, s+")", n, result);
    }
}
