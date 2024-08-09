# Unique Email Addresses GIST

1. Split the email based on `@`.
2. Take `parts[0]` and split it based on `\\+`.
3. Call it `username` and replace `.` with `""`.
4. Combine `username` with `parts[1]`.
5. Add the result to a set.

Example:
- Input: "test.email+alex@google.com"
- Split: "test.email" and "google.com"
- Process: "test.email" -> "test" (after `+` and `.` removal)
- Combine: "test@leetcode.com"
- Add to set

# License Key Formatting GIST

1. Initialize a `StringBuilder` to build the result.
2. Set `count` to 0 and `index` to the last character of the string.
3. Loop while `count` is less than `k` and `index` is non-negative:
    - Get the character at `index`.
    - Decrement `index`.
    - Skip if the character is `-`.
    - Append the uppercase character to `StringBuilder`.
    - Increment `count`.
    - If `count` equals `k`, append `-` and reset `count`.
4. If `StringBuilder` ends with `-`, remove it.
5. Return the reverse of the `StringBuilder` as a string.

## Example:

Input: `s = "5F3Z-2e-9-w"`, `k = 4`

- Process:
    - Initialize `sb = ""`, `count = 0`, `index = 11`
    - Append 'W', '9', 'E', '2', append '-'
    - Append 'Z', '3', 'F', '5'
- Final Result: `"5F3Z-2E9W"`

# Length of Longest Substring Without Repeating Characters GIST

1. Initialize `left` pointer to 0 and `maxLen` to 0.
2. Use a `Map` to store the count of characters in the current window.
3. Iterate over the string with `right` pointer:
    - Get the character at `right`.
    - Increment its count in the map.
    - If the character count is greater than 1, move the `left` pointer to reduce the count:
        - Decrement the count of the character at `left`.
        - Move `left` pointer.
    - Update `maxLen` with the length of the current window.
4. Return `maxLen`.

## Example:

Input: `s = "pwwkew"`

- Process:
    - Initialize `left = 0`, `maxLen = 0`
    - Iterate over `s`:
        - 'p' -> map = {p:1}, maxLen = 1
        - 'w' -> map = {p:1, w:1}, maxLen = 2
        - 'w' -> map = {p:1, w:2}, move left to remove one 'w'
        - 'k' -> map = {p:0, w:1, k:1}, maxLen = 2
        - 'e' -> map = {w:1, k:1, e:1}, maxLen = 3
        - 'w' -> map = {w:2, k:1, e:1}, move left to remove one 'w'

Final `maxLen`: `3` (substring "wke")

# Total Fruit GIST

1. **Check for Empty Input**: Return 0 if `fruits` array is null or empty.
2. **Initialize Pointers and Variables**:
    - `left` pointer to 0
    - `count` of unique fruit types to 0
    - `maxLen` to store the maximum length of the subarray
    - `map` to store the count of each fruit type
3. **Iterate Over the Array with `right` Pointer**:
    - If the fruit type is already in the map, increment its count.
    - If the fruit type is new, increment the `count` of unique fruit types and add it to the map.
4. **Adjust `left` Pointer**:
    - While the `count` of unique fruit types exceeds 2, decrement the count of the fruit type at `left` and move `left` pointer.
    - If the count of a fruit type becomes 0, remove it from the map and decrement `count`.
5. **Update `maxLen`** with the length of the current valid subarray.
6. **Return `maxLen`.

## Example:

Input: `fruits = [1, 2, 1, 2, 3, 3]`

- Process:
    - Initialize `left = 0`, `count = 0`, `maxLen = 0`
    - Iterate over `fruits`:
        - Add fruit `1`, map = {1: 1}, count = 1, maxLen = 1
        - Add fruit `2`, map = {1: 1, 2: 1}, count = 2, maxLen = 2
        - Add fruit `1`, map = {1: 2, 2: 1}, maxLen = 3
        - Add fruit `2`, map = {1: 2, 2: 2}, maxLen = 4
        - Add fruit `3`, map = {1: 2, 2: 2, 3: 1}, count = 3, adjust `left`
        - Remove fruit `1`, map = {1: 1, 2: 2, 3: 1}, adjust `left`
        - Remove fruit `1`, map = {2: 2, 3: 1}, count = 2, `left = 2`, maxLen = 4
        - Add fruit `3`, map = {2: 2, 3: 2}, maxLen = 4

Final `maxLen`: `4` (subarrays [1, 2, 1, 2] or [2, 1, 2, 3])

# Odd Even Jumps GIST

1. **Initialize Variables**:
    - `goodStartingIndex` to 1 (count the last index as a good starting point).
    - `n` as the length of the array.
    - `higher` and `lower` boolean arrays to track if you can jump to a good index.
    - `TreeMap` to keep track of the indices and their values for finding next jumps.

2. **Set the Last Element**:
    - The last element is always a good starting point for both higher and lower jumps.

3. **Iterate from Second Last to First Element**:
    - Use `TreeMap` to find the next higher (`ceilingEntry`) and lower (`floorEntry`) entries for the current element.
    - Update the `higher` and `lower` arrays based on the found entries.
    - If `higher[i]` is true, increment `goodStartingIndex`.
    - Update the `TreeMap` with the current element and index.

4. **Return the Count of Good Starting Indices**.

## Example:

Input: `arr = [10, 13, 12, 14, 15]`

- Process:
    - Initialize `higher` and `lower` arrays with `true` for the last element.
    - Use `TreeMap` to find next higher and lower indices:
        - For element `14`, find higher and lower entries.
        - Update `higher` and `lower` arrays.
        - Increment `goodStartingIndex` if `higher[i]` is true.
        - Add current element and index to `TreeMap`.

Final `goodStartingIndex`: `2`

## maxProduct

### Gist
1. **Purpose**: Find the maximum product of a contiguous subarray within an array of integers.
2. **Handling Different Cases**:
    - **All Positive Numbers**: The final prefix and suffix products are equal to the maximum product.
    - **Even Negative Numbers**: Similar to all positive numbers, the final prefix and suffix products are equal to the maximum product.
    - **Odd Negative Numbers**: The maximum product lies either on the left or right side of the odd negative number.
    - **Zeros**: The maximum product is found in one of the subarray products that exclude zeros.
3. **Process**:
    - Initialize `prefix` and `suffix` products to 1 and `max` to the minimum integer value.
    - Iterate through the array:
        - Reset `prefix` and `suffix` to 1 if they become zero.
        - Check for potential overflow in `prefix` and `suffix`.
        - Update `prefix` and `suffix` products.
        - Update `max` with the maximum value between `prefix` and `suffix`.
4. **Result**: Return the maximum product found during the iteration.

### Photo Iterator

**Problem**: Iterate through a list of photos, returning favorites first and then remaining photos, avoiding duplicates.

**Solution**: Use two iterators (one for favorites, one for photos) and a `HashSet` to track seen elements.

**Optimized**: For sorted input, use two pointers to traverse both lists directly, avoiding extra space.

