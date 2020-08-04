package books.EPI.Searching;

public class SquareRoot {
    public static int squareRoot ( int k ){
        long start = 0, end = k;
        while ( start <= end){
            long mid = start + ( end - start)/2;
            long midSquared = mid * mid;
            if ( midSquared <= k){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return (int)start-1;
    }
}
