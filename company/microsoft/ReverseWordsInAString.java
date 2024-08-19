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

    public String reverseWordsOptimized(String s) {
        if ( s == null || s.isEmpty()) return s;
        char [] str = s.toCharArray();
        int n = str.length;
        reverse ( str, 0, n-1); // reverse whole string
        reverseWords(str, n);
        return cleanUpSpaces(str, n);
    }

    private String cleanUpSpaces(char[] str, int n) {
        int index = 0, i=0;
        while ( i < n){
            while ( i < n && str[i] == ' ') i++;
            while ( i < n && str[i] != ' ') str[index++] = str[i++];
            while ( i < n && str[i] == ' ') i++;
            if ( i < n ) str[index++] = ' ';
        }
        return new String(str).substring(0, index);
    }

    private void reverseWords(char[] str, int n) {
        int i=0, j=0;
        while ( i < n){
            while ( i < j || i < n && str[i] == ' ' ) i++;
            while ( j < i || j < n && str[j] != ' ') j++;
            reverse(str, i, j-1);
        }
    }

    private void reverse(char[] str, int start, int end) {
        while ( start < end){
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}
