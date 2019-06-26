package practice;

import java.util.List;

public class MinCostToCollectAllCoins {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int getMinCostToCollectAllCoins(List<Point> points,Point locationA, Point locationB){
        return getMinCostToCollectAllCoinsUtil(points, locationA, locationB, 0 , 0);
    }

    private int getMinCostToCollectAllCoinsUtil(List<Point> points, Point locationA, Point locationB, int idx, int result) {
        if ( idx == points.size() ){
            return result;
        }
        int costToReachCurrentPointFromA = getDistance(points.get(idx), locationA);
        int costToReachCurrentPointFromB = getDistance(points.get(idx), locationB);
        int optionOne = getMinCostToCollectAllCoinsUtil(points, points.get(idx), locationB, idx+1, result+ costToReachCurrentPointFromA);
        int optionTwo = getMinCostToCollectAllCoinsUtil(points, locationA, points.get(idx), idx+1, result+ costToReachCurrentPointFromB);
        return Math.min( optionOne, optionTwo);
    }

    private int getDistance(Point point, Point locationA) {
        return 0;
    }
}
