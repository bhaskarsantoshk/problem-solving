package company.microsoft;

import java.util.Arrays;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    //"(ed(et(oc))el)"
    // co
    // octe
    // leetcode


    //"(ed(et(oc))el)"
    // leetcode

    public String reverseParentheses(String s) {
        if ( s == null || s.isEmpty() ) return s;
        int [] oppositeIdx = new int[s.length()];
        Stack<Integer> openIdx = new Stack<>();
        Arrays.fill(oppositeIdx, -1);
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( c == '(') openIdx.push(i);
            else if ( c == ')'){
                int idx = openIdx.pop();
                oppositeIdx[i] = idx;
                oppositeIdx[idx] = i;
            }
        }
        int dir = 1 ;// backward -1
        StringBuilder sb = new StringBuilder();
        for ( int i=0; i<s.length(); i+=dir){
            char c = s.charAt(i);
            if ( c == '(' || c == ')'){
                i = oppositeIdx[i];
                dir *= -1;
            } else {
               sb.append(c);
            }
        }
        return sb.toString();
    }
}
