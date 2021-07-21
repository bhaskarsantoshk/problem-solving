package data_structures.stacks_and_queues;

// start with class members (maxSize, value array, front , back and current Size),
// constructor, and couple of getters - getMaxSize, getCurrentSize
// Implement helper methods: isFull, isEmpty, top()
// Implement enqueue and dequeue


public class Queue <V>{
    private int maxSize;
    private V[] arr;
    private int front;
    private int back;
    private int currentSize;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        arr = (V[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize(){
        return maxSize;
    }
    public int getCurrentSize(){
        return currentSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize== maxSize;
    }
    public V top(){
        return arr[front];
    }
    public void enqueue(V value){
        if (isFull()){
            return;
        }
        back = (back+1) % maxSize;
        arr[back] = value;
        currentSize++;
    }

    public V dequeue() {
        if (isEmpty()){
            return null;
        }
        V temp = arr[front];
        front = (front+1)%maxSize;
        currentSize--;
        return temp;
    }
}
