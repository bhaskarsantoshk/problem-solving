package LeetCode;

public class P1313DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i=0; i<nums.length; i+=2){
            len += nums[i];
        }

        int res[] = new int[len];

        int rIndex = 0, nIndex = 0;

        while ( rIndex < len ){
            int l = nums[nIndex];
            int num = nums[nIndex+1];

            while ( l-- != 0){
                res[rIndex++] = num;
            }

            nIndex+= 2;
        }

        return res;
    }
}
