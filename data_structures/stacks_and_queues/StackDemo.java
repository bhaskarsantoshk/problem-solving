package data_structures.stacks_and_queues;

public class StackDemo {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>(5);
        System.out.print("Elements pushed in the Stack: ");
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.print(i + " ");
        }
        System.out.println("\nIs Stack full? \n" + stack.isFull());
        System.out.print("Elements popped from the Stack: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println("\nIs Stack empty? \n" + stack.isEmpty());
    }
}
