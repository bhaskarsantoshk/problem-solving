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

### Kth Largest Element (Using Quickselect)

1. **Idea**: Use the Quickselect algorithm, which is an efficient selection algorithm to find the k-th largest element in an unsorted array. It works similarly to QuickSort by using a pivot to partition the array.

2. **Steps**:
    - **Partition the List**:
        - Choose a random pivot from the list.
        - Split the elements into three parts:
            - `left`: elements greater than the pivot.
            - `mid`: elements equal to the pivot.
            - `right`: elements smaller than the pivot.
    - **Recursive Logic**:
        - If `k` is less than or equal to the size of `left`, recursively search for the k-th element in the `left` sublist.
        - If `k` is larger than the size of `left` and `mid`, recursively search for the (adjusted) k-th element in the `right` sublist.
        - If `k` lies within the size of `mid`, return the pivot.

3. **Time Complexity**:
    - **Average Case**: O(N)
    - **Worst Case**: O(N^2) (if the pivot is poorly chosen)

4. **Space Complexity**: O(N) (due to the recursive partitioning of the list into sublists)

**Gist**:
- Partition the list into three parts based on a randomly chosen pivot.
- Recursively select the k-th largest element based on the size of the left and mid partitions.
- Quickselect ensures efficient selection of the k-th largest element in an average O(N) time complexity.

### Clone Graph (Using BFS)

1. **Idea**: The goal is to create a deep copy of a given graph. Each node must be copied along with all its neighbors. Use BFS to traverse the graph and clone each node.

2. **Steps**:
    - Use a HashMap `vis` to map each original node to its corresponding cloned node.
    - **BFS Traversal**:
        - Start from the input `node` and enqueue it.
        - For each node dequeued:
            - For each of its neighbors:
                - If the neighbor hasn't been visited (i.e., not cloned yet), clone it and add it to the queue.
                - Add the cloned neighbor to the current node's clone's neighbor list.
    - Continue this process until all nodes are visited and cloned.

3. **Time Complexity**: O(N + E), where N is the number of nodes and E is the number of edges (since BFS visits each node and edge once).

4. **Space Complexity**: O(N), due to the queue and the map storing the cloned nodes.

**Gist**:
- Traverse the graph using BFS.
- Clone each node and its neighbors.
- Use a map to keep track of cloned nodes and ensure no node is visited more than once.

### Detecting a Cycle in an Undirected Graph (Using BFS and DFS)

1. **Idea**: The goal is to detect if a cycle exists in an undirected graph. A cycle is present if we encounter a node that has already been visited and isn't the parent node during the traversal.

2. **Approaches**:

   #### 1. **BFS Approach**:
    - **Steps**:
        - Use a queue where each entry stores the node and its parent.
        - Start from an unvisited node, mark it as visited, and enqueue it with `-1` as its parent.
        - For each neighbor of the current node:
            - If it hasn't been visited, mark it as visited and enqueue it with the current node as its parent.
            - If it has been visited and it's not the parent of the current node, a cycle is detected.
    - **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.
    - **Space Complexity**: O(V), due to the queue and visited array.

   #### 2. **DFS Approach**:
    - **Steps**:
        - Start DFS from an unvisited node.
        - For each neighbor of the current node:
            - If it hasn't been visited, recursively call DFS on it.
            - If it has been visited and isn't the parent, a cycle is detected.
    - **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.
    - **Space Complexity**: O(V), due to recursion stack and visited array.

3. **Key Points**:
    - In an undirected graph, while traversing, the parent of a node must be tracked to avoid falsely detecting a cycle.
    - Both BFS and DFS can be used to detect cycles in an undirected graph by carefully checking previously visited nodes.

**Gist**:
- **BFS**: Use a queue and parent tracking to detect cycles while exploring neighbors.
- **DFS**: Recursively traverse nodes and track the parent to find cycles.
- Return true if a cycle is found; otherwise, return false.

### Detecting a Cycle in a Directed Graph (Using Kahn's Algorithm/Topological Sort)

1. **Idea**: In a directed graph, if there is a cycle, we won’t be able to generate a valid topological ordering. Kahn's algorithm (BFS-based topological sorting) can be used to detect cycles. If we can't visit all nodes (i.e., topologically sort all vertices), the graph contains a cycle.

2. **Steps**:
    - **In-degree Calculation**:
        - Calculate the in-degree (number of incoming edges) for each vertex.
    - **Topological Sort**:
        - Initialize a queue with all vertices having an in-degree of 0 (no incoming edges).
        - For each vertex dequeued, decrement the in-degree of all its adjacent vertices (i.e., those it points to).
        - If the in-degree of an adjacent vertex becomes 0, enqueue it.
        - Track the number of nodes visited.
    - **Cycle Detection**:
        - If the number of visited nodes is less than the total number of vertices, the graph contains a cycle (because not all nodes can be topologically sorted).

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (because we process each vertex and edge once).

4. **Space Complexity**: O(V), due to the storage of the in-degree array and the queue for BFS.

**Gist**:
- Calculate in-degrees for all vertices.
- Use a queue to process vertices with in-degree 0.
- Reduce in-degrees of adjacent vertices and enqueue them if their in-degree becomes 0.
- If all vertices are processed, no cycle exists; otherwise, a cycle is present.

### Topological Sort (Using BFS and DFS)

