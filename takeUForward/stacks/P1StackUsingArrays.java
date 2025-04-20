package takeUForward.stacks;

public class P1StackUsingArrays {
    static class Stack {
        int top;
        int capacity;
        int[] stack;
        Stack(int capacity) {
            this.top = -1;
            this.capacity = capacity;
            this.stack = new int[capacity];
        }
        public void push(int num) {
            if ( isFull() == 1) {
                // throw new ArrayIndexOutOfBoundsException();
                return;
            }
            top++;
            stack[top] = num;
        }
        public int pop() {
            if ( isEmpty()  == 1) {
                // throw new ArrayIndexOutOfBoundsException();
                return -1;
            }
            int pop = stack[top];
            top--;
            return pop;
        }
        public int top() {
            if ( top == -1) {
                //throw new ArrayIndexOutOfBoundsException();
                return -1;
            }
            return stack[top];
        }
        public int isEmpty() {
            return top==-1 ? 1:0;
        }
        public int isFull() {
            return top == stack.length-1 ? 1: 0;
        }
    }
}
