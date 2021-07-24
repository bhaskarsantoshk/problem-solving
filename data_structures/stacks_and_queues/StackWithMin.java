package data_structures.stacks_and_queues;

public class StackWithMin {
    int max_size;
    Stack<Integer> minStack;
    Stack<Integer> mainStack;

    public StackWithMin(int max_size){
        this.max_size = max_size;
        this.minStack = new Stack<>(max_size);
        this.mainStack = new Stack<>(max_size);
    }

    public Integer pop(){
        //1. Pop element from minStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
       minStack.pop();
       return mainStack.pop();
    }

    public void push (Integer val){
        //1. Push value in mainStack and check value with the top value of minStack
        //2. If value is greater than top, then push top in minStack
        //else push value in minStack
        mainStack.push(val);
        if ( !minStack.isEmpty() &&  minStack.top() < val){
            minStack.push(minStack.top());
        } else{
            minStack.push(val);
        }
    }

    public Integer min(){
        return minStack.top();
    }

}
