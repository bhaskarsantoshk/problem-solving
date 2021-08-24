package company.amazon.leetcode;

public class P109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if ( head == null ) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if ( head == tail ) return null;
        ListNode fast = head;
        ListNode slow = head;

        while ( fast != tail && fast.next!= tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right= toBST(slow.next, tail);
        return root;
    }
}
