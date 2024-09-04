# Last minute revision Questions
1. Permutation Sequence
  * To get the k-th permutation of numbers from 1 to n:
    * Precompute factorials to determine the block size for each position. 
    * Select the appropriate number by dividing k by the factorial, then adjust k and repeat until the sequence is built.
2. Cost to Cut a Chocolate
   * Formula:
     For each cut between indices i and j, the cost is cuts[j+1] - cuts[i-1] + f(i, ind-1) + f(ind+1, j), where f(i, j) 
     recursively calculates the minimum cost to cut between i and j. 
   * Use dynamic programming to store intermediate results to avoid recalculations.
3. Largest Rectangle in Histogram
* Formula:
  * For each bar i, calculate the left and right boundaries where the height of the bar is smaller:

     •	leftSmaller[i]: The closest bar to the left that is shorter than heights[i].
     •	rightSmaller[i]: The closest bar to the right that is shorter than heights[i]. 
  * The area for each bar is then calculated as (rightSmaller[i] - leftSmaller[i] + 1) * heights[i], and the maximum area is stored.
### 4. Set Matrix Zeroes

1. **Brute Force Approach**:
    - **Idea**: Create a new matrix. For every `0` in the original matrix, mark the corresponding row and column in the new matrix.
    - **Time Complexity**: O(N^3)
    - **Space Complexity**: O(N^2)
    - **Explanation**: This takes extra space to store the modified matrix, and each time a `0` is found, the entire row and column are updated in the new matrix.

2. **Optimal Approach - Using 2 Arrays**:
    - **Idea**: Use two 1D arrays (`row[]` and `col[]`) to track which rows and columns should be set to zero.
    - **Steps**:
        - Traverse the original matrix, and when a zero is found, mark the corresponding row and column in the arrays.
        - After traversing, use the arrays to set the rows and columns to zero.
    - **Time Complexity**: O(N^2)
    - **Space Complexity**: O(N)
    - **Explanation**: This approach reduces the space complexity to O(N) by using two arrays instead of a new matrix.

3. **Constant Space - Optimized Approach**:
    - **Idea**: Instead of using extra arrays, use the first row and first column of the original matrix to store the markers. Use an additional variable to track if the first column itself should be zero.
    - **Steps**:
        - Use the first row and first column as markers.
        - For each zero encountered, mark its corresponding first row and column elements.
        - After traversing, update all the matrix elements (except the first row and column) based on the markers.
        - Finally, check if the first row and column need to be set to zero based on the stored markers.
    - **Time Complexity**: O(N^2)
    - **Space Complexity**: O(1)
    - **Explanation**: This approach avoids extra space by utilizing the matrix itself for marking.
### Pascal's Triangle

1. **Recursive Approach**:
    - **Idea**: Build the triangle row by row, where each element is the sum of the two elements directly above it.
    - **Steps**:
        - Start with the first row `[1]`, and for each subsequent row, calculate elements by summing pairs of numbers from the previous row.
        - Add `1` at both ends of each row.
    - **Time Complexity**: O(N^2)
    - **Space Complexity**: O(N^2)
    - **Explanation**: This approach constructs the triangle by iterating through previous rows, adding elements as needed.

2. **Mathematical Approach (Combinatorics)**:
    - **Idea**: Each element in row `n` and column `k` of Pascal's Triangle is calculated using the binomial coefficient `nCk`.
    - **Steps**:
        - For each row, start with `1` and calculate subsequent elements using the formula:  
          `ans = ans * (row - col) / col`.
    - **Time Complexity**: O(N^2)
    - **Space Complexity**: O(N^2)
    - **Explanation**: This uses combinatorics to directly calculate each element in the triangle, reducing unnecessary iterations.
### Next Permutation

1. **Idea**: The goal is to rearrange the numbers into the next lexicographically greater permutation of the given sequence. If that isn't possible, rearrange it as the lowest possible order (i.e., sorted in ascending order).

2. **Steps**:
    - Find the **breakpoint** where the number at index `i` is less than the number at `i+1`, starting from the right (i.e., traverse from the end).
    - If no breakpoint is found (i.e., the sequence is in descending order), reverse the array to get the smallest permutation.
    - If a breakpoint is found:
        - Find the smallest number greater than `nums[breakpoint]` to the right of the breakpoint.
        - Swap this number with the number at the breakpoint.
        - Reverse the part of the array to the right of the breakpoint to get the next permutation.

3. **Time Complexity**: O(N)
4. **Space Complexity**: O(1) (in-place manipulation)

5. **Explanation**:
    - The process involves finding the first descending pair from the right, swapping it with the smallest larger number, and then reversing the remaining sequence to ensure the next permutation is obtained.
### Maximum Subarray (Kadane's Algorithm)

1. **Idea**: The goal is to find the contiguous subarray with the largest sum in a given array of integers.

2. **Steps**:
    - Initialize `sum` and `max` with the first element of the array.
    - Traverse through the array:
        - At each index `i`, decide whether to include the current element in the existing subarray (i.e., add `nums[i]` to `sum`) or start a new subarray from `i`.
        - Update the `max` value to keep track of the highest subarray sum encountered so far.
    - This ensures that at every step, we consider the best possible subarray ending at index `i`.

3. **Time Complexity**: O(N)
4. **Space Complexity**: O(1) (in-place calculations)

5. **Explanation**:
    - The algorithm efficiently calculates the maximum subarray sum by deciding whether to "carry" the current sum forward or start fresh at each index, ensuring that we always have the best possible subarray sum at each step.
### Best Time to Buy and Sell Stock

1. **Idea**: The goal is to maximize profit by choosing a day to buy and a day in the future to sell the stock. You can only make one transaction (buy once and sell once).

