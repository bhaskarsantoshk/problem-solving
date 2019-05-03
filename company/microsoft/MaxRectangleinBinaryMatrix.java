package microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class MaxRectangleinBinaryMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int [][]height = new int[A.size()][A.get(0).size()];
        for(int j=0;j<A.get(0).size(); j++){
            height[0][j]= A.get(0).get(j);
        }
        for(int i=1;i<A.size();i++){
            for(int j=0; j<A.get(0).size(); j++){
                height[i][j] = (A.get(i).get(j)==1)? height[i-1][j]+1 : 0;
            }
        }

        int maxArea = 0;
        for(int i=0;i<A.size(); i++) {
            maxArea = Math.max(maxArea, maxAreaHistogram(height[i]));
        }
        return maxArea;
    }

    private int maxAreaHistogram(int[] height) {
        int i=0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i < height.length){
            if(stack.isEmpty() || height[i] >= stack.peek()){
                stack.push(i++);
            }
            else{
                int t = stack.pop();
                max = Math.max(max, height[t] * ((stack.isEmpty()) ? i : i- stack.peek()-1));
            }
        }

        while(!stack.isEmpty()){
            int t = stack.pop();
            max = Math.max(max, height[t] * ((stack.isEmpty()) ? i : i- stack.peek()-1));
        }
        return max;
    }


}