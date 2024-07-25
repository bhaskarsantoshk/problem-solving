package striver_sde_sheet.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> stack;

    ImplementStackUsingQueue(){
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.offer(x);
        int size = stack.size();
        int remain = size-1;
        while ( remain-- > 0){
            stack.offer(stack.poll());
        }
    }

    public int pop() {
        return stack.poll();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
