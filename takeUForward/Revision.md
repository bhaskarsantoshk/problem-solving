## Backtracking
### Subsets with Duplicates
- **Goal**: Find all unique subsets of a set that may contain duplicates
- **Approach**:
    1. Sort the array to handle duplicates.
    2. Use backtracking to generate subsets.
    3. Skip adding duplicates by checking if the current element equals the previous one.

- **Time Complexity**: `O(2^n)` (generating all subsets)
- **Space Complexity**: `O(n)` (recursion stack)

```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);  // Sort to handle duplicates
    subsetsWithDup(0, nums, result, new ArrayList<Integer>());
    return result;
}

private void subsetsWithDup(int index, int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
    result.add(new ArrayList<>(list));

    for (int i = index; i < nums.length; i++) {
        if (i != index && nums[i] == nums[i - 1]) continue;  // Skip duplicates
        list.add(nums[i]);
        subsetsWithDup(i + 1, nums, result, list);
        list.remove(list.size() - 1);  // Backtrack
    }
}
```

## Backtracking
### Permutations
- **Goal**: Generate all possible permutations of the array
- **Approach**:
  1. Use backtracking to explore each permutation.
  2. Track used elements with a frequency array (`freq`).
  3. Add a permutation to the result when the current list matches the length of the input array.

- **Time Complexity**: `O(n * n!)` (generating and storing all permutations)
- **Space Complexity**: `O(n)` (recursion stack)

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int[] freq = new int[nums.length];
    permute(nums, result, freq, new ArrayList<Integer>());
    return result;
}

private void permute(int[] nums, List<List<Integer>> result, int[] freq, ArrayList<Integer> list) {
    if (list.size() == nums.length) {
        result.add(new ArrayList<>(list));  // Add valid permutation
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (freq[i] == 0) {  // Check if the element is already used
            freq[i] = 1;
            list.add(nums[i]);
            permute(nums, result, freq, list);
            freq[i] = 0;  // Backtrack
            list.remove(list.size() - 1);
        }
    }
}
```
### Key Points:
	•	Use freq array to track used numbers.
	•	Add permutation when list size equals nums.length.

## Backtracking
### Permutations (In-Place Swap)
- **Goal**: Generate all possible permutations of the array using in-place swapping.
- **Approach**:
  1. Use backtracking by swapping elements.
  2. Swap the current index with each subsequent element to explore all permutations.
  3. Backtrack by swapping back after recursive call.

- **Time Complexity**: `O(n * n!)` (generating and storing all permutations)
- **Space Complexity**: `O(n)` (recursion stack)

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute(0, nums, result);
    return result;
}

private void permute(int index, int[] nums, List<List<Integer>> result) {
    if (index == nums.length) {
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) temp.add(num);
        result.add(temp);  // Add permutation to result
        return;
    }

    for (int i = index; i < nums.length; i++) {
        swap(nums, i, index);  // Swap to generate new permutation
        permute(index + 1, nums, result);
        swap(nums, index, i);  // Backtrack by swapping back
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```
### Key Points:
	•	Use in-place swapping to generate permutations.
	•	Backtrack by swapping elements back after recursive call.