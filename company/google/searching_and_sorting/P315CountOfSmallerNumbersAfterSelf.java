package company.google.searching_and_sorting;

import java.util.ArrayList;
import java.util.List;

public class P315CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmallerBruteForce(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for ( int i=0; i<nums.length; i++){
            for ( int j=i+1; j<nums.length; j++){
                if ( nums[j]  < nums[i]){
                    res.add(nums[j]);
                }
            }
        }
        return res;
    }


    class Pair{
        int val;
        int index;

        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if ( nums == null || nums.length == 0) return res;
        Pair[] newNums = new Pair[n];
        for ( int i=0; i<n; i++) newNums[i]=new Pair(nums[i], i);
        int[] result = new int[n];
        mergeSortAndCount( newNums, 0, n-1, result);
        List<Integer> resultList = new ArrayList<>();
        for (int i : result) resultList.add(i);
        return resultList;
    }

    private void mergeSortAndCount(Pair[] nums, int start, int end, int[] result) {
        if ( start >= end) return;
        int mid = (start + end)/2;
        mergeSortAndCount(nums, start, mid, result);
        mergeSortAndCount(nums, mid+1, end, result);

        int leftPos = start;
        int rightPos = mid+1;
        List<Pair> merged = new ArrayList<>();
        int numOfElementsInRightArrayLessThanLeft = 0;
        while ( leftPos < mid+1 && rightPos <= end ) {
            if ( nums[leftPos].val > nums[rightPos].val){
                ++numOfElementsInRightArrayLessThanLeft;
                merged.add(nums[rightPos]);
                ++rightPos;
            } else{
                result[nums[leftPos].index]+= numOfElementsInRightArrayLessThanLeft;
                merged.add(nums[leftPos]);
                ++leftPos;
            }
        }

        while (leftPos < mid + 1) {
            result[nums[leftPos].index] += numOfElementsInRightArrayLessThanLeft;

            merged.add(nums[leftPos]);
            ++leftPos;
        }
        while (rightPos <= end) {
            merged.add(nums[rightPos]);
            ++rightPos;
        }
        // part of normal merge sort
        // copy back merged result into array
        int pos = start;
        for (Pair m : merged) {
            nums[pos] = m;
            ++pos;
        }
    }
}
