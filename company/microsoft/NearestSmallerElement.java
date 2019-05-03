package microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            if(stack.isEmpty()){
                result.add(-1);
                stack.push(A.get(i));
            }
            else{
                while(!stack.isEmpty() && stack.peek() >= A.get(i)){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    result.add(-1);
                }
                else{
                    result.add(stack.peek());
                }
                stack.push(A.get(i));
            }
        }
        return result;
    }
}
