package data_structures.linked_lists;

import java.util.HashSet;
import java.util.Set;

import static data_structures.linked_lists.Node.printList;

public class UnionOfLinkedLists {
    public static Node union(Node list1, Node list2){
        if ( list1 == null ) return list2;
        if ( list2 == null ) return list1;
        Node last = list1;
        while ( last.next != null ){
            last = last.next;
        }
        last.next = list2;
        list1 = removeDuplicatesWithHashing(list1);
        return list1;
    }

    private static Node removeDuplicatesWithHashing(Node list1) {
      Set<Integer> visitedData = new HashSet<>();
      Node head = list1;
      Node prev = list1;
      Node cur = list1;
      while ( cur != null && cur.next != null ){
          if ( visitedData.contains(cur.data)){
              prev.next = cur.next;
          }
          else {
              visitedData.add((Integer) cur.data);
              prev = cur;
          }
          cur = cur.next;
      }
      return head;
    }

    public static void main(String[] args){
        Node head1 = new Node(0);
        Node node = head1;
        for ( int i=0; i<6; i++){
            node.next = new Node(i+1);
            node = node.next;
        }
        Node head2 = new Node(0);
        Node node2 = head2;
        for ( int i=0; i<6; i++){
            node2.next = new Node(i*2);
            node2 = node2.next;
        }
        printList(head1);
        printList(head2);
        Node res = union(head1, head2);
        printList(res);
    }
}
