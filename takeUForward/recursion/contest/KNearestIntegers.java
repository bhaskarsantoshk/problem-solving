package takeUForward.recursion.contest;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KNearestIntegers {
    public List<Integer> kNearestIntegers(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a,b) -> {
                    int diff = Math.abs(b-x) - Math.abs(a-x);
                    return (diff != 0) ? diff: b-a;
                }
        );
        for ( int i=0; i < arr.length ; i++){
            maxHeap.offer(arr[i]);
            if ( maxHeap.size() > k) maxHeap.poll();
        }
        List<Integer> result = new ArrayList<>(maxHeap);
        Collections.sort(result);
        return result;
    }
}