**Java Example**: PhotoIterator class

# Solution to Find the Minimum Area of a Rectangle from Points

## Approach:

1. **Mapping Points:**
    - Use a `HashMap` to map x-coordinates to sets of y-coordinates. This helps in quickly checking if a point with specific coordinates exists.

2. **Iterating Through Points:**
    - Iterate through all pairs of points to determine potential rectangles. For a pair of points `(p1, p2)` to form a diagonal of a rectangle, they must have different x and y coordinates.
    - Check if the other two corners `(p1[0], p2[1])` and `(p2[0], p1[1])` exist using the hash map.

3. **Calculating Area:**
    - If the points form a rectangle, calculate its area and update the minimum area found.

4. **Edge Case:**
    - If no rectangle is found, return 0.

# Solution to Find the Secret Word

## Approach:

1. **Random Selection:**
    - Use a `Random` object to randomly select a word from the list of possible words.

2. **Initialization:**
    - Initialize an `ArrayList` to store the possible words from the given wordlist.

3. **Guessing Loop:**
    - Set a maximum of 10 trials for guessing.
    - In each trial, select a random word from the list of possible words and use the `master.guess` method to get the number of matches.
    - If the number of matches is 6, the secret word is found, and the method returns.

4. **Filtering Possible Words:**
    - If the guessed word does not match the secret word, filter the list of possible words to only include words that have the same number of matches with the guessed word.
    - Update the list of possible words and continue the guessing process.

5. **Helper Method:**
    - A helper method `countMatches` is used to count the number of matching characters between two words.

# Solution to Determine if One String Can Transform into Another

## Approach:

1. **Index Initialization:**
    - Initialize two indices, `i` and `j`, to 0. These will be used to traverse the `start` and `end` strings respectively.

2. **Traversing Strings:**
    - Use a `while` loop to traverse both strings until the end of either string is reached.
    - Skip all 'X' characters in both strings using nested `while` loops.

3. **Character Comparison:**
    - After skipping 'X' characters, compare the characters at indices `i` and `j` in the `start` and `end` strings.
    - If the characters are not the same, return `false`.
    - If the character is 'L', ensure that it does not move to the right (`i` must be greater than or equal to `j`).
    - If the character is 'R', ensure that it does not move to the left (`i` must be less than or equal to `j`).

4. **Increment Indices:**
    - Increment both indices `i` and `j` to continue traversing the strings.

5. **Final Check:**
    - Return `true` if both indices have reached the end of their respective strings simultaneously, indicating a valid transformation.

# Solution to Count the Number of Jewels in Stones

## Approach:

1. **Frequency Array Initialization:**
    - Initialize an array `a` of size 128 to store the frequency of characters. This size is chosen because it covers all ASCII characters.

2. **Marking Jewels:**
    - Iterate through each character in the `jewels` string and increment the corresponding position in the array `a`.

3. **Counting Jewels in Stones:**
    - Initialize a counter `count` to zero.
    - Iterate through each character in the `stones` string. For each character, check if it is marked as a jewel in the array `a`.
    - If it is, increment the `count`.

4. **Returning the Result:**
    - Return the final value of `count`, which represents the number of jewels found in the `stones`.

# Solution for MyCalendarTwo to Allow Double Bookings

## Approach:

1. **TreeMap Initialization:**
    - Use a `TreeMap` to store the start and end times of bookings. This will help in efficiently managing and querying the intervals.

2. **Booking Method:**
    - When a new booking is requested, increment the value at the `start` time and decrement the value at the `end` time in the `TreeMap`.
    - Traverse the `TreeMap` to calculate the cumulative count of bookings at any given time.
    - If the cumulative count exceeds 2 at any point, revert the changes made to the `TreeMap` and return `false`, indicating the booking cannot be made as it would cause a triple booking.
    - If the traversal completes without exceeding a count of 2, return `true`, indicating the booking is successful.

3. **Reverting Changes:**
    - If a triple booking is detected, decrement the value at the `start` time and increment the value at the `end` time to revert the changes made during the booking attempt.
    - Remove the entry from the `TreeMap` if the value becomes 0 after reversion.

# Solution for LRUCache Implementation

## Approach:

1. **Node Class:**
    - Define a `Node` class to represent each entry in the cache. Each node contains a `key`, `val`, and pointers to the previous and next nodes.

2. **Initialize LRUCache:**
    - Initialize the `LRUCache` with a given capacity.
    - Create a dummy `head` and `tail` node to facilitate easy addition and removal of nodes.
    - Initialize a `HashMap` to store the cache entries with their keys and corresponding nodes.

3. **Get Method:**
    - Check if the key exists in the cache. If it does, retrieve the corresponding node.
    - Move the accessed node to the head of the linked list to mark it as most recently used.
    - Return the value of the node. If the key does not exist, return -1.

4. **Put Method:**
    - If the key already exists in the cache, delete the existing node.
    - If the cache is at capacity, remove the least recently used node, which is located just before the `tail`.
    - Insert the new node at the head of the linked list to mark it as most recently used.

5. **Delete Method:**
    - Remove the node from the linked list and the cache map.
    - Update the pointers of the previous and next nodes to bypass the deleted node.

6. **Insert Method:**
    - Add the node to the head of the linked list.
    - Update the pointers to insert the node correctly.
    - Add the node to the cache map.

# Solution for MinStack Implementation

## Approach:

1. **Node Class:**
    - Define a `Node` class to represent each entry in the stack. Each node contains a `val`, the current `min` value, and a pointer to the `next` node.

2. **MinStack Initialization:**
    - Initialize the `MinStack` with a `head` pointer that will point to the top of the stack.

3. **Push Method:**
    - When a value is pushed onto the stack, create a new `Node` with the value, the minimum of the current value and the current minimum (if the stack is not empty), and the current head of the stack as the next node.
    - Update the `head` to point to the new node.

4. **Pop Method:**
    - Remove the top node from the stack by updating the `head` to point to the next node.
    - Throw an exception if the stack is empty.

5. **Top Method:**
    - Return the value of the top node of the stack.
    - Throw an exception if the stack is empty.

6. **GetMin Method:**
    - Return the minimum value stored in the top node of the stack.
    - Throw an exception if the stack is empty.
# Solution for Serializing and Deserializing a Binary Tree

## Approach:

1. **Serialization:**
    - Convert the binary tree into a single string using preorder traversal.
    - Use a `StringBuilder` to construct the serialized string.
    - For each node, append its value followed by a delimiter (`,`).
    - Use a special character (`#`) to represent `null` nodes.
    - Recursively build the string for the left and right subtrees.

2. **Deserialization:**
    - Convert the serialized string back into a binary tree.
    - Split the string by the delimiter to get a queue of node values.
    - Use a queue to facilitate reconstructing the tree in the same order as it was serialized.
    - Recursively build the tree by dequeuing values and creating nodes. If a `nullPointer` (`#`) is encountered, return `null`.

# Solution for Logger Rate Limiter

