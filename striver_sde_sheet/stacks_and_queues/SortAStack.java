package striver_sde_sheet.stacks_and_queues;

import java.util.Stack;

public class SortAStack {

    /**
     * Sorts a stack using an auxiliary stack.
     *
     * Key Idea:
     * The main idea is to use an auxiliary stack (tempStack) to sort the elements of the original stack (s).
     * The tempStack is used to ensure that elements are always inserted in the correct order, with the smallest elements on top.
     *
     * Steps:
     * 1. Initialize tempStack:
     *    - Start with an empty auxiliary stack (tempStack).
     *
     * 2. Process each element of s:
     *    - Pop the top element from s and store it in a temporary variable (tmp).
     *    - Compare tmp with the top element of tempStack. If tempStack is empty or its top element is less than or equal to tmp, push tmp onto tempStack.
     *    - If tempStack's top element is greater than tmp, move elements from tempStack back to s until you find the correct position for tmp in tempStack. Then, push tmp onto tempStack.
     *
     * 3. Repeat until s is empty:
     *    - Continue the process until all elements have been moved from s to tempStack in sorted order.
     *
     * 4. Return tempStack:
     *    - The tempStack now contains the elements in sorted order from bottom to top, which will be returned as the sorted stack.
     *
     * @param s the stack to be sorted
     * @return the sorted stack
     */
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> tempStack = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > tmp) {
                s.push(tempStack.pop());
            }
            tempStack.push(tmp);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);

        stack = sort(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
