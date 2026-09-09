package takeUForward.graph.revision4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G31MinimumMultiplicationsToReachEnd {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if ( start == end) return 0;
        int mod = 1_00_000;
        int [] distance = new int[100000];
        Arrays.fill(distance, (int)1e9+7);
        distance[start] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, start});

        while (!queue.isEmpty()){
            int nodeArr[] = queue.poll();
            int node = nodeArr[1];
            int steps = nodeArr[0];

            for ( int num: arr){
                int product = (num * node)%mod;
                if ( product == end) return steps+1;
                if ( distance[product] > steps+1 ) {
                    distance[product] = steps+1;
                    queue.offer(new int[]{ steps+1, product});
                }
            }

        }

        return -1;
    }
}
