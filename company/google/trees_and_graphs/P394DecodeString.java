package company.google.trees_and_graphs;

import java.util.Stack;

public class P394DecodeString {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int currentNumber = 0;
        String currentString = "";
        for ( char c: s.toCharArray()){
            if ( Character.isDigit(c) ){
                currentNumber = currentNumber * 10 + (c-'0');
            } else if ( c == '['){
                strStack.push(currentString);
                numStack.push(currentNumber);
                currentString="";
                currentNumber=0;
            } else if ( c == ']'){
                String tempString = strStack.pop();
                StringBuilder sb = new StringBuilder(tempString);
                int repeatNum = numStack.pop();
                for ( int i=0; i<repeatNum; i++){
                    sb.append(currentString);
                }
                currentString = sb.toString();
            } else {
                currentString+= c;
            }
        }
        return currentString;
    }


    public String decodeStringOptimized(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int currentNumber = 0;
        for ( char c: s.toCharArray()){
            if ( Character.isDigit(c) ){
                currentNumber = currentNumber * 10 + (c-'0');
            } else if ( c == '['){
                strStack.push(cur);
                numStack.push(currentNumber);
                cur = new StringBuilder();
                currentNumber=0;
            } else if ( c == ']'){
                StringBuilder temp = cur;
                int repeatNum = numStack.pop();
                cur = strStack.pop();
                for ( int i=0; i<repeatNum; i++){
                    cur.append(temp);
                }
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}

/*
O(n+k⋅m) where: 𝑛 n is the length of the input string,𝑘
k is the maximum repeat count in the string, 𝑚 m is the length of the substring being repeated.
 */
