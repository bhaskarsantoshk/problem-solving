package interviewbit.stacks_and_queues;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] A) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<= A.length ; i++){
            int h = (i==A.length) ? 0: A[i];
            if ( stack.isEmpty() || h >= A[stack.peek()]){
                stack.push(i);
            }
            else{
                int top = stack.pop();
                int area=0;

                if ( stack.isEmpty() ){
                    area = A[top] * i;
                }
                else{
                    area = A[top] * (i-stack.peek()-1);
                }
                i--;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int largestRectangleAreaTwoArrays(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for ( int i=0; i<heights.length;i++){
            while ( !stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if ( stack.isEmpty()) leftSmaller[i] = 0;
            else leftSmaller[i] = stack.peek()+1;
            stack.push(i);
        }

        int[] rightSmaller = new int[n];
        stack = new Stack<Integer>();
        for ( int i=n-1; i>=0;i--){
            while ( !stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if ( stack.isEmpty()) rightSmaller[i] = n-1;
            else rightSmaller[i] = stack.peek()-1;
            stack.push(i);
        }

        int maxArea = 0;
        for ( int i=0; i<heights.length; i++){
            maxArea = Math.max( maxArea, (rightSmaller[i] - leftSmaller[i]+1) * heights[i]);
        }

        return maxArea;
    }

    public int largestRectangleAreaTwoArraysSinglePass(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for ( int i=0; i<=n; i++){
            while ( !stack.isEmpty() && ( i == n || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if ( stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                maxArea = Math.max( maxArea, height* width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