2. **Steps**:
    - Initialize `minimum` with the first element of the `prices` list to track the lowest price encountered so far.
    - Initialize `maxProfit` to `0` to store the maximum profit obtained.
    - Traverse the list of prices starting from the second day (`i=1`):
        - Calculate the profit for each day by subtracting the `minimum` price from the current price.
        - Update `maxProfit` if the current profit is greater than the previous maximum.
        - Update `minimum` if the current price is lower than the previous minimum price.
    - This ensures you always buy at the lowest price before selling at a higher price.

3. **Time Complexity**: O(N)
4. **Space Complexity**: O(1) (in-place calculations)

5. **Explanation**:
    - The algorithm tracks the lowest price encountered so far and the maximum profit by comparing the current price with that minimum price, ensuring you always maximize the profit by buying low and selling.
### Flatten Binary Tree to Linked List

1. **Intuitive Iterative Approach (Using Stack)**:
   - **Idea**: Use a stack to simulate pre-order traversal (root → left → right), ensuring that `root.right` points to the next node in the pre-order sequence.
   - **Steps**:
      - Push the `root` onto the stack.
      - While the stack is not empty:
         - Pop the current node (`cur`).
         - Push the right child, then the left child (if they exist). This ensures that the left child will be processed first.
         - Set `cur.right = stack.peek()` (the next node in pre-order, which is now at the top of the stack).
         - Set `cur.left = null` to simulate flattening the tree.
      - Continue this until the stack is empty.
   - **Key Intuition**: By processing the left child first (since it's pushed after the right), and then setting `cur.right` to the top of the stack, we ensure that the left subtree is connected correctly to the right side of the flattened tree.

2. **Time Complexity**: O(N)
3. **Space Complexity**: O(N) (for the stack)

**Gist**:
- Push `root` to stack, then for each node, process the right and left.
- Set `cur.right = stack.peek()` (next node in pre-order) and `cur.left = null`.

### Median Finder (Using Two Heaps)

1. **Idea**: Use two heaps (a max-heap and a min-heap) to keep track of the median dynamically as new numbers are added.
   - **Max-Heap** (`maxHeap`): Stores the smaller half of the numbers, allowing access to the maximum number in this half.
   - **Min-Heap** (`minHeap`): Stores the larger half of the numbers, allowing access to the minimum number in this half.

2. **Steps**:
   - **Adding a Number**:
      - If the new number is smaller than or equal to the top of the `maxHeap`, add it to the `maxHeap`.
      - Otherwise, add it to the `minHeap`.
      - Balance the heaps:
         - If one heap has more than one extra element compared to the other, move an element from the larger heap to the smaller one.
   - **Finding the Median**:
      - If one heap has more elements than the other, the median is the top element of the larger heap.
      - If both heaps have the same number of elements, the median is the average of the tops of both heaps.

3. **Time Complexity**:
   - **Adding a Number**: O(log N) (due to heap insertion)
   - **Finding the Median**: O(1)

4. **Space Complexity**: O(N) (for storing numbers in the heaps)

**Gist**:
- Use a max-heap for the smaller half and a min-heap for the larger half.
- Balance both heaps so that their sizes differ by at most 1.
- If heaps are balanced, the median is the average of both tops; otherwise, it's the top of the larger heap.

### Kth Largest Element in a Stream (Using Min-Heap)

1. **Idea**: Maintain a min-heap of size `k` that holds the `k` largest elements encountered so far. The root of the heap will always be the k-th largest element.

2. **Steps**:
   - **Constructor (`KthLargest`)**:
      - Initialize a min-heap (`pq`) to store the `k` largest elements.
      - Add elements from the input `nums` array to the heap.
      - If the heap size exceeds `k`, remove the smallest element (the root of the heap) to ensure it only contains the `k` largest elements.
   - **Add Method (`add`)**:
      - Add the new value (`val`) to the heap.
      - If the heap size exceeds `k`, remove the smallest element (the root).
      - Return the root of the heap, which is the k-th largest element.

3. **Time Complexity**:
   - **Constructor**: O(N log k), where N is the number of elements in the `nums` array, and `log k` is the time complexity for inserting into the heap.
   - **Add Method**: O(log k) for inserting a new element into the heap and maintaining its size.

4. **Space Complexity**: O(k) (heap space for storing `k` elements)

**Gist**:
- Use a min-heap of size `k` to keep track of the `k` largest elements.
- The root of the heap is always the k-th largest element.
- When adding a new element, insert it into the heap and remove the smallest element if the heap exceeds size `k`.

### Distinct Numbers in a Window

1. **Idea**: Given an array `A` and a window size `B`, find the number of distinct elements in every sliding window of size `B`.

2. **Steps**:
    - Initialize a result list (`result`) to store the number of distinct elements in each window.
    - Use a HashMap (`map`) to keep track of the frequency of elements in the current window.
    - **First Window**:
        - Add the first `B` elements to the map and count distinct elements (size of the map keys).
    - **Sliding the Window**:
        - For each new window starting from index `B`, remove the element that goes out of the window (at `i-B`) from the map.
        - Decrement its count, and if the count reaches 0, remove the element from the map.
        - Add the new element (at index `i`) to the map and update its count.
        - Append the current number of distinct elements (size of map keys) to the result.

3. **Time Complexity**: O(N), where N is the length of the array `A`.
    - Each insertion and removal from the HashMap takes O(1), and the sliding window operates over all elements in the array.

4. **Space Complexity**: O(B) for storing elements in the HashMap, where `B` is the window size.

**Gist**:
- Use a HashMap to count the frequency of elements in a sliding window.
- As the window slides, remove the element that exits the window and add the element that enters.
- Track the number of distinct elements by checking the size of the map keys.