package company.google.experiences;

public class P3453SeparateSquaresI {
    public double separateSquares(int[][] squares) {
        double low = 0, high = 2* 1e9;
        for ( int i=0; i<60; i++){
            double mid = (low + high)/2.0;
            double diff = getAreaDiff(mid, squares);
            if ( diff > 0) low = mid;
            else high = mid;
        }
        return high;
    }

    private double getAreaDiff(double line, int[][] squares) {
        double areaAboveLine = 0, areaBelowLine = 0;
        for ( int [] square : squares){
            int x = square[0], y = square[1], length = square[2];
            double area = (double) length * length;
            if ( line <= y){
                areaAboveLine += area;
            } else if ( line >= y+length){
                areaBelowLine += area;
            } else {
                double aboveHeight = (y+length)-line;
                double belowHeight = line-y;
                areaAboveLine += length * aboveHeight;
                areaBelowLine += length * belowHeight;
            }
        }
        return areaAboveLine-areaBelowLine;
    }
}
