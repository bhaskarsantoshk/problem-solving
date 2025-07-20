package company.google.experiences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P939MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for ( int[] point: points){
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;

        for ( int[] p1: points){
            for ( int [] p2: points){
                // p1---p3
                // |    |
                // p4---p2
                if ( p1[0] != p2[0] && p1[1] != p2[1]){
                    if ( map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])){
                        minArea = Math.min(minArea, Math.abs((p2[0]-p1[0]) * (p2[1]-p1[1])));
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0: minArea;
    }
}