## Approach:

1. **Initialization:**
    - Use a `HashMap` to store the messages and their corresponding timestamps.

2. **shouldPrintMessage Method:**
    - Check if the message already exists in the log.
    - If it does, calculate the difference between the current timestamp and the stored timestamp.
        - If the difference is less than 10 seconds, return `false` indicating the message should not be printed.
        - If the difference is 10 seconds or more, update the timestamp for the message and return `true`.
    - If the message does not exist in the log, add it with the current timestamp and return `true`.

# Solution for Randomized Set

## Approach:

1. **Initialization:**
   - **Why:** We need a data structure that allows for constant-time insertions, deletions, and random access. Using a `HashMap` (`indexMap`) to store the value and its corresponding index in the list allows for efficient lookups. An `ArrayList` is used to store the values, which supports efficient random access and appending/removing elements from the end. A `Random` object is used to generate random indices.
   - **How:** Initialize the `HashMap`, `ArrayList`, and `Random` object in the constructor.

2. **Insert Method:**
   - **Why:** We need to ensure that each value is unique in the set. Checking if the value already exists helps prevent duplicates.
   - **How:** Check if the value already exists in the `indexMap`. If it does, return `false`. If the value does not exist, add it to the `list` and update the `indexMap` with the value and its index. Return `true` indicating the insertion was successful.

3. **Remove Method:**
   - **Why:** Efficient removal is needed, and the trick is to avoid shifting elements in the list. By replacing the value to be removed with the last element in the list, we can achieve constant-time removal.
   - **How:** Check if the value exists in the `indexMap`. If it does not, return `false`. If the value exists, retrieve its index and the last element in the `list`. Replace the value to be removed with the last element in the `list`. Update the `indexMap` for the last element with its new index. Remove the last element from the `list` and remove the value from the `indexMap`. Return `true` indicating the removal was successful.

4. **GetRandom Method:**
   - **Why:** We need to provide a way to get a random element from the set in constant time. The `ArrayList` allows for efficient random access.
   - **How:** Generate a random index using the `Random` object and return the value at that index from the `list`.

# Solution for Finding the Longest Palindromic Substring

## Approach:

1. **Initial Checks:**
   - **Why:** To handle edge cases where the input string is either null or too short to have a meaningful palindrome.
   - **How:** If the input string `s` is null or its length is less than 2, return the string itself.

2. **Result Class:**
   - **Why:** To store the start index and length of the longest palindromic substring found during the process.
   - **How:** Define an inner class `Result` with fields `start` and `len`, and initialize them appropriately.

3. **Expand Around Center:**
   - **Why:** To find the longest palindromic substring by expanding around each possible center. This method ensures that both odd and even length palindromes are considered.
   - **How:** Loop through each character in the string and for each character, expand around it as a single center (for odd length palindromes) and as a pair of centers (for even length palindromes). Use the helper method `expandPalindrome` to perform the expansion and update the result if a longer palindrome is found.

4. **Helper Method `expandPalindrome`:**
   - **Why:** To expand the palindrome around the given left and right indices and update the result if a longer palindrome is found.
   - **How:** Expand while the characters at the left and right indices are equal and within bounds. After expansion, check if the current length of the palindrome is greater than the previously recorded length and update the result accordingly.


# Solution for Finding the Maximum Subarray Sum

## Approach:

1. **Initial Setup:**
   - **Why:** Initialize variables to keep track of the current sum of the subarray and the maximum sum found so far.
   - **How:** Set both `sum` and `max` to the first element of the array. This handles the edge case where the array has only one element.

2. **Iterate Through the Array:**
   - **Why:** To find the maximum subarray sum, iterate through the array starting from the second element.
   - **How:** Use a `for` loop starting from index 1.

3. **Update Current Sum:**
   - **Why:** At each step, decide whether to add the current element to the existing sum or start a new subarray from the current element. This ensures that the subarray sum remains as large as possible.
   - **How:** Use `Math.max(sum + nums[i], nums[i])` to update the `sum`. This chooses the larger value between continuing with the current subarray or starting a new subarray at the current element.

4. **Update Maximum Sum:**
   - **Why:** Keep track of the maximum sum encountered so far.
   - **How:** Use `Math.max(max, sum)` to update the `max` if the current `sum` is greater than the previous `max`.

5. **Return the Result:**
   - **Why:** The variable `max` will hold the maximum subarray sum after iterating through the array.
   - **How:** Return the value of `max`.


# Solution for Finding the Maximum Profit from Stock Prices

## Approach:

1. **Initial Checks:**
   - **Why:** Handle edge cases where the input array is null or empty.
   - **How:** Return 0 if the input array `prices` is null or has a length of 0.

2. **Variable Initialization:**
   - **Why:** Track the minimum price seen so far and the maximum profit that can be achieved.
   - **How:** Initialize `minSoFar` to `Integer.MAX_VALUE` to ensure any price will be lower initially. Initialize `maxProfit` to 0.

3. **Iterate Through Prices:**
   - **Why:** To find the maximum profit by iterating through the array of prices.
   - **How:** Use a `for` loop to iterate through each price in the array.

4. **Update Minimum Price:**
   - **Why:** Keep track of the lowest price encountered so far, which is needed to calculate the potential profit at each step.
   - **How:** Use `Math.min(prices[i], minSoFar)` to update `minSoFar`.

5. **Calculate and Update Maximum Profit:**
   - **Why:** At each step, calculate the potential profit by subtracting the current minimum price from the current price. Update the maximum profit if the calculated profit is greater than the current maximum profit.
   - **How:** Use `Math.max(maxProfit, prices[i] - minSoFar)` to update `maxProfit`.

6. **Return the Result:**
   - **Why:** After iterating through the array, `maxProfit` will hold the maximum profit that can be achieved.
   - **How:** Return the value of `maxProfit`.

Copy code
# Solution for Finding the Maximum Product Subarray

## Approach:

1. **Initial Checks:**
   - **Why:** Handle edge cases where the input array is null or empty.
   - **How:** Return 0 if the input array `nums` is null or has a length of 0.

2. **Variable Initialization:**
   - **Why:** Use two variables `prefix` and `suffix` to track the product of subarrays from the beginning and the end of the array, respectively.
   - **How:** Initialize `prefix` and `suffix` to 1, and `max` to `Integer.MIN_VALUE` to track the maximum product encountered.

3. **Iterate Through Array:**
   - **Why:** Calculate the product of subarrays starting from both ends to handle negative numbers that might affect the product.
   - **How:** Use a `for` loop to iterate through the array from both the start and end simultaneously.

4. **Reset Prefix and Suffix:**
   - **Why:** Reset the `prefix` and `suffix` to 1 if they become 0, to start a new subarray product calculation.
   - **How:** Use conditions `if (prefix == 0) prefix = 1;` and `if (suffix == 0) suffix = 1;`.

