package takeUForward.striver79;

import java.util.*;

public class P4MajorityElementII {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for ( int i=0; i<nums.length; i++){
            if ( list.isEmpty() || list.get(0) != nums[i]){
                int count = 0;
                for ( int j=0; j <nums.length; j++) if ( nums[i] == nums[j]) count++;
                if ( count > nums.length/3) list.add(nums[i]);
            }
            if ( list.size() == 2) break;
        }
        return list;
    }

    public List<Integer> majorityElementTwoBetter(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min = nums.length/3+1;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if ( entry.getValue() >= min) list.add(entry.getKey());
            if ( list.size() == 2) break;
        }
        Collections.sort(list);
        return list;
    }

    public List<Integer> majorityElementTwoOptimal(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0, count2=0;
        int element1 = 0, element2= 0;

        for ( int i=0; i<nums.length; i++){
            int ele = nums[i];
            if ( count1 == 0 && ele != element2){
                count1 = 1;
                element1 = ele;
            } else if ( count2 == 0  && ele != element1){
                count2 = 1;
                element2 = ele;
            } else if ( element1 == ele){
                count1++;
            } else if ( element2 == ele ){
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for ( int num: nums){
            if ( num == element1) count1++;
            else if ( num == element2) count2++;
        }
        if ( count1 > nums.length/3) list.add(element1);
        if ( count2 > nums.length/3) list.add(element2);
        Collections.sort(list);
        return list;
    }
}
