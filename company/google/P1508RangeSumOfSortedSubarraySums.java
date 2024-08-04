package company.google;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class P1508RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for ( int i=0; i<nums.length; i++){
            int sum =0;
            for ( int j=i; j<nums.length; j++){
                sum = ((sum % 1000000007)+nums[i])%1000000007;
                list.add(sum);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        int sum =0;
        for ( int i=left-1; i<=right; i++){
            sum = ((sum % 1000000007)+list.get(i))%1000000007;
        }
        return sum;
    }

    public static void main(String[] args){
        P1508RangeSumOfSortedSubarraySums obj = new P1508RangeSumOfSortedSubarraySums();
        int [] arr = {1,2,3,4};
        System.out.println(obj.rangeSum(arr, 4, 1, 5));
    }
}
