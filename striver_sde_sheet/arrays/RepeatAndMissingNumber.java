package striver_sde_sheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {
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




    // Using XOR method
    // 4 3 6 2 1 1
    // (4 ^ 3 ^ 6 ^ 2 ^ 1 ^ 1) ^ ( 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ) ->  Result will be (1 ^ 5)
    // Since there is at lease one repeating number and one missing number, the XOR of the above result will have at lease one non-zero Bit
    // to find that keep doing an & operation with 1, 10, 100, 1000 etc. to find the right most set bit
    // once you find the bit number that is non-zero
    // Now divide the above numbers into two groups - one group that has non-zero bit on the  bit number and the other group which is not
    // one group will contain missing number and one group will contain the repeating number
    // Now when we XOR the groups separately you will get the both missing and repeating number because they are the numbers that repeat odd times
    // rest of the numbers get cancelled
    public int[] repeatedNumber(final int[] A) {
        int xor = 0;
        for ( int i=0; i< A.length; i++){
            xor ^= A[i];
            xor ^= (i+1);
        }
        int bitNumber = 0;
        while (true){
          if ( (xor & ( 1 << bitNumber )) == 0){
              break;
          }
          bitNumber++;
        }

        int zeroGroup = 0;
        int oneGroup = 0;

        for ( int i=0; i<A.length; i++){
            if ( (A[i] & (1 << bitNumber)) == 0){
                zeroGroup ^= A[i];
            } else {
                oneGroup ^= A[i];
            }
        }

        for ( int i=1; i<=A.length; i++){
            if ( (i & (1 << bitNumber)) == 0){
                zeroGroup ^= i;
            } else {
                oneGroup ^= i;
            }
        }
        int count = 0;
        for (int num: A){
            if ( num == zeroGroup ) count++;
        }
        if ( count == 2 ){
            return new int[]{zeroGroup, oneGroup};
        } else {
            return new int[]{oneGroup, zeroGroup};
        }
    }
}
