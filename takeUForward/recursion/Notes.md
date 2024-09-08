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

### Key Points for Merge Sort Implementation

- **Recursive Split**: Divide the array recursively until each part has 1 element.

- **Mid Calculation**: `mid = low + (high - low) / 2`.

- **Merge Step**: Use two pointers (`left`, `right`) to merge sorted halves into a temporary list.

- **Handle Remaining**: Append any leftover elements from either half.

- **Copy Back**: Copy the merged list back to the original array.

### Key Points for Combination Sum Recursion Implementation

- **Base Case**: If `index >= n`, check if `target == 0`. If true, add the current list to the result.

- **Take the Element**: If `target >= candidates[index]`, add `candidates[index]` to the list and recursively call for the reduced target on the same index.
-  Do not increment the index here as we can use as many numbers as we want
- Do not forget to add >= ( not just >)

- **Backtrack**: After exploring, remove the last added element to backtrack.

- **Skip the Element**: Call the recursive function without including the current element (`index + 1`).

### Key Points for Combination Sum II Recursion Implementation

- **Sort the Array**: Sort `candidates` to easily skip duplicates later.

- **Base Case**: If `index == candidates.length` and `remain == 0`, add the current list to the result.

- - **Recusrive function** : Recusrive function will run from i = index  to n-1 ( Not a take /not take example)

- **Skip Duplicates**: Use `i != index && candidates[i] == candidates[i-1]` to avoid processing the same number in the same recursive level.

- **Take the Element**: If `remain >= candidates[i]`, add the element and recursively call for the reduced target.

- **Break Early**: Stop further exploration when `remain < candidates[i]` as subsequent numbers are larger.

* Don't mistake it for take / not take example
* Time complexity explanation -> if all numbers are unique , there will be 2^n subsequences , so T = o(2^n * k) , k is avg length of subseq

### Key Points for Subset Sum II Recursion Implementation

- **Base Case**: Add the current list to the result at each recursive step to capture all subsets.

- **Skip Duplicates**: Use `i != index && nums[i] == nums[i-1]` to skip duplicate elements in the same recursive level.

- **Take the Element**: Add `nums[i]` to the list and recursively call to explore further subsets.

- **Backtrack**: Remove the last element after each recursive call to backtrack and explore other subsets.