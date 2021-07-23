package data_structures.stacks_and_queues;
import java.util.Stack;

public class Parentheses {
    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        for ( char c: exp.toCharArray() ){
            if ( c == '}' || c == ')' || c == ']'){
                if ( stack.isEmpty() ) return false;
                if ( ( c == '}' && stack.pop() != '{') ||
                        ( c == ']' && stack.pop() != '[') ||
                        ( c == ')' && stack.pop() != '(') ) {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        if ( !stack.isEmpty() ) return false;
        return true;
    }
}
