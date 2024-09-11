package company.google;

import java.util.Stack;

public class P84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for ( int i=0; i<=n; i++){
            while ( !stack.isEmpty() && ( i == n || heights[stack.peek()] > heights[i]) ){
                int height = heights[stack.peek()];
                stack.pop();
                int width ;
                if ( stack.isEmpty()) width = i;
                else width = i- stack.peek()-1;
                maxArea = Math.max( maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    class Solution {

        public int largestRectangleArea(int[] heights) {
            int[] left = nextSmallestToLeft(heights);
            int[] right = nextSmallestToRight(heights);
            int maxArea = Integer.MIN_VALUE;
            for (int i=0; i<heights.length; i++) {
                int area = ((i - left[i]) + (right[i] - i) - 1) * heights[i];
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
        }

        private int[] nextSmallestToLeft(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[heights.length];
            for (int i=0; i<heights.length; i++) {
                if (stack.isEmpty()) {
                    left[i] = -1;
                } else {
                    while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

                    if (stack.isEmpty()) {
                        left[i] = -1;
                    } else {
                        left[i] = stack.peek();
                    }
                }
                stack.push(i);
            }
            return left;
        }

        private int[] nextSmallestToRight(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int[] right = new int[heights.length];
            for (int i=heights.length-1; i>=0; i--) {
                if (stack.isEmpty()) {
                    right[i] = heights.length;
                } else {
                    while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();

                    if (stack.isEmpty()) {
                        right[i] = heights.length;
                    } else {
                        right[i] = stack.peek();
                    }
                }
                stack.push(i);
            }
            return right;
        }
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
