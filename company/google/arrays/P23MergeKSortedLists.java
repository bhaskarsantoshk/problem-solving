package company.google.arrays;

import company.microsoft.ListNode;

import java.util.PriorityQueue;

public class P23MergeKSortedLists {

    // Extreme Naive solution , create an array list, iterate over each list , put all numbers in an arraylist
    // sort the list
    // create a linked list out of the sorted array
    // T O(N*K ) + o(m log m) // m = n*k
    // S O(M)+O(M)

    // Merge first two, go to 3 and apply merge , and so on
    // O(N1+N2) + O(N1+N2+N3) + O(N1+N2+N3+N4) ....
    // O(2N)+O(3N)+... O(K.N)
    // O(N * K*(K+1)/2) Cubic

    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        ListNode head = lists[0];
        for ( int i=1; i< lists.length; i++){
            head = mergeTwoLists( head, lists[i]);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // TODO
        return null;
    }

    // T = O(N* k * logk), S = O(K)
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length== 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (l1,l2)-> l1.val-l2.val);
        for ( ListNode node: lists){
            if (node != null ) priorityQueue.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( !priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null ) priorityQueue.offer(node.next);
        }
        return dummy.next;
    }


}
