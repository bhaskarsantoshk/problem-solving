package company.google.arrays;

import java.util.Stack;

public class P20ValidParentheses {
    public boolean isValidBruteForce(String s) {
       boolean changed;
       do {
           changed = false;
           if ( s.contains("()")) {
               s= s.replace("()", "");
               changed = true;
           }
           else if ( s.contains("[]")) {
               s= s.replace("[]", "");
               changed =true;
           }
           else if (s.contains("{}")){
               s = s.replace("{}", "");
               changed = true;
           }
       } while(changed);

       return s.isEmpty();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char c : s.toCharArray()){
            if ( c == '(') stack.push(')');
            else if ( c == '{') stack.push('}');
            else if ( c == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
