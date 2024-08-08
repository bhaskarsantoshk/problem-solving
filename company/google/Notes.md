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

