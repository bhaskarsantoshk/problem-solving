package takeUForward.arrays;

public class P10LeftRotateArrayByKPlaces {
    public void rotateArrayBruteForce(int[] nums, int k) {
        int[] temp = new int[k];
        int n = nums.length;
        k = k%n;
        for ( int i=0; i<k; i++){
            temp[i]= nums[i];
        }
        for ( int i=k; i<n; i++){
            nums[i-k] = nums[i];
        }
        // n-k + k ( n-1, n-k)
        for ( int i= n-k; i<n; i++){
            nums[i] = temp[i-(n-k)];
        }

    }

    public void rotateArray(int[] nums, int k) {
        // 1 2 3 4 5 6 7, k =3
        // 4 5 6 7 1 2 3
        // from observation
        // if we reverse
        // 7 6 5 4 3 2 1
        // reverse n-k & then last k
        // 4 5 6 7 1 2 3

        // or we can reverse first k [0,k-1] + reverse rest [k,n-1]
        // now reverse the whole array[0,n-1]

        // we will go with approach 2
        int n = nums.length;
        k = k%n;
        reverse ( nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while ( left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
