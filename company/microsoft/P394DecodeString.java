package company.microsoft;

import java.util.Stack;

public class P394DecodeString {

    /*
    Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
     */
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;
        for ( char c: s.toCharArray()){
            if ( Character.isDigit(c)) num = num * 10 + (c-'0');
            else if ( c == '[') {
                counts.push(num);
                strings.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if ( c == ']'){
                int repeat = counts.pop();
                StringBuilder prev = strings.pop();
                for ( int i=0; i<repeat; i++) prev.append(cur);
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
