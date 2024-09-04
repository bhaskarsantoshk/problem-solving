package takeUForward.dynamicProgramming;

import java.util.Stack;

public class DP55MaximumRectangleAreaWithAll1SDPOnRectangles {
    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
       int height[] = new int[m];
       int maxArea = 0;
       for ( int i=0; i<n; i++){
           for ( int j=0; j<m ; j++){
               if ( mat[i][j] == 0) height[j] = 0;
               else height[j]+=1;
           }
           maxArea = Math.max(largestAreaInHistogram(height), maxArea);
       }
       return maxArea;
    }

    private static int largestAreaInHistogram(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for ( int i=0; i<=n; i++){
            while ( !stack.isEmpty() && ( i == n || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.peek()];
                stack.pop();
                int width ;
                if ( stack.isEmpty())  width = i;
                else width = i-stack.peek()-1;
                maxArea = Math.max( maxArea, width* height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
