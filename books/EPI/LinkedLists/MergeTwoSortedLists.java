package books.EPI.LinkedLists;

public class MergeTwoSortedLists {
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> l1, ListNode<Integer> l2){
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> cur = dummyHead;

        while ( l1!= null && l2!= null ){
            if (l1.data <= l2.data){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1: l2;
        return dummyHead.next;
    }
}
