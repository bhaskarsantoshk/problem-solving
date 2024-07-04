package LeetCode;

public class P2181MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        // To skip first 0
        head = head.next;
        ListNode start = head;

        while ( start != null ){
            int sum = 0;
            ListNode end = start;
            while ( end.val != 0){
                sum+= end.val;
                end = end.next;
            }
            start.val = sum;
            start.next = end.next;
            start = start.next;
        }
        return head;
    }
}

