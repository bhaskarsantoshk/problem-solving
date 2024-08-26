package company.microsoft.others;
import java.util.*;

public class P218TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> heights = new ArrayList<>();

        for ( int [] building: buildings){
            heights.add(List.of(building[0], -building[2]));
            heights.add(List.of(building[1], building[2]));
        }
        heights.sort((a, b) -> Objects.equals(a.getFirst(), b.getFirst()) ? a.get(1) - b.get(1) : a.getFirst() - b.getFirst());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        pq.offer(0);
        int preMax = 0;
        for ( List<Integer> height : heights){
            if ( height.get(1) < 0) pq.offer(-height.get(1));
            else pq.remove(height.get(1));
            int curMax = pq.peek();
            if ( curMax != preMax){
                res.add(List.of(height.get(0), curMax));
                preMax = curMax;
            }
        }
        return res;
    }
}
