package technologies.java_collections.linkedlist;

import java.util.LinkedList;

public class LinkedListDemo3 {
    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("LinkedList before removing any element " + linkedList);

        linkedList.remove(); //Removes the first element.
        System.out.println("LinkedList after removing first element " + linkedList);

        linkedList.removeLast(); //Removes the last element.
        System.out.println("LinkedList after removing last element " + linkedList);

        linkedList.remove(Integer.valueOf(2)); //Removes the first occurrence of 2.
        System.out.println("LinkedList after removing first occurrence of 2. " + linkedList);

        linkedList.removeLastOccurrence(Integer.valueOf(4)); //Removes the last occurrence of 4.
        System.out.println("LinkedList after removing the last occurrence of 4. " + linkedList);
    }
}
