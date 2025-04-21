package takeUForward.stacks;

import java.util.Stack;

public class P11NextGreaterElement {
    public int[] nextLargerElement(int[] arr) {
        // In order to identify next greater element in O(N), it's better to come from right side
        // and each time we need to keep track of next greater
        // for that anything below current element need not be in the data structure
        // Let's use Stack - top should give us next greater and easy to pop if the top is less than current element
        int[] nge = new int[arr.length];
        int n = nge.length;
        Stack<Integer> stack = new Stack<>();
        for ( int i=n-1; i>=0; i--){
            while ( !stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(arr[i]);
        }
        return nge;
    }
}