5. **Update Prefix and Suffix:**
   - **Why:** Multiply the current element to the `prefix` and the element from the end to the `suffix`.
   - **How:** Update `prefix` with `prefix *= nums[i];` and `suffix` with `suffix *= nums[nums.length - 1 - i];`.

6. **Check for Integer Overflow:**
   - **Why:** Ensure that the multiplication does not cause an integer overflow.
   - **How:** Add checks to break the loop if `prefix` or `suffix` exceeds `Integer.MAX_VALUE` divided by the current element.

7. **Update Maximum Product:**
   - **Why:** Keep track of the maximum product encountered.
   - **How:** Update `max` with `max = Math.max(max, Math.max(suffix, prefix));`.

8. **Return the Result:**
   - **Why:** After iterating through the array, `max` will hold the maximum product of a subarray.
   - **How:** Return the value of `max`.

# Solution for Coin Change Problem Using Memoization

## Approach:

1. **Initialize Memoization Table:**
   - **Why:** To store intermediate results and avoid redundant calculations.
   - **How:** Create a 2D array `memo` with dimensions `[coins.length][amount + 1]` and fill it with `-1` to indicate uncomputed states.

2. **Helper Method:**
   - **Why:** Use a recursive approach with memoization to explore the number of coins needed for each amount.
   - **How:** Define a helper method that takes the array of coins, the current index, the remaining target amount, and the memoization table as arguments.

3. **Base Case:**
   - **Why:** Define the base case for recursion to stop when the smallest denomination is reached.
   - **How:** If the current index is `0`, check if the target amount is divisible by the coin value at index `0`. If it is, return the quotient; otherwise, return a large number (indicating an invalid solution).

4. **Memoization Check:**
   - **Why:** Avoid redundant calculations by checking if the result for the current state is already computed.
   - **How:** Return the precomputed result from the memoization table if it is not `-1`.

5. **Recursive Calls:**
   - **Why:** Explore both possibilities of including or not including the current coin.
   - **How:** Compute the result for not taking the current coin (`notTake`) by making a recursive call with the previous index. Compute the result for taking the current coin (`take`) by making a recursive call with the same index and the target amount reduced by the coin value. Add `1` to the result of `take` to account for the current coin.

6. **Update Memoization Table:**
   - **Why:** Store the computed result in the memoization table to avoid redundant calculations.
   - **How:** Update the memoization table with the minimum value between `take` and `notTake`.

7. **Final Check and Return:**
   - **Why:** Ensure the final answer is valid.
   - **How:** If the final answer is greater than or equal to a large number (indicating no solution), return `-1`. Otherwise, return the answer.

## Example:

Consider the input `coins = [1, 2, 5]` and `amount = 11`:

- The algorithm will find that the minimum number of coins needed is `3` (11 = 5 + 5 + 1).

