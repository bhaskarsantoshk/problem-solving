package takeUForward.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class G39MinimumMultiplicationsToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {
        if ( start == end) return 0;
        int[] distance = new int[100000];
        int MOD = 100000;
        Arrays.fill(distance, (int)1e9);
        distance[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // a simple queue will also work as steps are increasing at =1
        pq.offer(new int[]{0, start});
        while ( !pq.isEmpty()){
            int pair[] = pq.poll();
            int steps = pair[0];
            int num = pair[1];
            for ( int i=0; i<arr.length; i++){
                int newNum = (num * arr[i])%MOD;
                if ( distance[newNum] > steps+1){
                    distance[newNum] = steps+1;
                    if ( newNum == end) return steps+1;
                    pq.offer(new int[]{steps+1, newNum});
                }
            }
        }
        int ans = distance[end] == (int)1e9 ? -1: distance[end];
        return ans;
    }
}
