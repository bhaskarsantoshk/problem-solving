package takeUForward.stacks;

import java.util.Stack;

public class P12NextGreaterElement2 {
    public int[] nextGreaterElementsCircularArrayBruteForce(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];

        for ( int i=0; i<n; i++){
            for ( int j=i+1; j<=i+n-1; i++){
                int index = j%n;
                if ( arr[index] > arr[i]){
                    nge[i] = arr[index];
                    break;
                }
            }
        }
        return nge;
    }

    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for ( int i=2*n-1; i>=0; i--){
            while ( !stack.isEmpty() && arr[i%n] >= stack.peek()){
                stack.pop();
            }
            if ( i < n){
                nge[i] = (stack.isEmpty()) ? -1: stack.peek();
            }
            stack.push(arr[i%n]);
        }
        return nge;
    }
}