## Code Implementation:

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = helper(coins, coins.length - 1, amount, memo);
        if (ans >= 1e9) return -1;
        return ans;
    }

    private int helper(int[] nums, int i, int target, int[][] memo) {
        if (i == 0) {
            if (target % nums[i] == 0) return target / nums[i];
            return (int) 1e9;
        }
        if (memo[i][target] != -1) return memo[i][target];

        int notTake = helper(nums, i - 1, target, memo);
        int take = (int) 1e9;
        if (target >= nums[i]) {
            take = 1 + helper(nums, i, target - nums[i], memo);
        }
        return memo[i][target] = Math.min(take, notTake);
    }
}
```

# Gist for Splitting Array into k Subarrays with Minimum Largest Sum

## Problem:
Given an array `nums` and an integer `k`, split the array into `k` subarrays such that the largest sum among these subarrays is minimized.

## Key Insight:
Use binary search to determine the minimum possible largest sum for splitting the array into `k` subarrays.

## Steps:

1. **Initial Bounds:**
   - **Start:** The maximum element in `nums` (since at least one subarray will contain this element).
   - **End:** The sum of all elements in `nums` (the entire array as one subarray).

2. **Binary Search:**
   - **Midpoint (`mid`):** The candidate for the maximum allowed subarray sum.
   - **Count Subarrays:** Determine the number of subarrays required if each subarray sum is limited to `mid`.
      - Initialize `subArraySum` to 0 and `countOfSubArrays` to 1.
      - Iterate through `nums`, adding each element to `subArraySum`.
      - If `subArraySum` exceeds `mid`, start a new subarray and increment `countOfSubArrays`.

3. **Adjust Bounds:**
   - If the number of subarrays (`countOfSubArrays`) is less than or equal to `k`, adjust `end` to `mid - 1` (try a smaller maximum sum).
   - If `countOfSubArrays` is greater than `k`, adjust `start` to `mid + 1` (need a larger maximum sum to fit all elements into `k` subarrays).

4. **Result:**
   - The value of `start` after the binary search loop is the minimum possible largest sum for `k` subarrays.

## Code Snippet:

```java
class Solution {
    private int countAllocatedSubArrays(int[] nums, int maxSum) {
        int countOfSubArrays = 1;
        int subArraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (subArraySum + nums[i] <= maxSum) {
                subArraySum += nums[i];
            } else {
                subArraySum = nums[i];
                countOfSubArrays++;
            }
        }
        return countOfSubArrays;
    }

    public int splitArray(int[] nums, int k) {
        if (nums.length < k) return -1;
        int maxElementInArray = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxElementInArray = Math.max(nums[i], maxElementInArray);
            sum += nums[i];
        }

        int start = maxElementInArray, end = sum;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int countSubArrays = countAllocatedSubArrays(nums, mid);
            if (countSubArrays <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
```
# Gist for Finding Median of Two Sorted Arrays

## Problem:
Given two sorted arrays `nums1` and `nums2`, find the median of the two sorted arrays. The overall run time complexity should be O(log(min(n,m))), where n and m are the sizes of the two arrays.

## Key Insight:
Use binary search to partition the arrays such that the elements on the left side of the partition are less than or equal to the elements on the right side, ensuring the median is found efficiently.

## Steps:

1. **Ensure `nums1` is the Smaller Array:**
   - **Why:** To minimize the binary search range and ensure efficiency.
   - **How:** Swap `nums1` and `nums2` if `nums1` is longer than `nums2`.

2. **Binary Search Initialization:**
   - **Why:** To find the correct partition of `nums1` and `nums2`.
   - **How:** Initialize `start` and `end` for `nums1`'s length.

3. **Binary Search Loop:**
   - **Partition Indices:**
      - Calculate `partitionX` for `nums1` and `partitionY` for `nums2` such that the left and right partitions cover all elements.
   - **Boundary Values:**
      - Set boundary values `maxLeftX`, `minRightX` for `nums1` and `maxLeftY`, `minRightY` for `nums2`. Use `Integer.MIN_VALUE` and `Integer.MAX_VALUE` for out-of-bound indices.

4. **Check Correct Partition:**
   - **Why:** To ensure that elements on the left are less than or equal to elements on the right.
   - **How:** If `maxLeftX <= minRightY` and `maxLeftY <= minRightX`, the correct partition is found.
      - **Even Total Elements:** If the combined array length is even, the median is the average of the maximum of the left elements and the minimum of the right elements.
      - **Odd Total Elements:** If the combined array length is odd, the median is the maximum of the left elements.

5. **Adjust Search Range:**
   - **Why:** To narrow down the correct partition.
   - **How:** If `maxLeftX > minRightY`, move left by setting `end = partitionX - 1`. If `maxLeftY > minRightX`, move right by setting `start = partitionX + 1`.

## Example:

Consider the input arrays `nums1 = [1, 3]` and `nums2 = [2]`:

- The algorithm will find that the median is `2`.

## Code Implementation:

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0, end = x;
        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }
        return -1;
    }
}
```
# Gist for Finding the Range of a Target in a Sorted Array

## Problem:
Given a sorted array `nums` and a target value `target`, find the starting and ending position of the target value. If the target is not found, return `[-1, -1]`.

## Key Insight:
Use binary search to efficiently find the leftmost (first) and rightmost (last) occurrences of the target.

## Steps:

1. **Edge Case Check:**
   - **Why:** Handle cases where the input array is null or empty.
   - **How:** Return `[-1, -1]` if the array is null or has zero length.

2. **Find Leftmost and Rightmost Indices:**
   - **Why:** Separate the logic to find the first and last occurrence of the target using binary search.
   - **How:** Use a helper method `findIndex` with a boolean parameter to indicate whether to find the first or last occurrence of the target.

3. **Helper Method: `findIndex`:**
   - **Binary Search:**
      - Initialize `start` to 0 and `end` to the length of the array minus one.
      - Use a while loop to perform binary search until `start` exceeds `end`.
      - Calculate the midpoint `mid`.
      - If `nums[mid]` equals the target, update `ans` to `mid`.
         - If searching for the first occurrence, move the `end` to `mid - 1`.
         - If searching for the last occurrence, move the `start` to `mid + 1`.
      - If `nums[mid]` is greater than the target, move the `end` to `mid - 1`.
      - If `nums[mid]` is less than the target, move the `start` to `mid + 1`.

4. **Return the Result:**
   - **Why:** The result should be the indices of the first and last occurrences of the target.
   - **How:** Return the indices found by the two calls to `findIndex`.

## Example:

Consider the input `nums = [5,7,7,8,8,10]` and `target = 8`:

- The algorithm will find that the starting and ending positions of the target are `[3, 4]`.

## Code Implementation:

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        boolean isFirst = true;
        int leftMost = findIndex(nums, target, isFirst);
        int rightMost = findIndex(nums, target, false);
        
        return new int[] {leftMost, rightMost};
    }
    
    private int findIndex(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (isFirst) end = mid - 1;
                else start = mid + 1;
            } else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return ans;
    }
}
```

# Gist for Merging Intervals

## Problem:
Given a collection of intervals, merge all overlapping intervals.

## Key Insight:
Sort the intervals by their start times, then iterate through the sorted list and merge overlapping intervals.

## Steps:

1. **Edge Case Check:**
   - **Why:** Handle cases where the input array is null or empty.
   - **How:** Return the input intervals if it is null or has zero length.

2. **Sort Intervals:**
   - **Why:** Sorting by the start times allows for an efficient merging process.
   - **How:** Use `Arrays.sort` with a custom comparator to sort intervals based on their starting values.

3. **Initialize Variables:**
   - **Why:** Track the current interval being merged and store the result.
   - **How:** Initialize `newInterval` to the first interval and a `List<int[]>` to store merged intervals. Add `newInterval` to the list.

4. **Iterate Through Intervals:**
   - **Merge Overlapping Intervals:**
      - **Why:** Merge intervals that overlap by updating the end of the current interval.
      - **How:** If the start of the current interval is less than or equal to the end of `newInterval`, update `newInterval`'s end to the maximum end of both intervals.
   - **Add Non-Overlapping Intervals:**
      - **Why:** When encountering a non-overlapping interval, add the current interval to the result list and update `newInterval`.
      - **How:** Add the interval to the result list and set `newInterval` to the current interval.

5. **Return Result:**
   - **Why:** Convert the result list to an array for the final output.
   - **How:** Use `List.toArray` to convert the list of intervals to a 2D array.

## Example:

Consider the input `intervals = [[1,3],[2,6],[8,10],[15,18]]`:

- The algorithm will merge the intervals to `[[1,6],[8,10],[15,18]]`.

## Code Implementation:

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] newInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);
        
        for (int[] interval : intervals) {
            // Merge overlapping intervals
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                // Add non-overlapping interval to result
                res.add(interval);
                newInterval = interval;
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
```

# Gist for Inserting a New Interval into a Sorted Interval List

## Problem:
Given a list of non-overlapping intervals sorted by their start time, insert a new interval into the list and merge if necessary.

## Key Insight:
Iterate through the existing intervals, adding them to the result list. Merge overlapping intervals with the new interval as necessary.

## Steps:

1. **Initialize Result List:**
   - **Why:** To store the merged intervals.
   - **How:** Create a `List<int[]>` to store the intervals.

2. **Iterate Through Intervals:**
   - **Add Non-Overlapping Intervals Before New Interval:**
      - **Why:** If the current interval ends before the new interval starts, add it to the result list.
      - **How:** Check if `interval[1] < newInterval[0]` and add the interval to the result list.
   - **Add and Merge Overlapping Intervals:**
      - **Why:** If the current interval starts after the new interval ends, add the new interval followed by the current interval and set `newInterval` to null (indicating it has been inserted).
      - **How:** Check if `interval[0] > newInterval[1]`, add `newInterval` and the current interval to the result list, then set `newInterval` to null.
      - **Why:** If the current interval overlaps with the new interval, merge them by updating the start and end of the new interval.
      - **How:** Update `newInterval[0]` to the minimum of `interval[0]` and `newInterval[0]`, and `newInterval[1]` to the maximum of `interval[1]` and `newInterval[1]`.

3. **Add Remaining New Interval:**
   - **Why:** If the new interval has not been added yet (it overlaps with intervals at the end), add it to the result list.
   - **How:** Check if `newInterval` is not null and add it to the result list.

4. **Return Result:**
   - **Why:** Convert the list to a 2D array for the final output.
   - **How:** Use `List.toArray` to convert the list of intervals to a 2D array.

## Example:

Consider the input `intervals = [[1,3],[6,9]]` and `newInterval = [2,5]`:

- The algorithm will merge the intervals to `[[1,5],[6,9]]`.

