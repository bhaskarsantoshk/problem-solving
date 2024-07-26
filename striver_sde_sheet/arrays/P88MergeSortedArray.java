package striver_sde_sheet.arrays;

public class P88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( nums1 == null || nums2 == null ) return;
        if ( nums1.length < nums2.length ){
            merge(nums2, n, nums1, m);
        }
        int i = m-1, j = n-1, mergeIndex = m+n-1;
        while ( i >= 0 && j >= 0){
            if ( nums1[i] >= nums2[j]){
                nums1[mergeIndex] = nums1[i--];
            } else {
                nums1[mergeIndex] = nums2[j--];
            }
            mergeIndex--;
        }

        while ( j >= 0){
            nums1[mergeIndex--] = nums2[j--];
        }
    }
}
