package express_prep.amzn.top_voted;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1.length > nums2.length ){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int start = 0, end = x;
        while ( start <= end ){
            int partitionX = (start+end)/2;
            int partitionY = ( x+y+1)/2 - partitionX;
            int maxLeftX = ( partitionX == 0 ) ? Integer.MIN_VALUE: nums1[partitionX-1];
            int minRightX= ( partitionX == x ) ? Integer.MAX_VALUE: nums1[partitionX];
            int maxLeftY = ( partitionY == 0 ) ? Integer.MIN_VALUE: nums2[partitionY-1];
            int minRightY= ( partitionY == y ) ? Integer.MAX_VALUE: nums2[partitionY];

            if ( maxLeftX <= minRightY && maxLeftY <= minRightX ){
                if ( (x+y) % 2 == 0 ) {
                    return ( Math.max (maxLeftX, maxLeftY) + Math.min( minRightX, minRightY)) / 2.0;
                } else {
                    return (Math.max (maxLeftX, maxLeftY));
                }
            } else if (maxLeftX > minRightY){
                end = partitionX-1;
            } else {
                start = partitionX+1;
            }
        }
        return -1;
    }
}
