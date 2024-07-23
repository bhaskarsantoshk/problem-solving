package company.google.arrays;

public class P31NextPermutation {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        for ( int i= nums.length-2; i>=0; i--){
            if ( nums[i] < nums[i+1]){
                breakPoint = i;
                break;
            }
        }

        if ( breakPoint == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        for ( int i=nums.length-1; i>=0; i--){
            if ( nums[i] > nums[breakPoint]){
                int temp = nums[i];
                nums[i] = nums[breakPoint];
                nums[breakPoint] = temp;
                break;
            }
        }
        reverse(nums, breakPoint+1, nums.length-1);
    }

    private void reverse(int a[], int start, int end){
        while ( start < end){
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }
}
