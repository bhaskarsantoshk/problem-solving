package LeetCode;


import java.util.Stack;

public class P85MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int a[][]= new int[matrix.length][matrix[0].length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                if(i==0){
                    if(matrix[i][j]=='1'){
                        a[i][j]=1;
                    }
                    else{
                        a[i][j]=0;
                    }
                }
                else {
                    if(matrix[i][j]=='1'){
                        a[i][j]= a[i-1][j]+1;
                    }
                    else {
                        a[i][j]=0;
                    }
                }
            }
        }

        //print2DArray(a);
        int maxArea=0;
        for(int i=0; i<matrix.length;i++){
            int area = maxareaOfHistogram(a[i]);
            maxArea= Math.max(area, maxArea);
        }
        System.out.println(maxArea);
        return 0;
    }

    private static int maxareaOfHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea =0;
        for(int i=0; i<=heights.length; i++){
            int h= (i==heights.length)?0: heights[i];
            if(stack.isEmpty() || h >= heights[stack.peek()]){
                stack.push(i);
            }
            else{
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i: i-stack.peek()-1);
                i--;
                maxArea=Math.max(area, maxArea);
            }
        }
        //System.out.println(maxArea);
        return maxArea;
    }

    private static void print2DArray(int[][] a) {
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        char matrix[][]= {
                {'1','0','1','0','0'},
        {'1','0','1','1','1'},
    {'1','1','1','1','1'},
        {'1','0','0','1','0'}
    };

       maximalRectangle(matrix);
    }
}
