package striver_sde_sheet.stacks_and_queues;

import java.util.Stack;

public class P503NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        for ( int i=2*n-1; i >=0 ; i--){
            while ( !stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            if ( i < n) {
                if ( !stack.isEmpty() ) res[i] = stack.peek();
                else res[i] = -1;
            }
            stack.push(nums[i]);
        }
        return res;
    }
}
