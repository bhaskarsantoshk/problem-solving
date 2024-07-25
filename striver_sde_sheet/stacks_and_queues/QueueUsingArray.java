package striver_sde_sheet.stacks_and_queues;

public class QueueUsingArray {
    private final int[] queue;
    private int front, rear;
    private final int capacity;
    private int size;

    private static final int DEFAULT_CAPACITY = 100005;

    public QueueUsingArray() {
        this(DEFAULT_CAPACITY);
    }

    public QueueUsingArray(int cap) {
        this.queue = new int[cap];
        this.capacity = cap;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Method to add an element to the queue
    public void add(int val) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear % capacity] = val;
        rear++;
        size++;
    }

    // Method to get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front % capacity];
    }

    // Method to remove and return the front element
    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int toBeReturned = queue[front % capacity];
        queue[front % capacity] = -1; // Optional: clear the position for debugging purposes
        front++;
        size--;
        return toBeReturned;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to get the current size of the queue
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Front element is: " + queue.peek()); // Output: 1
        System.out.println("Removed front element: " + queue.poll()); // Output: 1
        System.out.println("Removed front element: " + queue.poll()); // Output: 2
        System.out.println("Queue size is: " + queue.size()); // Output: 1
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false
        queue.add(4);
        System.out.println("Front element is: " + queue.peek()); // Output: 3
    }
}
