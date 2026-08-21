package takeUForward.google;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Point> points = getPoints(grid);
        int minDistance = Integer.MAX_VALUE;
        for ( int row=0; row < grid.length; row++){
            for ( int col = 0; col <grid[0].length; col++){
                int distance = calculateDistance( points, row, col);
                minDistance = Math.min(distance, minDistance);
            }
        }
        return minDistance;
    }

    private int calculateDistance(List<Point> points, int row, int col) {
        int distance = 0;
        for ( Point p: points){
            distance = Math.max( distance, Math.abs(row-p.row) + Math.abs(col-p.col));
        }
        return distance;
    }

    private List<Point> getPoints(int[][] grid) {
        List<Point> points = new ArrayList<>();
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[0].length; j++){
                if ( grid[i][j] == 1){
                    points.add(new Point(i,j));
                }
            }
        }
        return points;
    }

    class Point{
        int row, col;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
