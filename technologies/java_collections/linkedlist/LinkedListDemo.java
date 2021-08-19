package technologies.java_collections.linkedlist;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(28);
        linkedList.add(29);
        linkedList.add(12);

        System.out.println(linkedList);

        linkedList.addFirst(5);
        System.out.println(linkedList);

        linkedList.add(2, 36);
        System.out.println(linkedList);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        linkedList.addAll(3, list);
        System.out.println(linkedList);
    }
}
