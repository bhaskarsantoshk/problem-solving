package LeetCode;

import java.util.Stack;

public class P1003CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        while ( S.contains("abc")){
            S.replace("abc", "");
        }
        return S.isEmpty();
    }

    public boolean isValid1(String S){
        Stack<Character> stack = new Stack<>();
        for ( char c: S.toCharArray()){
            if ( c== 'c'){
                while ( !stack.isEmpty() && stack.pop()!='b'){
                    return false;
                }
                while ( !stack.isEmpty() && stack.pop()!='a'){
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
