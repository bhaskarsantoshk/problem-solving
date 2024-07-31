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
}

/*
O(n+k⋅m) where: 𝑛 n is the length of the input string,𝑘
k is the maximum repeat count in the string, 𝑚 m is the length of the substring being repeated.
 */
