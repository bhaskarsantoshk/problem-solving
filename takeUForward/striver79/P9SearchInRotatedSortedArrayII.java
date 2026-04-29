package takeUForward.striver79;

public class P9SearchInRotatedSortedArrayII {
    public boolean searchInARotatedSortedArrayIIBruteForce(int[] nums, int k) {
        for ( int num: nums) if ( num == k) return true;
        return false;
    }


    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        int low = 0, high = nums.length-1;

        while ( low <= high){
            int mid = low + (high-low)/2;

            if ( nums[mid] == k) return true;
            // example where this may fail 3 1 2 3 3 3 3
            // in order to fix this
            if ( nums[low] ==  nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // left half sorted?
            if ( nums[low] <= nums[mid]){
                if ( nums[low] <= k && nums[mid] >= k){
                    high = mid-1;
                } else {
                    low = mid+1;
                }

                // right half sorted ?
            } else {
                if ( nums[mid] <= k && nums[high] >= k){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return false;
    }

    // nums = [7, 8, 1, 2, 3, 4, 5, 6], k = 3
    //

    // When there are no duplicates this works


    public boolean searchInARotatedSortedArray(int[] nums, int k) {
       int low = 0, high = nums.length-1;

       while ( low <= high){
           int mid = low + (high-low)/2;

           if ( nums[mid] == k) return true;
           // example where this may fail 3 1 2 3 3 3 3
           // in order to fix this
           if ( nums[low] ==  nums[mid] && nums[mid] == nums[high]) {
               low++;
               high--;
               continue;
           }

           // left half sorted?
           if ( nums[low] <= nums[mid]){
               if ( nums[low] <= k && nums[mid] >= k){
                   high = mid-1;
               } else {
                   low = mid+1;
               }

           // right half sorted ?
           } else {
               if ( nums[mid] <= k && nums[high] >= k){
                   low = mid+1;
               } else {
                   high = mid-1;
               }
           }
       }
       return false;
    }
}
