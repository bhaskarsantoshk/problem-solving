package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P1389CreateTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        int target[] = new int[nums.length];
        List<Integer> temp = new ArrayList<>();
        for ( int i=0; i<nums.length; i++){
            temp.add(index[i], nums[i]);
        }
        int i = 0;
        for ( int num: temp){
            target[i++] = num;
        }
        return target;
    }
}
