package company.google.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P939MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xToYs = new HashMap<>();
        for ( int[] point: points){
            xToYs.putIfAbsent(point[0], new HashSet<>());
            xToYs.get(point[0]).add(point[1]);
        }
        int minArea = Integer.MAX_VALUE;
        for ( int[] p1: points){
            for ( int[] p2: points){
                // p1---p3
                // |    |
                // p4---p2
                if ( p1[0] != p2[0] && p1[1] != p2[1]) {
                    if ( xToYs.get(p2[0]).contains(p1[1]) && xToYs.get(p1[0]).contains(p2[1])){
                        minArea = Math.min ( minArea, Math.abs((p2[0]-p1[0]) * (p2[1]-p1[1])));
                    }
                }
            }
        }
        return minArea;
    }
}
