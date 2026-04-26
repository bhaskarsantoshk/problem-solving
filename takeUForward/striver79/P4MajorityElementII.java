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
}
