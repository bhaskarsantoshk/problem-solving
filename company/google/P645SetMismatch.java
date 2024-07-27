package company.google;

public class P645SetMismatch {

    // all integers arr 1 to n ( nums.length)
    // iterate over 1 to n, find the count and update the result array
    // T = O(N^2)
    public int[] findErrorNumsBruteForce(int[] nums) {
        int []res = new int[2];
        for ( int num = 1; num <= nums.length; num++){
            int count = 0;
            for ( int i=0; i<nums.length; i++){
                if ( nums[i] == num ) count++;
            }
            if ( count == 2) res[0] = num; // repeat number
            if ( count == 0) res[1] = num; // missing number
        }
        return res;
    }

    // reduce time complexity to O(N) using hashing
    // Space O(N)
    public int[] findErrorNumsTimeOptimized(int[] nums) {
        int[] count = new int[nums.length+1];
        for ( int num: nums){
            count[num]++;
        }
        int missing = -1, repeat = -1;
        // zero's count will be zero, make sure to skip it
        for ( int num: count){
            if (count[num] == 2) repeat = num;
            if ( count[num] == 0) missing = num;
            // small optimization
            if ( repeat != -1 && missing != -1) break;
        }
        return new int[]{repeat, missing};
    }

    // Two optimal solutions one using Math and one using XOR


    // Math
    // x = repeat, y = missing
    // sum of the array - sum of the 1st n natural nums = x-y
    // sum of the squares of array num - sum of the squares of 1st n natural numbers = x^2 - y^2 , we can get x+y
    // sum of the above can get us x
    // and from the x , we can know y

    public int[] findErrorNums(int[] nums) {
        long n = nums.length;
        long sumOfFirstN = ((n) * (n+1))/2;
        long sumOfSquaresOfFirstN = ((n) * (n+1)* (2*n + 1))/6;
        long sum = 0, xMinusY = 0;
        for ( int num: nums){
            sum += num;
        }
        xMinusY = sum - sumOfFirstN;
        long squareSum = 0, xPlusY = 0;
        for ( int num: nums){
            squareSum += (long) num *num;
        }
        xPlusY = (squareSum - sumOfSquaresOfFirstN)/ (xMinusY);
        int repeat = (int) (xPlusY+xMinusY)/2;
        int missing = (int)(xPlusY-repeat);
        return new int[]{repeat, missing};
    }
}
