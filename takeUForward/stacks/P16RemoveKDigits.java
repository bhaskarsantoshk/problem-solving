package takeUForward.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class P16RemoveKDigits {
    public String removeKdigits(String nums, int k) {
        Stack<Character> stack = new Stack<>();
        for ( int i=0; i<nums.length(); i++){
            while ( !stack.isEmpty() && k>0 && stack.peek() > nums.charAt(i) ) {
                stack.pop();
                k--;
            }
            stack.push(nums.charAt(i));
        }
        while ( !stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        if ( stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while ( !stack.isEmpty()) sb.append(stack.pop()+"");
        sb.reverse();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while ( index < sb.length()){
            if ( sb.charAt(index) == '0'){
                index++;
            } else {
                break;
            }
        }
        while ( index < sb.length()){
            res.append(sb.charAt(index++));
        }
        if (res.isEmpty()) return "0";
        return res.toString();
    }
}
