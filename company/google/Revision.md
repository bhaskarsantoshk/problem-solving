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