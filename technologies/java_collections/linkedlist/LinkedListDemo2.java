package technologies.java_collections.linkedlist;

import java.util.LinkedList;

public class LinkedListDemo2 {
    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);

        System.out.println(linkedList.getFirst()); //Fetching the first element.

        System.out.println(linkedList.getLast()); //Fetching the last element.

        System.out.println(linkedList.get(2)); //Fetching the element at second index.
    }
}
