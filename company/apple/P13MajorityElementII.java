package company.apple;

import java.util.ArrayList;
import java.util.List;

public class P13MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 =  -1, candidate2 = -1;
        int count1 = 0, count2= 0;

        for ( int num: nums){
            if ( count1 > 0 && count2 >0 ){
                if ( candidate1 != num && candidate2 != num){
                    count1--; count2--;
                } else if ( candidate1 == num) count1++;
                else count2++;
            } else if (count1 > 0){
                if ( candidate1 == num) count1++;
                else  {
                    candidate2 = num;
                    count2++;
                }
            } else if ( count2 > 0){
                if ( candidate2 == num) count2++;
                else {
                    candidate1 = num;
                    count1++;
                }
            } else{
                candidate1 = num;
                count1++;
            }
        }

        List<Integer> res = new ArrayList<>();

        count1 = count2 = 0;
        for (int i=0; i<nums.length; i++){
            if ( nums[i] == candidate1 ){
                count1++;
            }
            else if ( nums[i] == candidate2){
                count2++;
            }
        }

        if ( count1 > nums.length/3){
            res.add(candidate1);
        }
        if ( count2 > nums.length/3){
            res.add(candidate2);
        }
        return res;
    }
}
