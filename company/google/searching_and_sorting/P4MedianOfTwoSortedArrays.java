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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0, end = x;
        while ( start <= end ){
            int partitionX = (start+end)/2;
            int partitionY = ( x+y+1)/2 - partitionX;

            int maxLeftX = ( partitionX == 0) ?Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = ( partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = ( partitionY == 0) ? Integer.MIN_VALUE: nums2[partitionY-1];
            int minRightY = ( partitionY == y) ? Integer.MAX_VALUE: nums2[partitionY];

            if ( maxLeftX <= minRightY && maxLeftY <= minRightX){
                if ((x+y)%2 == 0 ){
                    return (Math.max(maxLeftX , maxLeftY) + Math.min( minRightX, minRightY))/2.0;
                }  else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if ( maxLeftX > minRightY){
                end = partitionX-1;
            } else{
                start = partitionX+1;
            }
        }
        return -1;
    }
}
