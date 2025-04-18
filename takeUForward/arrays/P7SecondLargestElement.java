package takeUForward.arrays;

public class P7SecondLargestElement {
    public int secondLargestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for ( int num: nums){
            max = Math.max( max, num);
        }
        for ( int num: nums){
            if ( num != max &&  num > max2 )max2 = num;
        }
        return max2 == Integer.MIN_VALUE ? -1: max2;
    }

    public int secondLargestElementOptimized(int[] nums) {
        int largest = nums[0];
        int secondLargest = Integer.MIN_VALUE;
        for ( int num: nums){
            if ( num > largest){
                secondLargest = largest;
                largest = num;
            } else if ( num != largest && num > secondLargest){
                secondLargest = num;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1: secondLargest;
    }

}
