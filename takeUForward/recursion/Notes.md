# Gist for Generating All Subsets (Power Set) Using Recursion

## Problem:
Given an array of integers `nums`, generate all possible subsets (the power set). A subset is a combination of elements that may include any number of elements from the array, including the empty set.

## Key Insight:
Use recursion to explore all possible subsets by deciding, at each step, whether to include or exclude the current element.

## Steps:

1. **Initialize Result List:**
    - **Why:** To store all the generated subsets.
    - **How:** Create an empty `List<List<Integer>>` named `res`.

2. **Recursive Subset Generation:**
    - **Why:** To explore all combinations of elements by deciding whether to include each element in the current subset.
    - **How:**
        - Use a recursive function `generate` that takes the current index `i`, a temporary list `list` to build the current subset, the result list `res`, and the input array `nums`.
        - **Base Case:** When the index `i` equals the length of `nums`, add the current subset to `res` and return.
        - **Include the current element:** Add `nums[i]` to `list`, recurse to the next element, and then backtrack by removing the last added element.
        - **Exclude the current element:** Recurse to the next element without adding the current element.

3. **Backtracking:**
    - **Why:** To ensure that each recursive call has the correct subset, backtrack after including an element by removing it from `list`.
    - **How:** Remove the last element using `list.remove(list.size() - 1)` after the recursive call that includes it.

4. **Return the Result:**
    - **Why:** After generating all possible subsets, return the result list `res`.
    - **How:** The result list `res` will contain all subsets after the recursive process completes.

## Example:

Consider the input array `nums = [1, 2, 3]`:

- The algorithm will generate the power set: `[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]`.

## Code Implementation:

```java
package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubSets {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate(0, new ArrayList<Integer>(), res, nums, nums.length);
        return res;
    }

    private void generate(int i, ArrayList<Integer> list, List<List<Integer>> res, int[] nums, int length) {
        if (i >= length) {
            res.add(new ArrayList<>(list)); // Do not just add list 
            return;
        }
        list.add(nums[i]);
        generate(i + 1, list, res, nums, length);
        list.remove(list.size() - 1); //list.removeLast();
        generate(i + 1, list, res, nums, length);
    }
}
```