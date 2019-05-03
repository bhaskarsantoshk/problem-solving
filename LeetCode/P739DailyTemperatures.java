package LeetCode;

import java.util.Stack;

public class P739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<Integer>();
        int result[] = new int[T.length];
        for(int i=0; i<T.length ; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                result[stack.peek()]= i-stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
