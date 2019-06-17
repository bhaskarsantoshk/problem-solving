package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class P1019NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        while ( head != null ){
            al.add(head.val);
            head = head.next;
        }
        int res[] = new int [al.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< al.size(); i++){
            while ( !stack.isEmpty() && al.get(stack.peek()) < al.get(i)){
                res[stack.pop()] = al.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
