package striver_sde_sheet.stacks_and_queues;
import java.util.LinkedList;
import java.util.Queue;

public class P225ImplementStackUsingQueues {
    Queue<Integer> queue1;
    Queue<Integer> queue2;


    public P225ImplementStackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // push to q2
    // move all elements from q1 to q2
    // swap q1 and q2
    public void push(int x) {
        queue2.offer(x);
        while ( !queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if ( empty() ) throw new IllegalStateException("stack is empty");
        return queue1.poll();
    }

    public int top() {
        if ( empty() ) throw new IllegalStateException("stack is empty");
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
