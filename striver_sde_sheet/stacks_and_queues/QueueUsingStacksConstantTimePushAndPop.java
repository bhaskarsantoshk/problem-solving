package striver_sde_sheet.stacks_and_queues;

import java.util.Stack;

public class QueueUsingStacksConstantTimePushAndPop {
    Stack<Integer> input;
    Stack<Integer> output;

    QueueUsingStacksConstantTimePushAndPop(){
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if ( !output.isEmpty() ) return output.pop();
        while ( !input.isEmpty()) output.push(input.pop());
        return output.pop();
    }

    public int peek() {
        if ( !output.isEmpty() ) return output.peek();
        while ( !input.isEmpty()) output.push(input.pop());
        return output.peek();
    }

    public boolean empty(){
        return input.empty() && output.empty();
    }
}
