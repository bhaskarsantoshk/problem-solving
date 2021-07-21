package data_structures.stacks_and_queues;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    void enqueue(int data) {
        stack1.push(data);
    }

    boolean isEmpty() {
        return stack1.size()+stack2.size() == 0;
    }

    int dequeue() {
        if ( isEmpty() ){
            return -1;
        }
        if ( stack2.isEmpty() ){
            while ( !stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

// enqueue : O(1) , dequeue : O(N)
