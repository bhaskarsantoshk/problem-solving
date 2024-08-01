package company.google.searching_and_sorting;

public class P4MedianOfTwoSortedArrays {
    public double findMedianSortedArraysNaive(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length];
        int left = 0, right = 0, mergedIndex = 0;
        while ( left < nums1.length && right < nums2.length ){
            if ( nums1[left] <= nums2[right]){
                merged[mergedIndex++] = nums1[left++];
            } else {
                merged[mergedIndex++] = nums2[right++];
            }
        }
        while ( left < nums1.length){
            merged[mergedIndex++] = nums1[left++];
        }
        while ( right < nums2.length){
            merged[mergedIndex++] = nums2[right++];
        }
        if ( merged.length % 2 != 0){
            return (double) merged[merged.length/2];
        } else {
            return (double) ( merged[merged.length/2] + merged[merged.length/2 + 1])/2;
        }
    }
}
