package LeetCode.explore.top_interview_questions.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                al.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int res[]= new int[al.size()];
        for(int i=0; i< res.length; i++){
            res[i]=al.get(i);
        }
        return res;
    }
}
