package company.google.stacks_and_queues;

import java.util.Stack;

public class P85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
       int maximumRectangle = 0;
       int n =matrix.length, m= matrix[0].length;
       int [] heights = new int[m];
       for ( int i=0; i<n; i++){
           for ( int j=0; j<m; j++){
               if ( matrix[i][j] == '0') heights[j] = 0;
               else heights[j] += 1;
           }
           maximumRectangle = Math.max(maximumRectangle, largestRectangleInHistogram(heights));
       }
       return maximumRectangle;
    }

    public int largestRectangleInHistogramOptimized( int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for ( int i=0; i<n; i++){
            while ( !stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int height = heights[stack.peek()];
                stack.pop();
                int nse = i;
                int pse = ( stack.isEmpty()) ? -1: stack.peek();
                maxArea = Math.max(maxArea, height* (nse-pse-1));
            }
            stack.push(i);
        }
        while ( !stack.isEmpty() ){
            int height = heights[stack.peek()];
            stack.pop();
            int nse = n;
            int pse = ( stack.isEmpty()) ? -1: stack.peek();
            maxArea = Math.max(maxArea, height* (nse-pse-1));
        }
        return maxArea;
    }

    public int largestRectangleInHistogram( int[] heights){
        int [] nse = smallerElementFromRight( heights);
        int [] pse = smallerElementFromLeft(heights);
        int maxArea = 0;
        for ( int i=0;  i<heights.length; i++){
            maxArea = Math.max( maxArea, heights[i] * (nse[i]-pse[i]-1));
        }
        return maxArea;
    }

    private int[] smallerElementFromLeft(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int [] left = new int[n];
        for ( int i=0; i<n; i++){
            if ( stack.isEmpty()){
                left[i] = -1;
            }else {
                while ( !stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if ( stack.isEmpty()) left[i] = -1;
                else left[i] = stack.peek();
            }
            stack.push(i);
        }
        return left;
    }

    private int[] smallerElementFromRight(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int [] right = new int[n];
        for ( int i=n-1; i>=0; i--){
            if ( stack.isEmpty()){
                right[i] = n;
            }else {
                while ( !stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if ( stack.isEmpty()) right[i] = n;
                else right[i] = stack.peek();
            }
            stack.push(i);
        }
        return right;
    }
}
