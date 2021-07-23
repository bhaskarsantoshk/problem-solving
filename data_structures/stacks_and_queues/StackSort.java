package data_structures.stacks_and_queues;

public class StackSort {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>(stack.getCapacity());
        while ( !stack.isEmpty()){
            Integer val = stack.pop();
            if ( !newStack.isEmpty() && val >= newStack.top()){
                newStack.push(val);
            }
            else {
                while ( !newStack.isEmpty() && newStack.top() > val){
                    stack.push(newStack.pop());
                }
                newStack.push(val);
            }
        }
        while ( !newStack.isEmpty() ){
            stack.push(newStack.pop());
        }
    }
}
