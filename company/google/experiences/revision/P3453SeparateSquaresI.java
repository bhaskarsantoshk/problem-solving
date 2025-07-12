package company.google.experiences.revision;

public class P3453SeparateSquaresI {
    public double separateSquares(int[][] squares) {
       double low = 0, high = 2*1e9;
       double eps = 1e-5;
       while ( high - low > eps){
           double mid = (low + high)/2.0;
           if ( getAreaDiff(mid, squares) > 0) {
               low = mid;
           } else {
               high = mid;
           }
       }
       return high;
    }

    private double getAreaDiff(double line, int[][] squares) {
        double areaBelowLine = 0.0, areaAboveLine=0.0;
        for ( int [] square: squares){
            int x = square[0], y = square[1], length = square[2];
            double area = (double) length*length;
            if ( line <= y) areaAboveLine += area;
            else if ( line >= y+ length) areaBelowLine += area;
            else {
                areaBelowLine += (double) ( (line-y)* length);
                areaAboveLine += (double) ((y+length-line) * length);
            }
        }
        return areaAboveLine-areaBelowLine;
    }
}
