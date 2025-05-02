package takeUForward.recursion.contest;
import java.util.List;
import java.util.PriorityQueue;

public class FurthestReachableMountain {
    public int furthestReachableBuilding(List<Integer> heights,
                                         int energyDrinks, int climbingRopes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for ( int i=0; i<heights.size()-1; i++){
            int diff = heights.get(i + 1) - heights.get(i);
            if ( diff > 0) minHeap.offer(diff);
            if (minHeap.size() > climbingRopes) {
                energyDrinks -= minHeap.poll();
            }
            if (energyDrinks < 0) {
                return i;
            }
        }
        return heights.size()-1;
    }
}
