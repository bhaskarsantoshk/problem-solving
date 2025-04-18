package takeUForward.arrays;

import java.util.*;

public class P14UnionOfTwoSortedArrays {
    public int[] unionArrayBruteForce(int[] nums1, int[] nums2) {
        // unique elements - so set
        // add them to an array and sort
        // N log N ime , O(N) space
        Set<Integer> set = new HashSet<>();
        for ( int num: nums1) set.add(num);
        for ( int num: nums2) set.add(num);
        int[] res = new int[set.size()];
        int index =0;
        for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
            int t = it.next();
            res[index++] = t;
        }
        Arrays.sort(res);
        return res;
    }

    public int[] unionArray(int[] nums1, int[] nums2) {
        // Optimal
        // Try using merge sort technique and additional conditions
        // similarly do not add if merge[index]==merge[index-1]
        // T: o(n), S=O(n)

        int i = 0, j=0;
        List<Integer> list = new ArrayList<>();
        while ( i < nums1.length && j < nums2.length){
            if ( nums1[i] <= nums2[j]){
                if ( list.isEmpty() || list.getLast() != nums1[i] ) {
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if ( list.isEmpty() || list.getLast() != nums2[j] ) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }
        while ( i <nums1.length){
            if ( list.isEmpty() || list.getLast() != nums1[i] ) {
                list.add(nums1[i]);
            }
            i++;
        }
        while ( j <nums2.length){
            if ( list.isEmpty() || list.getLast() != nums2[j] ) {
                list.add(nums1[j]);
            }
            j++;
        }

        int[] res = new int[list.size()];
        for ( int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