1. **Idea**: Topological sorting of a Directed Acyclic Graph (DAG) is a linear ordering of its vertices such that for every directed edge (u → v), vertex `u` comes before `v`. This can be achieved using both BFS (Kahn's Algorithm) and DFS.

---

#### 1. **BFS Approach (Kahn's Algorithm)**:
- **Steps**:
    - **In-degree Calculation**: Calculate the in-degree (number of incoming edges) for each vertex.
    - **Queue Initialization**: Enqueue all vertices with in-degree 0 (no incoming edges).
    - **BFS Processing**:
        - Dequeue a vertex and add it to the topological ordering.
        - For each adjacent vertex, reduce its in-degree by 1.
        - If the in-degree of an adjacent vertex becomes 0, enqueue it.
- **Time Complexity**: O(V + E)
- **Space Complexity**: O(V) (for queue and in-degree array)

**Gist**:
- Calculate in-degrees for vertices, enqueue those with in-degree 0, process each vertex in BFS order, and reduce in-degrees of its neighbors.
- If an in-degree becomes 0, enqueue the neighbor.
- The order of processed nodes is the topological sort.

---

#### 2. **DFS Approach**:
- **Steps**:
    - Perform a DFS from each unvisited vertex.
    - After exploring all neighbors of a vertex, push it onto a stack.
    - Once all vertices are processed, pop elements from the stack to get the topological order (reverse post-order).
- **Time Complexity**: O(V + E)
- **Space Complexity**: O(V) (for recursion stack and the result stack)

**Gist**:
- Perform DFS from each unvisited vertex, pushing vertices onto the stack after all their neighbors are processed.
- The stack contains the topological order once DFS completes.

---

3. **When to Use**:
    - **BFS (Kahn's Algorithm)**: Easier to understand and implement, especially for cycle detection (if all nodes cannot be sorted, the graph has a cycle).
    - **DFS**: More intuitive for tasks that require reverse post-order traversal.

4. **Key Point**: Topological sorting only works for **DAGs**. If the graph contains a cycle, topological sorting is not possible.

### Check if a Graph is Bipartite (Using DFS)

1. **Idea**: A graph is bipartite if you can split its vertices into two sets such that there are no edges between vertices of the same set. This can be achieved by coloring the graph using two colors. If two adjacent nodes have the same color, the graph is not bipartite.

---

2. **Steps**:
    - **Color Array**: Use an array `colors[]` to store the color of each vertex. Initialize all vertices to `-1` (uncolored).
    - **DFS Traversal**:
        - Start DFS from each uncolored vertex.
        - Color the current node with one color (0 or 1).
        - For each adjacent node:
            - If the adjacent node is already colored with the same color, return `false` (not bipartite).
            - If the adjacent node is uncolored, color it with the opposite color and continue DFS.
        - Repeat this for all components of the graph.

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (DFS traverses all nodes and edges).

4. **Space Complexity**: O(V) (for the color array and DFS recursion stack).

---

**Gist**:
- Use DFS to color the graph with two colors.
- If two adjacent nodes have the same color, the graph is not bipartite.
- If DFS completes without conflicts, the graph is bipartite.

### Check if a Graph is Bipartite (Using BFS)

1. **Idea**: A graph is bipartite if you can divide its vertices into two sets where no two vertices in the same set are adjacent. BFS can be used to color the graph with two colors, and if two adjacent nodes have the same color, the graph is not bipartite.

---

2. **Steps**:
    - **Color Array**: Use an array `color[]` initialized with `-1` (uncolored) to track the color of each vertex.
    - **BFS Traversal**:
        - Start BFS from an uncolored vertex and color it with `0`.
        - Use a queue to explore the graph.
        - For each node dequeued, check all its neighbors:
            - If a neighbor is uncolored, color it with the opposite color of the current node and add it to the queue.
            - If a neighbor has the same color as the current node, return `false` (graph is not bipartite).
        - Continue until all nodes are processed.
    - Repeat the process for all components of the graph.

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (BFS processes each node and edge once).

4. **Space Complexity**: O(V), for the color array and the BFS queue.

---

**Gist**:
- Use BFS to color the graph in two colors.
- If two adjacent nodes have the same color, the graph is not bipartite.
- If BFS completes without conflicts, the graph is bipartite.

### Shortest Path in a Directed Acyclic Graph (DAG) Using Topological Sort

1. **Idea**: In a **Directed Acyclic Graph (DAG)**, we can compute the shortest path from a source vertex to all other vertices by performing **Topological Sort** and then relaxing the edges in that order. The advantage is that once a vertex is processed, no shorter path to it will be found later.

---

2. **Steps**:
    - **Graph Representation**:
        - The graph is represented as an adjacency list, where each entry holds pairs representing the destination vertex and the edge weight.

    - **Step 1: Topological Sort**:
        - Perform a topological sort using DFS.
        - The idea is to process nodes in an order where every node appears before all nodes to which it has outgoing edges.
        - For this, use a DFS-based approach to generate the topological order of the nodes.

    - **Step 2: Relax Edges**:
        - Initialize a `distance[]` array with a large value (∞ or `1e9`) to represent unreachable vertices.
        - Set the distance of the source node to `0`.
        - For each node in topologically sorted order, update the distances of its adjacent nodes using edge relaxation (i.e., update the shortest path).

    - **Step 3: Handle Unreachable Nodes**:
        - If a node's distance remains as `1e9`, set it to `-1` to indicate that the node is unreachable from the source.

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (due to topological sort and edge relaxation).

4. **Space Complexity**: O(V + E), for storing the graph and the distance array.

---

**Gist**:
- Perform topological sort using DFS on the DAG.
- Relax edges in topological order to find the shortest path.
- If a node remains unreachable from the source, set its distance to `-1`.

