package takeUForward.striver79;

import java.util.*;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        int[] original = nums.clone();

        int[] tempArr = nums.clone();
        Arrays.sort(tempArr);
        permute(all, tempArr, 0);

       Collections.sort(all,
               (a,b)-> {
                   for (int i = 0; i < a.size(); i++) {
                       int cmp = Integer.compare(a.get(i), b.get(i));
                       if (cmp != 0) return cmp;
                   }
                   return 0;
               });

        List<Integer> cur = new ArrayList<>();
        for (int num : original) cur.add(num);

        int pos = -1;
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(cur)) {
                pos = i; // keep updating → last occurrence
            }
        }

        int nextIndex = (pos == all.size() - 1) ? 0 : pos + 1;

        for (int j = 0; j < nums.length; j++) {
            nums[j] = all.get(nextIndex).get(j);
        }
    }

    private void permute(List<List<Integer>> all, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            all.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(all, nums, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutationOptimized(int[] nums) {
        // find break point
        // 4 3 2 8 9 7 6 5 4 3 2 1
        int index = -1;
        int n = nums.length;
        for ( int i=n-2; i>=0; i--){
            if ( nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        if ( index == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        for ( int i=n-1; i>=index; i--){
            if ( nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index+1, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
