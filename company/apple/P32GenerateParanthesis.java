package company.apple;

import java.util.ArrayList;
import java.util.List;

public class P32GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> parantehsis = new ArrayList<>();
        f (0, 0, "", parantehsis, n);
        return parantehsis;
    }

    private void f( int open, int closed, String prefix, List<String> parantehsis, int n) {
        if ( open > n) return;
        if ( closed > open) return;
        if ( open + closed == 2* n && open == closed){
            parantehsis.add(prefix);
            return;
        }
        f(open+1, closed, prefix+"(", parantehsis, n);
        f(open, closed+1, prefix+")", parantehsis, n);
    }
}
