package takeUForward.stacksAndqueues;

import java.util.Stack;

public class P84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int [] pse = findNextSmallerElementToLeft( heights);
        int [] nse = findNextSmallerElementToRight( heights);
        int maxArea = 0;
        for ( int i=0; i<heights.length; i++){
            int area = (nse[i]-pse[i]-1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }

    private int[] findNextSmallerElementToRight(int[] heights) {
        int n = heights.length;
        int right[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for ( int i=n-1; i>=0; i--){
            if ( stack.isEmpty() ) right[i] = n;
            else{
                while ( !stack.isEmpty() && heights[stack.peek()] >= heights[i] ) stack.pop();
                if ( stack.isEmpty()) right[i] = n;
                else right[i] = stack.peek();
            }
            stack.push(i);
        }
        return right;
    }

    private int[] findNextSmallerElementToLeft(int[] heights) {
        int left[] = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<heights.length; i++){
            if ( stack.isEmpty() ) left[i] = -1;
            else{
                while ( !stack.isEmpty() && heights[stack.peek()] >= heights[i] ) stack.pop();
                if ( stack.isEmpty()) left[i] = -1;
                else left[i] = stack.peek();
            }
            stack.push(i);
        }
        return left;
    }


    public int largestRectangleAreaOptimized(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for ( int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && (heights[stack.peek()] > heights[i])){
                int element = stack.peek();
                int nse = i;
                stack.pop();
                int pse = (stack.isEmpty()) ? -1: stack.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse-pse-1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}
