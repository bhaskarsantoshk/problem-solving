package takeUForward.QR;

public class P5FindTheRepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        long sumOfN = 0;
        long sumOfArray = 0;
        int n = nums.length;
        sumOfN = ((long) n * ( n+1))/2;
        for ( int num: nums) sumOfArray += num;
        int xMinusY = Math.toIntExact(sumOfArray - sumOfN);
        long sumOfSquaresofArray = 0;
        long sumOfSquaresofN = 0;
        for ( int num: nums) sumOfSquaresofArray += (long)num * num ;
        sumOfSquaresofN = ((long) n * (n + 1) * ((2L * n) + 1))/6;
        int xPlusY = Math.toIntExact(sumOfSquaresofArray - sumOfSquaresofN)/ xMinusY;
        int repeatingNum = (xPlusY+xMinusY)/2;
        int missingNum = xPlusY-repeatingNum;
        return new int[]{repeatingNum, missingNum};
    }
}
