package takeUForward.google;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String s, int target) {
        List<String> res = new ArrayList<>();
        if ( s== null || s.length() == 0) return res;
        backtrack(s, target, 0, 0, 0, "", res);
        return res;
    }

    private void backtrack(String s, int target, int index, long curVal, long lastFactor, String expression, List<String> res) {
        if ( index == s.length()) {
            if ( curVal == target) {
                res.add(expression);
            }
            return;
        }
        for ( int i=index; i<s.length(); i++){
            if ( i > index && s.charAt(index) == '0') break; // 01, 02 are not valid numbers
            long val = Long.parseLong(s.substring(index, i+1));
            if ( index == 0){
                backtrack(s, target, i+1, val, val, expression+ val, res);
            } else {
                backtrack(s, target, i+1, curVal+val, val, expression+"+"+val, res);
                backtrack(s, target, i+1, curVal-val, -val, expression+"-"+val, res);
                backtrack(s, target, i + 1,
                        curVal - lastFactor + lastFactor * val,
                        lastFactor * val,
                        expression + "*" + val, res);
            }
        }
    }
}
