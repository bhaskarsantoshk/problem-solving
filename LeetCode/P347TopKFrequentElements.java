package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        List<Integer> frequencyBucket[] = new List[nums.length+1];
        for(int key: map.keySet()){
            int frequency = map.get(key);
            if(frequencyBucket[frequency] == null){
                frequencyBucket[frequency] = new ArrayList<>();
            }
            frequencyBucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=frequencyBucket.length-1; i>=0 && res.size() <k; i--){
            if(frequencyBucket[i] != null){
                res.addAll(frequencyBucket[i]);
            }
        }
        return res;
    }
}
