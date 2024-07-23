package striver_sde_sheet.arrays;

public class P75SortColors {

    // Approach 1 -> sort the array , O(N long N ) time O (N) space, and do one pass

    // Approach 2 -> take 3 variables: count0, count1 and count2  - iterate over the array, update the vars
    // do one more iteration and update the array based on counts
    // T O(N) , S O(1)

    // Dutch National Flag Algorithm
    // Use 3 pointers, low, mid and end
    // 0- low-1 - 0s
    // low - mid-1 - 1s
    // mid to high random numbers unsorted
    // high+1 to n-1 - 2s
    // at the beginning
    // low = 0, mid = 0, high = n-1
    // all the above conditions match
    // iterate on mid
    // if a[mid] is 0 swap(a[low], a[mid]), mid++, low++
    // if a[mid] is 1 mid++
    // if a[mid] is 2 swap(a[mid], a[high]) high--
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;

        while ( mid <= high ){
            if ( nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if( nums[mid] == 1){
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
