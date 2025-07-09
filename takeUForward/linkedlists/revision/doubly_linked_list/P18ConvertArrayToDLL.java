package takeUForward.linkedlists.revision.doubly_linked_list;

public class P18ConvertArrayToDLL {
    public ListNode arrayToLinkedList(int [] nums) {
        if ( nums == null || nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode prev = head;
        for ( int i=1; i<nums.length; i++){
            ListNode cur = new ListNode(nums[i], null, prev);
            prev.next = cur;
            prev = cur;
        }
        return head;
    }
}
