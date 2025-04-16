package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

import java.util.Stack;

public class P20ReverseADoublyLinkedList {
    public static Node reverseDLLStack(Node head)
    {
       Stack<Integer> stack = new Stack<>();
       Node cur = head;
       while (cur!= null){
           stack.push(cur.data);
           cur = cur.next;
       }
       cur = head;
       while (!stack.isEmpty()){
           cur.data = stack.pop();
           cur = cur.next;
       }
       return head;
    }

    public static Node reverseDLL(Node head)
    {
        if ( head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        while ( cur != null){
            prev = cur.prev;
            cur.prev = cur.next;
            cur.next = prev;
            cur = cur.prev;
        }
        return prev.prev;
    }
}
