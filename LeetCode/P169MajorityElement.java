package LeetCode;

public class P169MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i=1;i<nums.length; i++){
            if(candidate == nums[i]){
                count++;
            }
            else{
                count--;
                if(count == 0){
                    candidate = nums[i];
                    count++;
                }
            }
        }
        count =0;
        for(int i=0;i<nums.length; i++){
            if(candidate == nums[i]){
                count++;
            }
        }
        return count > nums.length/2 ? candidate: -1;
    }
}
