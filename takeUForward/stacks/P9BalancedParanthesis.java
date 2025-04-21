package takeUForward.stacks;

import java.util.Stack;

public class P9BalancedParanthesis {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for ( char c: str.toCharArray()){
            if ( c == '(' ) stack.push(')');
            else if ( c == '[') stack.push(']');
            else if ( c == '{') stack.push('}');
            else if ( stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
