package company.microsoft;

import java.util.Arrays;
import java.util.Stack;

public class P1190ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        if ( s == null || s.isEmpty()) return s;
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for ( char c: s.toCharArray()){
            if ( c == '(') {
                stack.push(c);
            } else if ( c == ')'){
                StringBuilder temp = new StringBuilder();
                while ( stack.peek() != '('){
                    temp.append(stack.pop());
                }
                stack.pop();
                for ( char ch: temp.toString().toCharArray()){
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while ( !stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    // "(ed(et(oc))el)"
    // stack -> ( e d ( e t ( o c
    // when we encounter ")" -> build a  temp string builder -> keep popping out strings until you see "(" -> "co"
    // the one inside the bracket needs reversing but since we popped it out of stack , it comes in reverse order
    // push it back to stack , stack -> ( e d ( e t c o
    // repeat the above for next )
    // temp -> o c t e
    // stack -> ( e d o c t e e l
    // temp -> leetcode
    // stack -> leetcode
    // res -> when popped out -> edocteel
    // o/p rev(res) -> leetcode

    // O(N)
    public String reverseParenthesesOptimized(String s) {
        if ( s == null || s.isEmpty()) return s;
        int [] oppositeIndexOfParentheses = new int[s.length()];
        Arrays.fill(oppositeIndexOfParentheses, -1);
        Stack<Integer> openParentheses = new Stack<>();
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( c == '(') {
                openParentheses.push(i);
            } else if ( c == ')'){
                int index = openParentheses.pop();
                oppositeIndexOfParentheses[i] = index;
                oppositeIndexOfParentheses[index] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int dir = 1; // forward 1, backword -1
        for ( int i=0; i<s.length(); i+=dir){
            char c = s.charAt(i);
            if ( c == '(' || c == ')'){
                i = oppositeIndexOfParentheses[i];
                dir *= -1;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
