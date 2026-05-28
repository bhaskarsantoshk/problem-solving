package company.google.version2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class P4MedianOfTwoSortedArrays {
    public double findMedianSortedArraysNaive(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for ( int num: nums1) list.add(num);
        for ( int num: nums2) list.add(num);
        Collections.sort(list);
        int mid = list.size()/2;
        if ( list.size() % 2 == 0){
            return (double) ((double)list.get(mid)+(double) list.get(mid+1))/2.0;
        }
        return list.get(mid);
    }

    public double findMedianSortedArraysLinear(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j=0;
        int total = n+m;
        int cur = 0, prev = 0;
        for ( int count =0; count < total/2; count++){
            prev = cur;
            if ( i < n && j < m){
                if ( nums1[i] < nums2[j]){
                    cur = nums1[i++];
                } else {
                    cur = nums2[j++];
                }
            } else if ( i < n ){
                cur = nums1[i++];
            } else if ( j < m) {
                cur = nums2[j++];
            }
        }

        return (total%2==0) ? (double)(prev+cur)/2.0 : (double)cur;
    }
}
