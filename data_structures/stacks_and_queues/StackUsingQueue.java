package data_structures.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    void push(int data){
        queue1.add(data);
    }

    boolean isEmpty(){
        return queue1.size()+queue2.size() == 0;
    }

    void swap_queues(){
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    int pop(){
        if ( isEmpty() ){
            return -1;
        }
        while ( queue1.size() >1 ){
            queue2.add(queue1.remove());
        }
        int value = queue1.remove();
        swap_queues();
        return value;
    }
}

// push : O(1) pop(): O(N)
