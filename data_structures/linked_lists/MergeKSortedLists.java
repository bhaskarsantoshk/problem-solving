package data_structures.linked_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static Node mergeKSortedLists(Node[] list){
        if ( list == null || list.length == 0) return null;
        PriorityQueue<Node> pq = new PriorityQueue<>(list.length, new Comparator<Node>() {
            @Override
            public int compare(Node l1, Node l2) {
                return (Integer) l1.data-(Integer) l2.data;
            }
        });

        for ( int i=0; i<list.length; i++){
            pq.offer(list[0]);
        }
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            if ( tail.next != null){
                pq.offer(tail.next);
            }
        }
        return dummy.next;
    }
}
