package data_structures.arrays;

public class Ceiling {
    public int ceiling (int[] nums, int key){
        if ( key > nums[nums.length-1]){
            return -1;
        }
        int start = 0, end = nums.length-1;
        int res = -1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( nums[mid] == key){
                return mid;
            }
            else if (nums[mid] < key ){
                start = mid+1;
            }
            else{
                res = mid;
                end = mid-1;
            }
        }
        return res;
    }
}
