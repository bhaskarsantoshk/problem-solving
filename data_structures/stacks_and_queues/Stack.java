package data_structures.stacks_and_queues;

public class Stack <V>{
    private int maxSize;
    private int top;
    private V arr[];

    @SuppressWarnings("unchecked")
    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.top = -1;
        arr = (V[]) new Object[maxSize];
    }

    public int getCapacity(){
        return maxSize;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull(){
        return top == maxSize-1;
    }
    public V top(){
        if ( isEmpty() ){
            return null;
        }
        return arr[top];
    }
    public void push(V value){
        if ( isFull() ){
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = value;
    }
    public V pop(){
        if (isEmpty()){
            return null;
        }
        return arr[top--];
    }
}
