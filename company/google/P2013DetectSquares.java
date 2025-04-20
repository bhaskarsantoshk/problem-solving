package company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2013DetectSquares {

    List<int[]> coordinates;
    Map<String, Integer> counts;

    public P2013DetectSquares() {
       coordinates = new ArrayList<>();
       counts = new HashMap<>();
    }

    public void add(int[] point) {
        coordinates.add(point);
        String pointStr = point[0]+","+point[1];
        counts.put(pointStr, counts.getOrDefault(pointStr, 0)+1);
    }

    public int count(int[] point1) {
        int sum =0;
        for ( int[] point2:  coordinates){
            if ( point1[0] == point2[0] || point1[1] == point2[1] ||
                    Math.abs(point1[0]-point2[0]) != Math.abs(point1[1]-point2[1]) ) continue;
            String point3Str = point1[0]+","+point2[1];
            String point4Str = point2[0]+","+point1[1];

            sum += counts.getOrDefault(point3Str, 0) * counts.getOrDefault(point4Str, 0);
        }
        return sum;
    }

    /*
    (x, y+dy) p3 *      * p2(x+dx, y+dy)

    (x,y)     p1 *      * p4 (x+dx, y)
     */
}
