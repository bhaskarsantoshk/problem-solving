package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class P1823FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList();
        for ( int i=1; i<=n; i++){
            queue.offer(i);
        }
        while ( queue.size() > 1) {
            for ( int i=1; i<k; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    public int findTheWinnerRec(int n, int k) {
        return winnerHelper(n, k)+1;
    }

    private int winnerHelper(int n, int k) {
        if ( n == 1) return 0;
        return ( winnerHelper(n-1, k)+k)%n;
    }

    public int findTheWinnerBottomUp(int n, int k) {
        int val = 0;
        for ( int i=2; i<=n; i++){
            val = (val+k)%i;
        }
        return val+1;
    }



}
