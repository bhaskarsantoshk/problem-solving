package striver_sde_sheet.arrays;

public class P645SetMismatch {
    public int[] findErrorNums(int[] nums) {
        // repeat = x, missing = y
        int xXORy = 0; // result of xor of all nums in array and [1..n]
        for ( int i=0; i<nums.length; i++){
            xXORy ^= nums[i];
            xXORy ^= (i+1);
        }

        int differentiatingBit = 0;
        while ( (xXORy & (1 << differentiatingBit)) == 0) differentiatingBit++;

        // both repeat and missing number differ with the differentiatingBit
        // we can divide all numbers into two groups based on differentiatingBit
        // repeat appears 3 times , missing appear one time
        // rest appear twice in respective groups
        int zeroGroup=0, oneGroup =0;
        for ( int i=0; i<nums.length; i++){
            if ( (nums[i] & (1<<differentiatingBit)) == 0 ) zeroGroup ^= nums[i];
            else oneGroup ^= nums[i];

            if ( ( (i+1) & (1 << differentiatingBit)) == 0 ) zeroGroup ^= (i+1);
            else oneGroup ^= (i+1);
        }

        int count =0;
        int repeat = -1, missing =-1;
        for ( int i=0; i<nums.length; i++){
            if ( zeroGroup == nums[i]) count++;
            if ( count == 2){
                break;
            }
        }
        if (count == 2){
            missing = oneGroup;
            repeat = zeroGroup;
        } else {
            missing = zeroGroup;
            repeat = oneGroup;
        }
        return new int[]{repeat, missing};
    }
}
