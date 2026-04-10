package takeUForward.striver79;

import java.util.*;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        int[] original = nums.clone();

        int[] tempArr = nums.clone();
        Arrays.sort(tempArr);
        permute(all, tempArr, 0);

        Set<List<Integer>> set = new LinkedHashSet<>(all);
        all = new ArrayList<>(set);

        // enforce lexicographic order
        Collections.sort(all, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        List<Integer> cur = new ArrayList<>();
        for (int num : original) cur.add(num);

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(cur)) {
                int nextIndex = (i == all.size() - 1) ? 0 : i + 1;

                for (int j = 0; j < nums.length; j++) {
                    nums[j] = all.get(nextIndex).get(j);
                }
                return;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            nums[j] = all.get(0).get(j);
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
}
