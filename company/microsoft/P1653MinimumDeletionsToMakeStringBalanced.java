package company.microsoft;

import java.util.Stack;

public class P1653MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for ( char c: s.toCharArray()){
            if ( !stack.isEmpty() && stack.peek() == 'b' && c == 'a'){
                count++;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return count;
    }
}
