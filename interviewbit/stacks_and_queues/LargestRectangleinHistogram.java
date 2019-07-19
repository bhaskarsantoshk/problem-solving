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
}
