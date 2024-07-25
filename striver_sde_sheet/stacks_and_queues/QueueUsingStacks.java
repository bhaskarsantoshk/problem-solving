package striver_sde_sheet.stacks_and_queues;
import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    QueueUsingStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while ( !stack1.isEmpty() ){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        if ( empty() ) throw new IllegalStateException("queue is empty");
        return stack1.pop();
    }

    public int peek() {
        if ( empty() ) throw new IllegalStateException("queue is empty");
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
