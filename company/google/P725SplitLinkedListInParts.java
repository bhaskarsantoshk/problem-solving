package company.google;

import company.microsoft.ListNode;

public class P725SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode cur = head;
        int len = 0;
        while ( cur!= null){
            len++;
            cur = cur.next;
        }
        int splitSize = len/k;
        int remain = len%k;

        cur = head;
        ListNode prev = null;
        for ( int i=0; cur != null && i < k; i++, remain--){
            result[i] = cur;
            for ( int j=0; j < splitSize + (remain >0 ? 1:0) ; j++ ){
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
        }
        return result;
    }
}
