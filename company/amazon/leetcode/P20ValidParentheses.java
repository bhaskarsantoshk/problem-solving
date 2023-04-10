package company.amazon.leetcode;

import java.util.Stack;

public class P20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char c: s.toCharArray()){
            if ( c == '(' || c == '{' || c == '[' ){
                stack.push(c);
            } else {
                if ( stack.isEmpty() ) return false;
                if ( c == ')' ) {
                    if ( stack.peek() != '(') return false;
                }
                if ( c == '}' ) {
                    if ( stack.peek() != '{') return false;
                }
                if ( c == ']' ) {
                    if ( stack.peek() != '[') return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
