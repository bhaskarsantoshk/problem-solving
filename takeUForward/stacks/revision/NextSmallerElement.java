package takeUForward.stacks.revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        ArrayList<Integer> res = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();
        for ( int i=n-1; i>=0; i--){
            while ( !stack.isEmpty() && arr.get(stack.peek()) >= arr.get(i) ) stack.pop();
            if ( stack.isEmpty() ) res.add( -1);
            else res.add( arr.get(stack.peek()));
            stack.push(i);
        }
        Collections.reverse(res);

        return res;
    }
}
