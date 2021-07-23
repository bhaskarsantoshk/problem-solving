package data_structures.stacks_and_queues;

public class QUsingStack <V> {
    Stack<V> stack1;
    Stack<V> stack2;
    public QUsingStack(int max_size){
        stack1 = new Stack<>(max_size);
        stack2 = new Stack<>(max_size);
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public void enqueue (V value){
        stack1.push(value);
    }

    public V dequeue(){
        // Traverse stack1 and pop all elements in stack2
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //pop from stack2 (which was at the end of stack1)
        V result = stack2.pop();
        //put all elements back in stack1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