## Code Implementation:

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            // interval.end < newInterval.start
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
```
# Gist for Checking If Two Strings Are Anagrams

## Problem:
Given two strings `s` and `t`, determine if `t` is an anagram of `s`. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase.

## Key Insight:
Use an array to count the frequency of each character in both strings and compare the counts.

## Steps:

1. **Initialize Frequency Array:**
   - **Why:** To store the count of each character.
   - **How:** Create an array `a` of size 256 (to cover all ASCII characters) initialized to zero.

2. **Count Characters in `s`:**
   - **Why:** Increment the count for each character in `s` to record their frequencies.
   - **How:** Loop through each character in `s`, convert it to its ASCII value, and increment the corresponding index in the array.

3. **Count Characters in `t`:**
   - **Why:** Decrement the count for each character in `t` to compare against the frequencies recorded for `s`.
   - **How:** Loop through each character in `t`, convert it to its ASCII value, and decrement the corresponding index in the array.

4. **Check Frequency Array:**
   - **Why:** Ensure all counts are zero, indicating that `t` has the same character frequencies as `s`.
   - **How:** Loop through the frequency array, and if any value is not zero, return `false`.

5. **Return Result:**
   - **Why:** If all counts are zero, the strings are anagrams.
   - **How:** Return `true`.

## Example:

Consider the input strings `s = "anagram"` and `t = "nagaram"`:

- The algorithm will find that `t` is an anagram of `s` and return `true`.

## Code Implementation:

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[256];
        for (char c : s.toCharArray()) {
            a[c]++;
        }
        for (char c : t.toCharArray()) {
            a[c]--;
        }
        
        for (int num : a) {
            if (num != 0) return false;
        }
        return true;
    }
}
```
# Gist for Counting Smaller Elements to the Right

## Problem:
Given an array `nums`, return a list `res` where `res[i]` is the number of smaller elements to the right of `nums[i]`.

## Key Insight:
Use a modified merge sort to count the smaller elements efficiently while sorting the array.

## Steps:

1. **Initialize Count Array and Indexes:**
   - **Why:** To keep track of the count of smaller elements for each element in `nums` and to maintain the original indexes during sorting.
   - **How:** Create an array `count` of the same length as `nums` initialized to 0, and an array `indexes` storing the original indices of the elements.

2. **Merge Sort:**
   - **Why:** The merge sort will help in efficiently counting the smaller elements to the right while sorting.
   - **How:** Use a recursive merge sort function to sort the array while counting the smaller elements.

3. **Merge Function:**
   - **Count and Sort:**
      - **Why:** During the merge step, count how many elements from the right half are smaller than the current element from the left half.
      - **How:** Use two pointers to iterate through the left and right halves. If an element from the right half is smaller, increment the count for the current element from the left half. Merge the elements back into the `indexes` array while updating the counts.

4. **Return Result:**
   - **Why:** The `count` array contains the required counts of smaller elements to the right for each element in `nums`.
   - **How:** Convert the `count` array to a list and return it.

## Example:

Consider the input `nums = [5, 2, 6, 1]`:

- The algorithm will find that the counts of smaller elements to the right are `[2, 1, 1, 0]`.

## Code Implementation:

```java
class Solution {
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();     
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void mergesort(int[] nums, int[] indexes, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);
        merge(nums, indexes, start, end);
    }

    private void merge(int[] nums, int[] indexes, int start, int end) {
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid + 1;
        int rightcount = 0;    	
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while (left_index <= mid && right_index <= end) {
            if (nums[indexes[right_index]] < nums[indexes[left_index]]) {
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            } else {
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while (left_index <= mid) {
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while (right_index <= end) {
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for (int i = start; i <= end; i++) {
            indexes[i] = new_indexes[i - start];
        }
    }
}
```
# Gist for Finding the Peak Index in a Mountain Array

## Problem:
Given a mountain array `arr` (an array where `arr[0] < arr[1] < ... < arr[peak] > ... > arr[n-1]`), find the peak index in the array.

## Key Insight:
Use binary search to efficiently find the peak index, where the peak is defined as an element that is greater than its neighbors.

## Steps:

1. **Edge Case Checks:**
   - **Why:** Handle edge cases where the peak might be at the beginning or the end of the array.
   - **How:**
      - If the first element is greater than the second, return index `0`.
      - If the last element is greater than the second last, return index `n-1`.

2. **Binary Search Initialization:**
   - **Why:** The peak cannot be at the very beginning or end, so initialize binary search between the second and second last elements.
   - **How:** Set `start` to `1` and `end` to `n-2`.

3. **Binary Search Loop:**
   - **Why:** Narrow down the search range to find the peak index.
   - **How:**
      - Calculate the middle index `mid`.
      - If `arr[mid]` is greater than both its neighbors (`arr[mid+1]` and `arr[mid-1]`), it is the peak, so return `mid`.
      - If `arr[mid]` is greater than `arr[mid-1]` but less than `arr[mid+1]`, move the `start` to `mid + 1` (the peak is in the right half).
      - If `arr[mid]` is less than `arr[mid-1]`, move the `end` to `mid - 1` (the peak is in the left half).

4. **Return Result:**
   - **Why:** The loop will return the peak index once found.
   - **How:** If no peak is found (though theoretically impossible with the given problem constraints), return `-1`.

## Example:

Consider the input `arr = [0, 2, 3, 4, 3, 2, 1]`:

- The algorithm will find that the peak index is `3`, where the peak element is `4`.

## Code Implementation:

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr[0] > arr[1]) return 0;
        int n = arr.length - 1;
        if (arr[n] > arr[n - 1]) return n;
        int start = 1, end = n - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            else if (arr[mid] > arr[mid - 1]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
```
# Gist for Adding Two Numbers Represented by Linked Lists

## Problem:
Given two non-empty linked lists representing two non-negative integers, where the digits are stored in reverse order, add the two numbers and return the sum as a linked list. Each node contains a single digit, and the two numbers do not contain any leading zero, except the number 0 itself.

## Key Insight:
Traverse both linked lists, summing corresponding digits along with any carry from the previous addition. Store the results in a new linked list.

## Steps:

1. **Initialize Dummy Node and Pointers:**
   - **Why:** A dummy node simplifies the creation of the result list and handling the carry-over.
   - **How:** Create a dummy node and a current pointer pointing to it. Initialize carry to 0.

2. **Traverse Lists and Sum Digits:**
   - **Why:** To add the numbers digit by digit, including any carry from the previous addition.
   - **How:** Use a `while` loop to traverse both lists and add corresponding digits. If one list is shorter, treat missing digits as 0.

3. **Handle Carry and Create New Nodes:**
   - **Why:** Each sum might result in a carry, and we need to create new nodes for the result list.
   - **How:** Calculate the sum of the current digits and the carry. Create a new node with the digit value (sum % 10) and update the carry (sum / 10). Move the current pointer to the new node.

4. **Return Result:**
   - **Why:** The result list starts from the next node of the dummy node.
   - **How:** Return `dummy.next`.

## Example:

Consider the input lists `l1 = [2,4,3]` and `l2 = [5,6,4]`:

- The algorithm will produce the result list `[7,0,8]` representing the number 807 (342 + 465).

## Code Implementation:

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
```

# Gist for Removing the N-th Node from the End of a Linked List

## Problem:
Given the head of a linked list and an integer `n`, remove the n-th node from the end of the list and return its head.

## Key Insight:
Use two pointers (`slow` and `fast`). Move the `fast` pointer `n` steps ahead, then move both pointers until `fast` reaches the end. The `slow` pointer will be at the node just before the one to be removed.

## Steps:

1. **Initialize Pointers:**
   - **Why:** To traverse the list and find the n-th node from the end.
   - **How:** Set both `slow` and `fast` pointers to the head of the list.

2. **Move Fast Pointer Ahead:**
   - **Why:** To create a gap of `n` nodes between the `fast` and `slow` pointers.
   - **How:** Move the `fast` pointer `n` steps ahead. If `fast` reaches the end, it means we need to remove the head node.

3. **Check if Fast Reached the End:**
   - **Why:** To handle the edge case where the node to be removed is the head.
   - **How:** If `fast` is null after moving `n` steps, return `head.next` to remove the head node.

4. **Move Both Pointers:**
   - **Why:** To find the node just before the one to be removed.
   - **How:** Move both `slow` and `fast` pointers until `fast.next` is null.

5. **Remove the N-th Node:**
   - **Why:** To update the links and remove the target node.
   - **How:** Set `slow.next` to `slow.next.next`.

6. **Return Result:**
   - **Why:** The head of the modified list.
   - **How:** Return the head node.

## Example:

Consider the input list `head = [1,2,3,4,5]` and `n = 2`:

- The algorithm will remove the node with value `4`, resulting in the list `[1,2,3,5]`.

## Code Implementation:

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) break;
        }
        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
