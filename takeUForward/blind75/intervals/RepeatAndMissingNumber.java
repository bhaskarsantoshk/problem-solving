package takeUForward.blind75.intervals;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {

    // 4 3 6 2 1 1
    // Let's consider repeating number is X and missing number is Y.
    // Sum of the numbers => SumOfA = 4 + 3 + 6 + 2 + 1 + 1
    // Sum of first N numbers => SumOfFirstN = 1 + 2 + 3 + 4 + 5 + 6 ( can be written as (n * (n+1))/2 )
    // SumOfA - SumOfN = -4 ( which is X - Y )
    // SquareSumOfA =  4*4 + 3*3 + 6*6 + 2*2 + 1*1 + 1*1
    // SquareSumOfN = 1*1 + 2*2 + 3*3 + 4*4 + 5*5 + 6*6 ( can be written as (n * (n+1)* (2n+1))/6 )
    // SquareSumOfA - SquareSumOfN = -24 ( which is X^2 - Y^2 )
    // X + Y = ( SquareSumOfA - SquareSumOfN )/ ( SumOfA - SumOfN) = 6
    // X = (( X - Y ) + ( X + Y ))/2 = 1
    // Y =  X - ( X- Y ) = 1 - ( -4 ) = 5

    public ArrayList<Integer> repeatedNumberMath(final List<Integer> A) {
        long n = A.size();
        long sumOfA = 0;
        for ( int i=0; i<A.size(); i++){
            sumOfA += A.get(i);
        }
        long sumOfN = ( n * (n+1))/2;

        long squareSumOfA = 0;
        for ( int i=0; i<n; i++){
            squareSumOfA += ((long) A.get(i) * A.get(i));
        }
        long squareSumOfN = ( n * (n+1) * ((2*n)+1) ) / 6;

        long XMinusY = sumOfA - sumOfN;
        long XPlusY = (squareSumOfA - squareSumOfN) / ( sumOfA- sumOfN);
        int repeated = (int) (( XMinusY+ XPlusY ) / 2);
        int missing = (int) (repeated - (XMinusY));
        ArrayList <Integer> res = new ArrayList<>();
        res.add(repeated);
        res.add(missing);
        return res;
    }

}
