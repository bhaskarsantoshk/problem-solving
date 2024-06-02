class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        while ( mid <= high ){
            if ( nums[mid] == 0){
                // swap low and mid
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            } else if ( nums[mid] == 1 ){
                mid++;
            } else {
                // swap mid and high
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }
}
