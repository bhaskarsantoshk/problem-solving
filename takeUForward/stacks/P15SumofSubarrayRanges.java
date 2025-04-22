package takeUForward.stacks;

import java.util.Stack;

public class P15SumofSubarrayRanges {
    // N^2 Time
    public long subArrayRangesBruteForce(int[] nums) {
        long sum = 0;
        for ( int i=0; i<nums.length; i++){
            int largest = nums[i], smallest = nums[i];
            for ( int j=i+1; j<nums.length; j++){
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                sum += (largest-smallest);
            }
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sumOfAllSubArraysMin = findSumSubArraysMin(nums, n);
        long sumOfAllSubArrayMax = findSumSubArraysMax(nums, n);
        return sumOfAllSubArrayMax - sumOfAllSubArraysMin;
    }

    private long findSumSubArraysMax(int[] nums, int n) {
        int[] ngeI = findNextGreaterElementIndex(nums, n);
        int[] pgeeI = findPreviousGreaterOrEqualIndex(nums, n);
        long sum = 0;
        for ( int i=0; i<n; i++){
            sum += ((long) nums[i]* (ngeI[i] - i) * (i-pgeeI[i]));
        }
        return sum;
    }

    private int[] findPreviousGreaterOrEqualIndex(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] psee = new int[n];
        for ( int i=0; i<n; i++){
            while ( !stack.isEmpty() && nums[stack.peek()] < nums[i]) stack.pop();
            psee[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        return psee;
    }

    private int[] findNextGreaterElementIndex(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ngeI = new int[n];
        for ( int i=n-1; i>=0; i--){
            while ( !stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            ngeI[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        return ngeI;
    }

    private long findSumSubArraysMin(int[] nums, int n) {
        int[] nseI = findNextSmallerElementIndex(nums, n);
        int[] pseeI = findPreviousSmallerOrEqualIndex(nums, n);
        long sum = 0;
        for ( int i=0; i<n; i++){
            sum += (long) nums[i]* (nseI[i] - i) * (i-pseeI[i]);
        }
        return sum;
    }

    private int[] findPreviousSmallerOrEqualIndex(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] psee = new int[n];
        for ( int i=0; i<n; i++){
            while ( !stack.isEmpty() && nums[stack.peek()] > nums[i]) stack.pop();
            psee[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        return psee;
    }

    private int[] findNextSmallerElementIndex(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];
        for ( int i=n-1; i>=0; i--){
            while ( !stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            nse[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        return nse;
    }


    // 1 3 2 4
    // 1 => 1 -1
    // 1 3 => 3 -1
    // 1 3 2 => 3 -1
    // 1 3 2 4 => 4-1
    // 3 => 3-3
    // 3 2 => 3-2
    // 3 2 4 => 4-2
    // 2 => 2-2
    // 2 4 => 4-2
    // 4=>4-4
    // sum of all max in sub arrays - sum of all min in sub arrays
    // sum of all min in sub arrays
    // 1 4 3 2 4 5 1
    // count sub arrays in which 1 is min, 3 is min , 2 is min and 4 is min
    // for 2 , (43) 2 (45) form sub arrays with 2 as min, 3*2 = 6
    // (find next smaller index - i) * (i- find previous equal or smaller element index)
    // sum of all max in sub arrays
    //
}
