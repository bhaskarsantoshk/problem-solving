package company.amazon.leetcode;

import java.util.Stack;

public class P20ValidParentheses {
    public boolean isValid(String s) {
        if ( s.isEmpty() ) return true;
        Stack<Character> stack = new Stack<>();
        for ( char c: s.toCharArray()){
            if ( c == '('){
                stack.push(')');
            } else if (c == '{'){
                stack.push('}');
            } else if ( c == '['){
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
