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



