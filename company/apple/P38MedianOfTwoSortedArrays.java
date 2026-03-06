package company.apple;

public class P38MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = nums1.length;
        while ( low <= high){
            int mid1 = (low+high)>>1;
            int mid2= (nums1.length+nums2.length+1)/2-mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2=Integer.MAX_VALUE;

            if ( mid1-1 >= 0) l1 = nums1[mid1-1];
            if ( mid2-1 >= 0) l2 = nums2[mid2-1];
            if ( mid1 < nums1.length) r1 = nums1[mid1];
            if ( mid2 <nums2.length) r2 = nums2[mid2];

            if ( l1<=r2 && l2 <=r1){
                if (( nums1.length + nums2.length)%2 == 0 ){
                    return (double)((double) Math.max(l1, l2) + (double) Math.min(r1, r2))/2.0;
                } else {
                    return Math.max(l1,l2);
                }
            } else if ( l1 > r2){
                high = mid1-1;
            } else {
                low = mid1+1;
            }

        }
        return 0;
    }
}