```
# Gist for Merging Two Sorted Linked Lists

## Problem:
Given two sorted linked lists, merge them into one sorted linked list.

## Key Insight:
You can merge the two lists either iteratively or recursively by comparing the values of the nodes and linking them in order.

## Steps for Recursive Approach:

1. **Base Cases:**
   - **Why:** Handle edge cases where one or both lists are empty.
   - **How:** Return the non-empty list or null if both are empty.

2. **Recursive Merge:**
   - **Why:** Compare the values of the current nodes in both lists and recursively merge the rest.
   - **How:**
      - If `l1.val < l2.val`, set `l1.next` to the result of merging `l1.next` and `l2`, then return `l1`.
      - Otherwise, set `l2.next` to the result of merging `l1` and `l2.next`, then return `l2`.

## Steps for Iterative Approach:

1. **Initialize Dummy Node and Pointers:**
   - **Why:** A dummy node simplifies the process of merging and handling edge cases.
   - **How:** Create a dummy node and a pointer `cur` pointing to it.

2. **Traverse and Merge Lists:**
   - **Why:** Compare the current nodes of both lists and attach the smaller node to the result list.
   - **How:**
      - Use a `while` loop to traverse both lists.
      - Compare `l1.val` and `l2.val` and attach the smaller node to `cur.next`.
      - Move the pointer in the list from which the node was taken.

3. **Attach Remaining Nodes:**
   - **Why:** One list may have remaining nodes after the other is exhausted.
   - **How:** Attach the remaining nodes of `l1` or `l2` to `cur.next`.

4. **Return Result:**
   - **Why:** The merged list starts from the next node of the dummy node.
   - **How:** Return `result.next`.

## Code Implementation:

```java
package LeetCode;

public class P21MergeTwoSortedLists {
    // Recursive approach
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    // Iterative approach
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return result.next;
    }
}
```
# Gist for Copying a Linked List with Random Pointer

## Problem:
Given a linked list where each node has a `val`, `next`, and `random` pointer, create a deep copy of the list.

## Key Insight:
Use an interleaved list approach to create the copy and set the random pointers correctly.

## Steps:

1. **Insert Copy Nodes:**
   - **Why:** To easily set the `random` pointers for the copied nodes.
   - **How:** Iterate through the original list and insert a copy of each node immediately after the original node. Update the `next` pointers to interleave the original and copied nodes.

2. **Set Random Pointers:**
   - **Why:** To ensure that the copied nodes have the correct `random` pointers.
   - **How:** Iterate through the interleaved list. For each original node, set the `random` pointer of the copied node to the next node of the original node's `random` pointer.

3. **Restore Original List and Extract Copy:**
   - **Why:** To separate the original list from the copied list.
   - **How:** Use a dummy node to help extract the copied list. Iterate through the interleaved list, restoring the original `next` pointers and building the copied list using the `next` pointers of the copied nodes.

## Example:

Consider the input list:
Original: 1 -> 2 -> 3
Random: 1 -> 3, 2 -> 1, 3 -> 2


The algorithm will produce a copied list with the same structure and random pointers.

## Code Implementation:

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // Step 1: Insert copy nodes
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        
        // Step 2: Set random pointers
        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            if (cur.random != null) copy.random = cur.random.next;
            cur = cur.next.next;
        }
        
        // Step 3: Restore original list and extract copy
        Node dummy = new Node(0);
        cur = head;
        Node copy = dummy;
        while (cur != null) {
            copy.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            copy = copy.next;
        }
        return dummy.next;
    }
}
```
# Gist for Finding the Length of the Longest Substring Without Repeating Characters

## Problem:
Given a string `s`, find the length of the longest substring without repeating characters.

## Key Insight:
Use a sliding window approach with two pointers (`left` and `right`) to maintain a window of unique characters, and a hashmap to track the characters' frequencies.

## Steps:

1. **Initialize Variables:**
   - **Why:** To track the start of the current window (`left`), the maximum length found (`maxLen`), and the frequency of characters in the current window.
   - **How:** Use `left` to represent the start index of the window, `maxLen` to store the maximum length of the substring found so far, and a `HashMap` to track character frequencies.

2. **Sliding Window with Two Pointers:**
   - **Why:** To dynamically adjust the window size to ensure all characters within it are unique.
   - **How:**
      - Iterate through the string using the `right` pointer.
      - Add the character at `right` to the map, increasing its frequency.
      - If the frequency of the character is greater than 1, it means there's a duplicate, so move the `left` pointer to shrink the window until the character's frequency is 1 again.

3. **Update Maximum Length:**
   - **Why:** To track the maximum length of the substring without repeating characters.
   - **How:** After adjusting the window, update `maxLen` with the length of the current window (`right - left + 1`).

4. **Return Result:**
   - **Why:** The maximum length found during the iteration is the answer.
   - **How:** Return `maxLen`.

## Example:

Consider the input string `"pwwkew"`:

- The algorithm will find the substrings `"pw"` and `"wke"` and return `3` as the length of the longest substring without repeating characters.

