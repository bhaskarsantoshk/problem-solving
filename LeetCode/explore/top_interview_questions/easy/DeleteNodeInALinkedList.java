package LeetCode.explore.top_interview_questions.easy;


public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if ( node == null ) return;
        if ( node.next == null ){
            node = null;
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
