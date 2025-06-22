package takeUForward.strings;

public class P2MinimumNumberOfBracketReversalsToMakeAnExpressionBalanced {
    public int countRev(String s) {
        if ( s.length() %2 == 1) return -1;
        int open = 0, closed=0;
        for ( char c: s.toCharArray()){
            if ( c == '(') open++;
            else{
                if (open > 0) open--;
                else closed++;
            }
        }
        return open/2+ open%2 + closed/2 + closed%2;
    }
}
