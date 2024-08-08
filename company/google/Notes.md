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