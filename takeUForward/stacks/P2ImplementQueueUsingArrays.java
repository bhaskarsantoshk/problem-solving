package takeUForward.stacks;

public class P2ImplementQueueUsingArrays {
    class Queue {
        int front, rear;
        int []arr;
        int size;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            if ( size == arr.length ) return;
            if ( size == 0) {
                this.front = 0;
                this.rear = 0;
            } else {
                rear = (rear+1)%size;
            }
            arr[rear] = e;
            size++;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if ( size == 0) return -1;
            int element = -1;
            if ( size == 1) {
                element = arr[front];
                front = rear = 0;
            } else {
                element = arr[front];
                front = ( front+1)%arr.length;
            }
            size--;
            return element;
        }
    }
}
