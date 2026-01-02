package takeUForward.arrays.faqs;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int i = 0;
        int j= 0;
        int n = nums.length;
        int [] res = new int[nums.length];
        int index = 0;
        while ( i < n &&  j < n){
            while ( i < n && nums[i] < 0) i++;
            res[index++] = nums[i++];
            while ( j < n && nums[j] > 0) j++;
            res[index++] = nums[j++];
        }
        return res;
    }
}
