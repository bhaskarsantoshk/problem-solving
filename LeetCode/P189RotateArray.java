package LeetCode;

public class P189RotateArray {
    public void rotate(int[] nums, int k) {
        int len= nums.length-1;
        k = k % (len+1);
        reverse(nums, 0, len);
        reverse(nums, 0, k-1);
        reverse(nums, k, len);
    }

    public void reverse(int[] a, int start, int end){
        while(start < end){
            int temp= a[start];
            a[start]= a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
