package codingNinjas;

import java.util.Arrays;

public class SortOddEven {
    public static void sortOddEven(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] res = new int[n];
        int index = 0;
        for ( int i=n-1; i>=0; i--){
            if ( nums[i] % 2 == 1){
                res[index++] = nums[i];
            }
        }
        for ( int i=0; i<n; i++){
            if ( nums[i] % 2 == 0){
                res[index++] = nums[i];
            }
        }
        for ( int i=0; i<n; i++){
            nums[i] = res[i];
        }
    }
}
