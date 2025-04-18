package takeUForward.arrays;

import java.util.ArrayList;
import java.util.List;

public class P11MoveZerosToEnd {
    public void moveZeroesBruteForce(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for ( int num: nums) {
            if (num != 0) list.add(num);
        }
        for ( int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }
        for ( int i=list.size(); i<n; i++) nums[i] = 0;
    }

    public void moveZeroes(int[] nums) {
        // somehow we are trying to move non-zero elements to front
        // while iterating - we can use two pointer
        // use i for iterating and index for moving non-zero element
        int index = 0;
        int n = nums.length;
        for ( int i=0; i<n; i++){
            if ( nums[i] != 0) nums[index++] = nums[i];
        }
        for ( int i=index; i<n; i++){
            nums[i] = 0;
        }
    }
}
