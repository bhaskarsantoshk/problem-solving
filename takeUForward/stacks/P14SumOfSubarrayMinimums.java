package takeUForward.stacks;

import java.util.Stack;

public class P14SumOfSubarrayMinimums {
    public int sumSubarrayMinsBruteForce(int[] arr) {
        int sum = 0;
        int mod = (int)1e9+7;
        int n = arr.length;
        for ( int i=0; i<n; i++){
            int min = arr[i];
            for ( int j=0; j<n; j++){
                min = Math.min(min, arr[i]);
                sum = (sum+min)%mod;
            }
        }
        return sum;
    }

    public int sumSubarrayMins(int[] arr) {
        int total = 0;
        int[] nse = findNSEIndex(arr);
        int[] pse = findPreviousSmallerOrEqualElementIndex(arr);
        int n = arr.length;
        int mod = (int)1e9+7;
        for ( int i=0; i<n; i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            total = (int) ((total + ((long) left * right * arr[i] )%mod)%mod);
        }
        return total;
    }

    private int[] findPreviousSmallerOrEqualElementIndex(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int [] pse = new int[n];

        for ( int i=0; i<n; i++){
            while ( !stack.isEmpty() && arr[stack.peek()] > arr[i] ){
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        return pse;
    }

    private int[] findNSEIndex(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int [] nse = new int[n];

        for ( int i=n-1; i>=0; i--){
            while ( !stack.isEmpty() && arr[stack.peek()] >= arr[i] ){
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        return nse;
    }
}
