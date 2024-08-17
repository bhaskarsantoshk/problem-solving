package LeetCode;
import java.util.List;

public class P624MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int smallest = arrays.get(0).get(0);
        int biggest = arrays.get(0).get(arrays.get(0).size()-1);
        int maxDistance = Integer.MIN_VALUE;
        for ( int i=1; i<arrays.size(); i++){
            List<Integer> list = arrays.get(i);
            int smaller = list.get(0);
            int bigger = list.get(list.size()-1);
            maxDistance = Math.max( maxDistance, Math.max(Math.abs(biggest-smaller), Math.abs(bigger-smallest)));
            smallest = Math.min(smallest, smaller);
            biggest = Math.max( bigger, biggest);
        }
        return maxDistance;
    }
}
