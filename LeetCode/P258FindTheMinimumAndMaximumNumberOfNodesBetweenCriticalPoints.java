package LeetCode;

public class P258FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // maxDistance = distance between first and last critical point
        // minDistance = distance between two consecutive critical points

        // we can iterate from second to last but one as first and last will not have nodes both sides
        // they can't be local maxima or minima

        // we need store the following things
        // curNode, position of curr node, prev node
        // first critical point position
        // previous critical point position
        // minDistance

        ListNode prev = head;
        ListNode curr = head.next;
        int curIndex = 1;
        int minDistance = Integer.MAX_VALUE;
        int prevCriticalIndex = -1;
        int firstCriticalIndex = -1;

        int [] res =  {-1, -1};
        while ( curr.next != null ){
            if ( isCritical(curr, prev) ){
                if ( prevCriticalIndex == -1 ){
                    firstCriticalIndex = curIndex;
                    prevCriticalIndex = curIndex;
                } else {
                    minDistance = Math.min(minDistance, curIndex-prevCriticalIndex);
                }
                prevCriticalIndex = curIndex;
            }
            curIndex++;
            prev = curr;
            curr = curr.next;
        }

        if ( firstCriticalIndex != Integer.MAX_VALUE ){
            int maxDistance = prevCriticalIndex - firstCriticalIndex;
            res = new int[] { minDistance, maxDistance};
        }
        return res;
    }

    private boolean isCritical(ListNode curr, ListNode prev) {
        return ( curr.val > prev.val && curr.val > curr.next.val)
                || (curr.val < prev.val && curr.val < curr.next.val);
    }
}
