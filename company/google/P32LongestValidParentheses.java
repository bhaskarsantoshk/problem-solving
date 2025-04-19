package company.google;

import java.util.Stack;

public class P32LongestValidParentheses {
    public int longestValidParentheses(String s) {

        int maxLen = 0;
        int lastInvalid = -1;
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( c == '('){
                stack.push(i);
            } else {
                if ( stack.isEmpty()){
                    lastInvalid = i;
                } else {
                    stack.pop();
                    if ( stack.isEmpty()){
                        maxLen = Math.max(maxLen, i-lastInvalid);
                    } else {
                        maxLen = Math.max(maxLen, i-stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }

}
