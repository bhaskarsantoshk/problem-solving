package takeUForward.arrays;

import java.util.*;

public class P15IntersectionOfTwoSortedArrays {
    public int[] intersectionArrayBruteForce(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums1) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for ( int num: nums2) {
            if ( map.containsKey(num) && map.get(num) > 0){
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        int [] res = new int[list.size()];
        for ( int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersectionArrayBruteForce2(int[] nums1, int[] nums2) {
        // T: O(N*N)
        // S: O(N)
        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[n2];
        for ( int i=0; i<n1; i++){
            for ( int j=0; j<n2; j++){
                if ( nums1[i] == nums2[j] && !vis[j]){
                    list.add(nums2[j]);
                    vis[j] =true;
                    break;
                }
                if ( nums2[j] > nums1[i]) break;;
            }
        }
        int[] res = new int[list.size()];
        for ( int i=0; i<res.length; i++) res[i] = list.get(i);
        return res;
    }

    // Optimal
    // Two pointer
    // T:O(N), S:O(N)

    public int[] intersectionArray(int[] nums1, int[] nums2) {
        int i=0, j=0;
        List<Integer> list = new ArrayList<>();
        while ( i <nums1.length && j < nums2.length) {
            if ( nums1[i] == nums2[j]){
                list.add(nums2[j]);
                i++;
                j++;
            } else if ( nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] res = new int[list.size()];
        for ( int ind=0; ind<res.length; ind++) res[ind] = list.get(ind);
        return res;
    }
}
