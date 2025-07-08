package takeUForward.linkedlists.revision.singly_linked_list;

import java.util.ArrayList;
import java.util.List;

public class P1TraversalInLinkedList {
    public List<Integer> LLTraversal(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while ( cur != null ){
            list.add(cur.val);
            cur = cur.next;
        }
        return list;
    }
}
