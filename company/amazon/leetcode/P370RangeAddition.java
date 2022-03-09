package company.amazon.leetcode;

public class P370RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] res = new int[length];
        for ( int[] update : updates ){
            res[update[0]] += update[2];
            if ( update[1]+1 < length ){
                res[update[1]+1] -= update[2];
            }
        }
        for ( int i=1; i<length; i++){
            res[i] += res[i-1];
        }
        return res;
    }
}

/**
 * https://leetcode.com/problems/range-addition/discuss/84225/Detailed-explanation-if-you-don't-understand-especially-%22put-negative-inc-at-endIndex%2B1%22
 * Put inc at startIndex allows the inc to be carried to the next index starting from startIndex when we do the sum accumulation.
 * Put -inc at endIndex + 1 simply means cancel out the previous carry from the next index of the endIndex, because the previous carry should not be counted beyond endIndex.
 * And finally, because each of the update operation is independent and the list operation is just an accumulation of the "marks" we do, so it can be "makred" all at once first and do the range sum at one time at last step.
 */