## Code Implementation:

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
```
# Gist for Finding the Maximum Water Container Area

## Problem:
Given an array `height` where each element represents the height of a vertical line, find two lines that together with the x-axis form a container that holds the most water. Return the maximum area of water that the container can hold.

## Key Insight:
Use the two-pointer technique to maximize the area by starting with the widest possible container and moving the pointers inward.

## Steps:

1. **Initialize Pointers and Max Area:**
   - **Why:** Start with the two pointers at the beginning and end of the array, representing the widest possible container.
   - **How:** Set `start` to `0` and `end` to `height.length - 1`. Initialize `maxArea` to `0`.

2. **Calculate Area and Move Pointers:**
   - **Why:** The area of the container is determined by the shorter line, and the width is the distance between the two pointers.
   - **How:**
      - Calculate the current area as `min(height[start], height[end]) * (end - start)` and update `maxArea` if the current area is larger.
      - Move the pointer that is pointing to the shorter line inward because moving the taller line would not increase the height, and thus can't increase the area.

3. **Continue Until Pointers Meet:**
   - **Why:** Continue adjusting the pointers until they meet, ensuring all potential container sizes are considered.
   - **How:** Use a `while` loop that continues as long as `start < end`.

4. **Return Result:**
   - **Why:** The maximum area found during the iteration is the answer.
   - **How:** Return `maxArea`.

## Example:

Consider the input array `height = [1,8,6,2,5,4,8,3,7]`:

- The algorithm will find that the maximum area is `49`, formed between the heights `8` and `7` with a width of `7`.

## Code Implementation:

```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            maxArea = Math.max(Math.min(height[end], height[start]) * (end - start), maxArea);
            if (height[start] < height[end]) start++;
            else end--;
        }
        return maxArea;
    }
}
```
# Gist for Finding All Unique Triplets that Sum to Zero

## Problem:
Given an integer array `nums`, return all the unique triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

## Key Insight:
Use a combination of sorting and two-pointer technique to find all unique triplets that sum to zero. This approach avoids duplicates and efficiently finds the required triplets.

## Steps:

1. **Handle Edge Cases:**
   - **Why:** To avoid unnecessary computations if the input array is too short.
   - **How:** Return an empty list if `nums` is null or has fewer than three elements.

2. **Sort the Array:**
   - **Why:** Sorting the array simplifies the problem by allowing us to use the two-pointer technique and easily avoid duplicates.
   - **How:** Use `Arrays.sort(nums)` to sort the array in ascending order.

3. **Iterate Through the Array:**
   - **Why:** To fix one element and find the other two elements using the two-pointer technique.
   - **How:** Loop through the array with an index `i` from `0` to `nums.length - 2`.

4. **Skip Duplicates for `i`:**
   - **Why:** To ensure that each triplet is unique and to avoid redundant work.
   - **How:** Skip the current iteration if `nums[i]` is the same as `nums[i-1]`.

5. **Two-Pointer Technique:**
   - **Why:** To find pairs that sum with `nums[i]` to zero.
   - **How:** Initialize two pointers, `start` at `i+1` and `end` at `nums.length - 1`. Calculate the sum of `nums[i] + nums[start] + nums[end]`.
      - If the sum is zero, add the triplet to the result list.
      - Move both pointers inward while skipping duplicates.
      - If the sum is greater than zero, move the `end` pointer inward.
      - If the sum is less than zero, move the `start` pointer inward.

6. **Return Result:**
   - **Why:** The list `res` now contains all unique triplets that sum to zero.
   - **How:** Return `res`.

## Example:

Consider the input array `nums = [-1,0,1,2,-1,-4]`:

- The algorithm will find the triplets `[-1,-1,2]` and `[-1,0,1]` and return them as the result.

## Code Implementation:

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++; end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else if (sum > 0) end--;
                  else start++;
            }
        }
        return res;
    }
}
```
# Gist for Finding the Next Permutation

## Problem:
Given an array of integers `nums`, find the next lexicographical permutation of the array. If no such permutation exists (the array is in descending order), rearrange the array into the lowest possible order (ascending).

## Key Insight:
The problem can be broken down into finding the rightmost pair where the first number is smaller than the second, swapping it with the smallest number larger than it to the right, and then reversing the order of the numbers following the swapped position.

## Steps:

1. **Find the Breakpoint:**
   - **Why:** The "breakpoint" is the rightmost position where the current element is smaller than the next element, indicating where the order breaks from increasing.
   - **How:** Iterate backward through the array from the second-last element. If `nums[i] < nums[i + 1]`, mark `i` as the breakpoint and break the loop.

2. **Handle Edge Case (No Breakpoint):**
   - **Why:** If the array is in descending order, the next permutation is the smallest permutation.
   - **How:** If no breakpoint is found (i.e., `breakPoint` is `-1`), reverse the entire array and return.

3. **Find the Smallest Element Larger than Breakpoint:**
   - **Why:** To maintain the next lexicographical order, swap the element at the breakpoint with the smallest element larger than it to the right.
   - **How:** Iterate backward from the end of the array to find the first element greater than `nums[breakPoint]`, then swap them.

4. **Reverse the Subarray to the Right of Breakpoint:**
   - **Why:** After the swap, the elements to the right of the breakpoint should be in ascending order to form the next permutation.
   - **How:** Reverse the subarray starting from `breakPoint + 1` to the end of the array.

## Example:

Consider the input `nums = [1,2,3]`:

- The next permutation is `[1,3,2]`.

For `nums = [3,2,1]`, the next permutation is `[1,2,3]` because the array is in descending order, so the next permutation is the smallest permutation.

## Code Implementation:

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[breakPoint]) {
                int temp = nums[i];
                nums[i] = nums[breakPoint];
                nums[breakPoint] = temp;
                break;
            }
        }
        reverse(nums, breakPoint + 1, nums.length - 1);
    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }
}
```
# Gist for Multiplying Two Large Numbers Represented as Strings

## Problem:
Given two non-negative integers represented as strings `num1` and `num2`, return the product of the two numbers as a string. The numbers may be large, so you cannot directly convert them to integers for multiplication.

## Key Insight:
Simulate the multiplication process similar to how you would do it manually, digit by digit, and store the intermediate results in an array.

## Steps:

1. **Initialize Result Array:**
   - **Why:** To store the intermediate results of the multiplication process.
   - **How:** Create an integer array `res` with a size equal to the sum of the lengths of `num1` and `num2`. This array will hold the individual digits of the final product.

2. **Simulate Multiplication:**
   - **Why:** Multiply each digit of `num1` with each digit of `num2` and store the result in the correct position in the `res` array.
   - **How:**
      - Loop through each digit of `num1` (from right to left).
      - Loop through each digit of `num2` (from right to left).
      - Multiply the digits and add the result to the corresponding position in the `res` array.
      - Handle the carry-over by distributing it to the next higher position in the array.

3. **Build the Result String:**
   - **Why:** Convert the digits stored in the `res` array to a string.
   - **How:** Use a `StringBuilder` to iterate over the `res` array and append non-zero digits to build the final product string.

4. **Handle Edge Case (Zero Product):**
   - **Why:** If the product is zero, the `res` array may contain leading zeros.
   - **How:** If the resulting string is empty after removing leading zeros, return "0".

## Example:

Consider the input `num1 = "123"` and `num2 = "456"`:

- The algorithm will multiply the numbers to produce the result `"56088"`.

## Code Implementation:

```java
class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res[i + j + 1] + mul;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : res) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
```
