package company.google;

import java.util.*;

public class P184Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for ( int i=0; i<nums.length; i++){
            for ( int j=i+1; j<nums.length; j++){
                int start = j+1;
                int end = nums.length-1;

                while ( start < end){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[start]+ (long)nums[end];
                    if ( sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.addAll(List.of(nums[i], nums[j], nums[start], nums[end]));
                        if ( !set.contains(list)){
                            result.add(list);
                            set.add(list);
                        }
                        start++;
                        end--;
                    } else if ( sum > target){
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSumOptimized(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for ( int i=0; i<nums.length; i++){
            for ( int j=i+1; j<nums.length; j++){
                int start = j+1;
                int end = nums.length-1;

                while ( start < end){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[start]+ (long)nums[end];
                    if ( sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.addAll(List.of(nums[i], nums[j], nums[start], nums[end]));
                        result.add(list);
                        start++;
                        end--;
                        while ( start < end && nums[start] == nums[start-1]){
                            start++;
                        }
                        while ( start < end && nums[end] == nums[end+1]){
                            end--;
                        }
                    } else if ( sum > target){
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        P184Sum obj = new P184Sum();
        int [] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(obj.fourSum(nums, target));
    }
}
