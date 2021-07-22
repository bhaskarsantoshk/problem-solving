package data_structures.stacks_and_queues;

public class TwoStacksUsingArray<V> {
    private int maxSize;
    private V[] arr;
    private int top1, top2;

    public TwoStacksUsingArray(int maxSize){
        this.maxSize = maxSize;
        arr = (V[]) new Object[maxSize];
        this.top1 = -1;
        this.top2 = maxSize;
    }

    //insert at top of first stack
    public void push1(V value) {
        if ( top1 < top2-1){
            arr[top1++]= value;
        }
    }

    //insert at top of second stack
    public void push2(V value) {
        if ( top1 < top2-1){
            arr[--top2] = value;
        }
    }

    //remove and return value from top of first stack
    public V pop1() {
        if ( top1 > -1){
            return arr[top1--];
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if ( top2 < maxSize){
            return arr[top2++];
        }
        return null;
    }
}
