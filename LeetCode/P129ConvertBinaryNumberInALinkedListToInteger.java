package LeetCode;

public class P129ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;

        while ( cur != null ){
            ans = (ans << 1) | cur.val;
            cur = cur.next;
        }
        return ans;
    }
}
