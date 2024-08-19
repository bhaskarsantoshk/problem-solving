package company.microsoft;

import java.util.Stack;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( c == ' '){
                if ( !sb.isEmpty()) stack.push(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if ( !sb.isEmpty()) stack.push(sb.toString());
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop()).append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
