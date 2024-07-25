package striver_sde_sheet.stacks_and_queues;

public class StackUsingArrays {
    private final int[] stack ; // This line declares a private final array of integers named stack that will hold the
    // stack elements. private means this array can only be accessed within this class,
    // and final means its reference cannot be changed once assigned.;

    private int top;

    //This line declares a constant DEFAULT_CAPACITY which sets the default size of the stack to 1000. static means
    // this value is shared among all instances of the class, and final means it cannot be changed once assigned.
    private static final int DEFAULT_CAPACITY = 1000;


    public StackUsingArrays() {
        this(DEFAULT_CAPACITY);
    }

    public StackUsingArrays(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public void push(int val) {
        if (top + 1 < stack.length) {
            stack[++top] = val;
        } else {
            throw new StackOverflowError("Stack is full");
        }
    }

    public int pop() {
        if (top >= 0) {
            return stack[top--];
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int peek() {
        if (top >= 0) {
            return stack[top];
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int poll() {
        if (top >= 0) {
            return stack[top];
        }
        throw new IllegalStateException("Stack is empty");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top + 1 == stack.length;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }

    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element is: " + stack.peek()); // Output: 3
        System.out.println("Removed top element: " + stack.pop()); // Output: 3
        System.out.println("Removed top element: " + stack.pop()); // Output: 2
        System.out.println("Stack size is: " + stack.size()); // Output: 1
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        stack.clear();
        System.out.println("Is stack empty after clear? " + stack.isEmpty()); // Output: true
        System.out.println("Is stack full? " + stack.isFull()); // Output: false
    }
}