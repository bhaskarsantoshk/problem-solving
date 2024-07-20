package company.microsoft.linkedlists;

import company.microsoft.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = l1;
        while ( cur != null ){
           stack1.push(cur.val);
           cur = cur.next;
        }
        cur = l2;
        while ( cur != null ){
            stack2.push(cur.val);
            cur = cur.next;
        }

        int carry = 0;
        int sum ;
        ListNode res = null;

        while ( !stack1.isEmpty() || !stack2.empty() || carry != 0 ){
            sum = 0;
            if (!stack1.empty()) sum+= stack1.pop();
            if (!stack2.empty()) sum+= stack2.pop();
            sum += carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum/10;
            temp.next = res;
            res = temp;
        }

        return res;
    }
}
