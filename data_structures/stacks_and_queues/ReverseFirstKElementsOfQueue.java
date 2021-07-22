package data_structures.stacks_and_queues;

public class ReverseFirstKElementsOfQueue {
    public static <V> void reverseK(Queue<V> queue, int k) {
        //1.Push first k elements in queue in a stack.
        //2.Pop Stack elements and enqueue them at the end of queue
        //3.Dequeue queue elements till "k" and append them at the end of queue
        //4.Dequeue the remaining elements and enqueue them again to append them at end of the queue
        if ( queue.isEmpty() || k<= 0){
            return;
        }
        Stack<V> stack = new Stack<>(k);
        while (!stack.isFull()){
            stack.push(queue.dequeue());
        }
        while ( !stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        int size = queue.getCurrentSize();
        for ( int i=0; i<size-k; i++){
            queue.enqueue(queue.dequeue());
        }
    }
}
