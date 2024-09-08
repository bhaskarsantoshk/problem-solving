# BFS
* Take Queue, visited array
* add start node, mark vis to true
* while traversing queue,
  * poll the node , add to result.
  * get adjacent nodes, 
    * if unvisited, add the adjNode to queue, mark it visited
## typical mistakes: 
    * adding node instead of adjNode, not marking the adjNode in vis array

### Rotting Oranges (BFS Approach)

1. **Idea**: Use **BFS** to spread the rot from initially rotten oranges to fresh ones. Each level of BFS represents a time unit (in minutes).

2. **Steps**:
  - **Initial Setup**:
    - Traverse the grid to:
      - Add the initially rotten oranges to a queue (with their positions and time 0).
      - Count the number of fresh oranges.
  - **BFS Process**:
    - For each rotten orange, mark its adjacent fresh oranges as rotten and add them to the queue.
    - Continue this until all reachable fresh oranges are rotten, tracking the maximum time.
  - **Check Completion**:
    - If all fresh oranges are rotten, return the maximum time; otherwise, return `-1` (indicating unreachable fresh oranges).

3. **Key Variables**:
  - `q`: A queue storing each rotten orange with its position and time.
  - `dirs`: Direction vectors to move up, down, left, and right.
  - `fresh`: Count of fresh oranges.
  - `max`: Maximum time to rot all oranges.
  - `rotten`: Count of oranges that have become rotten during BFS.

4. **Return Value**:
  - If all fresh oranges are rotten (`fresh == rotten`), return the maximum time (`max`).
  - If not all fresh oranges are rotten, return `-1`.

**Gist**:
- Use BFS to spread the rot level by level.
- Track the time it takes to rot all reachable fresh oranges.
- If any fresh orange is unreachable, return `-1`.

## Typical mistakes:
* updating one timer variable each time you enter into queue, but timer will increase even if there are no more fresh oranges
* not checking fresh vs rotten
* using vis array unnecessarily

### Check if a Graph is Bipartite (Using DFS)

1. **Idea**: A graph is **bipartite** if it can be colored using two colors such that no two adjacent vertices share the same color. DFS can be used to color the graph, and if we encounter an adjacent vertex with the same color, the graph is not bipartite.

---

2. **Steps**:
    - **Color Array**: Use an array `colors[]` initialized with `-1` to represent uncolored nodes.
    - **DFS Traversal**:
        - Start DFS from any uncolored vertex (`-1`) and color it (either 0 or 1).
        - For each adjacent vertex:
            - If the adjacent vertex is uncolored, recursively call DFS and color it with the opposite color.
            - If the adjacent vertex has the same color as the current node, the graph is not bipartite.
    - Repeat the process for all components of the graph.

---

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (DFS processes all nodes and edges once).

4. **Space Complexity**: O(V), for storing the color array and DFS recursion stack.

---

**Gist**:
- Use DFS to color the graph with two colors.
- If any adjacent vertices have the same color, the graph is not bipartite.
- Return true if the graph can be successfully colored; otherwise, return false.

## Typical mistakes to avoid
* not returning false if the dfs fail ( in both dfs calls)
* passing node instead of adjNode

### Check if a Graph is Bipartite (Using BFS)

1. **Idea**: A graph is **bipartite** if we can color its vertices with two colors such that no two adjacent vertices share the same color. BFS can be used to check this by coloring the graph level by level.

---

2. **Steps**:
    - **Color Array**: Use an array `colors[]` initialized with `-1` to represent uncolored nodes.
    - **BFS Traversal**:
        - Start BFS from an uncolored node and color it (either 0 or 1).
        - For each adjacent node:
            - If it is uncolored, color it with the opposite color and enqueue it.
            - If it is already colored and has the same color as the current node, the graph is not bipartite.
        - Continue until all nodes are processed.
    - Repeat the BFS for all components of the graph.

---

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (BFS processes all nodes and edges once).

4. **Space Complexity**: O(V), for the color array and the BFS queue.

---

**Gist**:
- Use BFS to color the graph in two colors.
- If two adjacent nodes have the same color, return false (not bipartite).
- If BFS completes without conflicts, return true (graph is bipartite).

## Typical mistakes to avoid
* don't mis type node and adjNodes
* take the parameter as start, node as q.poll()
* don't forget for ( int adjNode: adj.get(node))
* don't need to pass in the color from caller func if it's a BFS, always start with 0 color
* use colors[adjNode] as 1-colors[node] , not some color variable if colors[adjNode] is -1
* if ( colors[adjNode] == colors[node]) return false

### Detecting a Cycle in an Undirected Graph (Using DFS)

1. **Idea**: In an undirected graph, a cycle exists if during DFS traversal, we visit a node that has already been visited and is not the parent of the current node.

---

2. **Steps**:
    - **Visited Array**: Use a boolean array `vis[]` to keep track of visited nodes.
    - **DFS Traversal**:
        - Start DFS from any unvisited node.
        - For each adjacent node:
            - If it hasn't been visited, recursively call DFS on it.
            - If it has been visited and is not the parent of the current node, a cycle is detected.
    - Repeat the process for all components of the graph to ensure that no part of the graph is missed.

---

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (DFS visits every node and edge once).

4. **Space Complexity**: O(V), for the recursion stack and visited array.

---

**Gist**:
- Use DFS to traverse the graph, checking if any adjacent node is visited and is not the parent.
- If such a node is found, a cycle exists.
- Return true if a cycle is detected; otherwise, return false.

## Typical mistakes to avoid
* not passing the parent node in DFS call 
* not terminating based on DFS result
* not running DFS for all nodes
* nested DFS call should include cur node as parent and adjacent node as it's main node

### Detecting a Cycle in an Undirected Graph (Using BFS)

1. **Idea**: In an undirected graph, a cycle exists if during BFS traversal, we visit a node that has already been visited and it is not the parent of the current node.

---

2. **Steps**:
    - **Visited Array**: Use a boolean array `vis[]` to track visited nodes.
    - **BFS Traversal**:
        - Start BFS from any unvisited node, enqueueing it with its parent (`-1` for the starting node).
        - For each node dequeued:
            - Explore its neighbors.
            - If a neighbor hasn't been visited, mark it visited and enqueue it, passing the current node as the parent.
            - If a neighbor has been visited and is not the parent of the current node, a cycle is detected.
    - Repeat the process for all components of the graph.

---

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (BFS visits every node and edge once).

4. **Space Complexity**: O(V), for the queue and visited array.

---

**Gist**:
- Use BFS to traverse the graph, keeping track of the parent for each node.
- If you encounter a visited neighbor that isn't the parent, a cycle exists.
- Return true if a cycle is found; otherwise, return false.

### Topological Sort (Using DFS)

1. **Idea**: Topological sorting of a Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge `u → v`, vertex `u` comes before `v`. DFS is used to ensure that once a vertex is visited, all its dependencies (adjacent vertices) are processed before it.

---

2. **Steps**:
    - **Visited Array**: Use a boolean array `vis[]` to track whether each vertex has been visited.
    - **DFS Traversal**:
        - For each unvisited node, perform DFS to explore its adjacent nodes.
        - After exploring all adjacent nodes of a vertex, push the vertex onto a stack (this ensures that the dependencies are processed before the vertex).
    - **Result Construction**:
        - Once DFS completes, the stack will have the vertices in topologically sorted order. Pop elements from the stack to form the final result.
    - **Cycle Detection**:
        - If the stack size does not match the number of vertices (i.e., some nodes were not added due to cycles), return `{-1}` to indicate a cycle, as topological sorting is only possible in DAGs.

---

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (DFS processes each vertex and edge once).

4. **Space Complexity**: O(V), for the recursion stack and the stack used for the topological order.

---

**Gist**:
- Use DFS to visit all nodes and push them onto a stack after all their dependencies are processed.
- If any node is part of a cycle, return `{-1}`.
- Pop from the stack to get the topological order.
### Detecting a Cycle in a Directed Graph Using Kahn's Algorithm (Topological Sort with BFS)

1. **Idea**: In a directed graph, if we can perform a **Topological Sort** of all the vertices, the graph is **acyclic** (i.e., it does not contain any cycles). Kahn's Algorithm (BFS-based topological sort) can be used to detect a cycle in a directed graph by checking if all vertices can be processed. If any vertices are left unprocessed, it indicates the presence of a cycle.

---

2. **Steps**:
    - **In-degree Calculation**:
        - For each vertex, calculate its **in-degree** (the number of edges directed towards it).
    - **Queue Initialization**:
        - Enqueue all vertices with **in-degree 0** (vertices with no incoming edges).
    - **BFS Traversal**:
        - Process each vertex by dequeuing it, adding it to the result list, and reducing the in-degree of all its adjacent vertices.
        - If any adjacent vertex's in-degree becomes zero, enqueue it.
    - **Cycle Detection**:
        - After processing, if the size of the result list (the topological sort) is less than the number of vertices `V`, this means that there are vertices that could not be processed due to a cycle. In such cases, return `true` indicating a cycle.
        - If all vertices are processed, return `false` (no cycle).

---

3. **Time Complexity**: O(V + E), where V is the number of vertices and E is the number of edges (BFS processes each vertex and edge once).

4. **Space Complexity**: O(V), for storing the in-degree array and the BFS queue.

---

**Gist**:
- Calculate in-degrees for all vertices.
- Use BFS (Kahn's Algorithm) to process vertices with in-degree 0.
- If all vertices are processed, the graph is acyclic; otherwise, a cycle exists.

### Alien Dictionary Problem (Using Topological Sort)

1. **Idea**:
    - Given a sorted dictionary of alien words, we need to find the order of characters in the alien language.
    - The problem can be solved by comparing adjacent words in the dictionary and deducing the relative order of characters.

---

2. **Steps**:

    - **Step 1: Build the Graph**:
        - Treat each character as a node.
        - For each pair of adjacent words (`s1`, `s2`), compare characters until you find the first mismatch.
        - If `s1[i] != s2[i]`, this implies that `s1[i]` comes before `s2[i]` in the alien dictionary. Add an edge from `s1[i]` to `s2[i]` in the graph.
        - Skip the rest of the characters once a difference is found.

    - **Step 2: Calculate In-degrees**:
        - Track the in-degree (number of incoming edges) for each character using an array.

    - **Step 3: Topological Sort (Kahn's Algorithm)**:
        - Enqueue all characters with in-degree 0 (no dependencies).
        - Process each character by reducing the in-degree of its neighbors and enqueue the neighbors when their in-degree becomes 0.
        - Append characters to the result in the order they are processed.

    - **Step 4: Check for Cycles**:
        - If the result length is less than `k` (number of characters in the alien language), it means there’s a cycle (invalid order), and return an empty string.

---

3. **Time Complexity**:
    - **Graph Construction**: O(N * min(L1, L2)), where N is the number of words, and L1, L2 are the lengths of the compared words.
    - **Topological Sort**: O(V + E), where V is the number of unique characters (vertices) and E is the number of edges in the graph.
    - Overall, the complexity is **O(N * L + V + E)**.

4. **Space Complexity**: O(V + E), for storing the graph and in-degree array.

---

**Gist**:
- Build a directed graph from adjacent words in the dictionary by comparing characters.
- Use topological sort to determine the correct order of characters.
- If the topological sort doesn't cover all characters, the dictionary is inconsistent, and a cycle exists.

## Typical mistakes to avoid
* while comparing the chars, just check if they are equal or not. if not, remember first char did come before second char 
* no need to compare them with < or >
* check what to return in case of cycle , don't return null blindly
* Use a Set for graph, not list, as the edges will repeat if there are multiple words
* same with indegrees, calculate once you done with Graph

### Shortest Path in a Directed Acyclic Graph (DAG) Using DFS-based Topological Sort

1. **Idea**:
    - Given a Directed Acyclic Graph (DAG) with weighted edges, the shortest path from a source to all other vertices can be efficiently found using **Topological Sort**.
    - Once the nodes are processed in topologically sorted order, we can relax the edges to compute the shortest path.

---

2. **Steps**:

    - **Step 1: Build the Graph**:
        - Represent the graph using an adjacency list, where each node points to its adjacent node along with the weight of the edge.

    - **Step 2: Perform Topological Sort (DFS-based)**:
        - Perform DFS for each unvisited node.
        - Once all its adjacent nodes have been visited, push the node onto a stack (this ensures that all dependencies are processed before the node itself).

    - **Step 3: Relax the Edges**:
        - Initialize the distance array with a large value (`1e9`), except for the source node, which is set to 0.
        - Pop nodes from the stack and for each node, update the shortest distance for its adjacent nodes (relax the edges).

    - **Step 4: Handle Unreachable Nodes**:
        - If any node remains unreachable from the source, set its distance to `-1`.

---

3. **Time Complexity**:
    - **Graph Construction**: O(M), where M is the number of edges.
    - **Topological Sort (DFS)**: O(V + E), where V is the number of vertices and E is the number of edges.
    - **Relaxation of Edges**: O(V + E).
    - **Overall Complexity**: O(V + E), where V is the number of vertices and E is the number of edges.

4. **Space Complexity**: O(V + E) for storing the adjacency list, distance array, and the stack.

---

**Gist**:
- Perform **DFS-based topological sort** to process the nodes in a valid order.
- Use this order to **relax the edges** and compute the shortest path from the source.
- Handle nodes that are unreachable from the source by setting their distance to `-1`.

## Typical mistakes to avoid
* do not forget to create Graph with edges as int[] as it will have v and wt
* while iterating adjacent nodes, make sure to consider the array
* take 1e9 instead of INT MAX in distance array, int overflow will not happen while doing relaxation of edges
* Do not forget to mark distance[src] = 0
* use DFS+ stack for Topological sort ( easy to implement)

### Shortest Path in an Undirected Graph with Unit Weights (Using BFS)

1. **Idea**:
   - In an **undirected graph** with **unit weights** (i.e., all edges have a weight of 1), the shortest path from a source node to all other nodes can be efficiently computed using **Breadth-First Search (BFS)**.
   - BFS guarantees that nodes are processed in order of increasing distance from the source.

---

2. **Steps**:

   - **Step 1: Graph Representation**:
      - Represent the graph using an adjacency list, where each node points to its connected neighbors.

   - **Step 2: Initialize Distance Array**:
      - Create a `distance[]` array initialized to a large value (`1e9`) to represent infinite distances.
      - Set the distance of the source node `src` to 0, as the distance from the source to itself is zero.

   - **Step 3: BFS Traversal**:
      - Start BFS from the source node.
      - For each node dequeued, check all its adjacent nodes.
      - If the distance to an adjacent node can be improved (i.e., `distance[node] + 1 < distance[adjNode]`), update the distance and enqueue the adjacent node.

   - **Step 4: Handle Unreachable Nodes**:
      - After BFS, if any node's distance is still `1e9`, it means the node is unreachable from the source, so set its distance to `-1`.

---

3. **Time Complexity**:
   - **Graph Construction**: O(M), where M is the number of edges.
   - **BFS Traversal**: O(V + 2E), where V is the number of vertices and E is the number of edges. Each edge is considered twice since the graph is undirected.

4. **Space Complexity**: O(V + 2E) for storing the adjacency list and the queue.

---

**Gist**:
- Use **BFS** to explore the graph level by level, updating the shortest distance to each node.
- If any node remains unreachable from the source, set its distance to `-1`.
- BFS guarantees that nodes are processed in the order of increasing distance from the source in graphs with unit weights.

## Typical mistakes to avoid
* While constructing graph, do not forget to add edges both ways if it's an undirected Graph
* no need of vis array, use distance array as vis array
* when distance array got updated, add the adjNode to queue because we got lesser distance than prev path or we didn't cover this path 

### Dijkstra’s Algorithm (Using Priority Queue)

1. **Idea**:
    - **Dijkstra’s Algorithm** is used to find the shortest path from a source node `S` to all other nodes in a graph with non-negative weights.
    - A **priority queue (min-heap)** is used to always process the node with the currently known shortest distance.
    - As we process each node, we relax the edges to its neighbors by updating their shortest known distances.

---

2. **Steps**:

    - **Step 1: Initialize Distance Array**:
        - Create a `distance[]` array initialized to a large value (`1e9`) to represent infinity.
        - Set the distance of the source node `S` to `0`, as the distance from the source to itself is zero.

    - **Step 2: Min-Heap (Priority Queue)**:
        - Use a priority queue (min-heap) to store pairs of the form `<distance, node>`. Initially, enqueue the source node with a distance of `0`.

    - **Step 3: Process the Nodes**:
        - While the priority queue is not empty:
            - Dequeue the node with the smallest distance.
            - For each adjacent node (neighbor):
                - If the current known distance to the adjacent node can be improved (i.e., `distance[adjNode] > distance[node] + edgeWeight`), update the distance and enqueue the adjacent node with the new distance.

    - **Step 4: Handle Unreachable Nodes**:
        - After processing, if any node's distance is still `1e9`, set its distance to `-1`, indicating that the node is unreachable from the source.

---

3. **Time Complexity**:
    - **Priority Queue Operations**: O((V + E) log V), where V is the number of vertices and E is the number of edges.
    - **Overall Complexity**: O((V + E) log V).

4. **Space Complexity**: O(V + E) for storing the adjacency list and the priority queue.

---

**Gist**:
- Use Dijkstra's Algorithm with a **priority queue** to efficiently find the shortest path from the source node to all other nodes.
- **Relax the edges** of each node by updating the shortest known distances to its neighbors.
- If a node remains unreachable, set its distance to `-1`.

### Bellman-Ford Algorithm

1. **Idea**:
    - **Bellman-Ford Algorithm** is used to find the shortest path from a source node `S` to all other nodes in a graph. It works for graphs with **negative weights** and can detect **negative weight cycles**.
    - The algorithm relaxes all edges up to `V-1` times (where `V` is the number of vertices).
    - If after `V-1` relaxations, any further relaxation occurs, it indicates the presence of a **negative weight cycle**.

---

2. **Steps**:

    - **Step 1: Initialization**:
        - Create a `distance[]` array initialized to a large value (`1e8`), representing infinite distances.
        - Set the distance of the source node `S` to `0`.

    - **Step 2: Relaxation of Edges (V-1 times)**:
        - For each edge `(u, v, wt)`, check if the current distance to `v` can be minimized by using edge `(u → v)` (i.e., `distance[u] + wt < distance[v]`).
        - If it can be minimized, update `distance[v] = distance[u] + wt`.

    - **Step 3: Check for Negative Cycles**:
        - After `V-1` relaxations, do a final pass through all edges.
        - If any edge can still be relaxed (i.e., distance can be minimized further), it means there is a **negative weight cycle** in the graph, and return `{-1}` to indicate the presence of such a cycle.

    - **Step 4: Return Distance Array**:
        - If no negative weight cycle is found, return the `distance[]` array containing the shortest path from the source to all other vertices.

---

3. **Time Complexity**:
    - **Relaxation Process**: O(V * E), where V is the number of vertices and E is the number of edges.
    - **Overall Complexity**: O(V * E) due to the V-1 relaxations and a final cycle detection pass.

4. **Space Complexity**: O(V) for storing the distance array.

---

**Gist**:
- Relax all edges **V-1 times** to ensure the shortest path is computed.
- If any edge can still be relaxed in the **Vth pass**, there is a **negative weight cycle**.
- Bellman-Ford is useful for graphs with **negative weights** and **cycle detection**.

## Typical mistakes to avoid
* do not forget to mark distance[Source] = 0
* first loop is from 0 to V-1 , nested loop should iterate over all edges

### Floyd-Warshall Algorithm

1. **Idea**:
    - The **Floyd-Warshall Algorithm** is used to find the shortest path between all pairs of nodes in a graph.
    - It works on a dynamic programming approach where we iteratively improve the solution by considering every node as an intermediate node.
    - It works for graphs with negative weights but cannot handle negative weight cycles.

---

2. **Steps**:

    - **Step 1: Initialize Distance Matrix**:
        - Initialize a `distance[][]` matrix based on the input adjacency matrix:
            - If `matrix[i][j] == -1`, this means there's no direct path between `i` and `j`, so set `distance[i][j]` to infinity (`1e9`).
            - For diagonal elements (`distance[i][i]`), set them to `0`, as the shortest distance from any node to itself is `0`.

    - **Step 2: Dynamic Programming (Go Via Nodes)**:
        - Iterate over all possible intermediate nodes `via`. For each pair of nodes `(i, j)`:
            - If the path `i → via → j` is shorter than the direct path `i → j`, update `distance[i][j]`:
              ```java
              distance[i][j] = min(distance[i][j], distance[i][via] + distance[via][j])
              ```

    - **Step 3: Check for Negative Cycles**:
        - If any diagonal element `distance[i][i]` becomes negative after the computation, it indicates the presence of a **negative weight cycle**.
        - In this implementation, an exception is thrown if a negative cycle is found.

    - **Step 4: Update Unreachable Paths**:
        - After all iterations, if any distance remains as infinity (`1e9`), it means that the corresponding node pair is unreachable, so set it to `-1`.

---

3. **Time Complexity**:
    - **O(V^3)**, where V is the number of vertices. This is because there are three nested loops: one for intermediate nodes, one for the source node, and one for the destination node.

4. **Space Complexity**:
    - **O(V^2)** for storing the distance matrix.

---

**Gist**:
- Use the **Floyd-Warshall Algorithm** to find the shortest paths between all pairs of nodes.
- For each node pair `(i, j)`, check if the path through an intermediate node is shorter than the direct path.
- If any diagonal element becomes negative, it means there's a **negative cycle**.

## Typical mistakes to avoid
* If you don't want to make changes to marix array, don't just do distance = matrix at the end, copy element by element in two loops
* If there are no negative edges , apply Dijkstra from each source . This would take N * E log V lesser than N^3

### Prim's Algorithm for Minimum Spanning Tree (MST)

1. **Idea**:
    - **Prim’s Algorithm** is used to find the **Minimum Spanning Tree (MST)** in a weighted, undirected graph. An MST is a subset of edges that connects all the vertices with the minimum possible total edge weight.
    - The algorithm starts from an arbitrary node and grows the MST by adding the smallest available edge that connects the tree to a vertex outside the MST.

---

2. **Steps**:

    - **Step 1: Initialize the Priority Queue (Min-Heap)**:
        - Use a priority queue (min-heap) to always pick the edge with the smallest weight.
        - Push the starting node (usually node 0) with weight 0 into the queue.

    - **Step 2: Build the MST**:
        - Extract the minimum weight edge from the priority queue.
        - If the node connected by this edge has already been visited, skip it (to avoid cycles).
        - Otherwise, add the node to the MST and mark it as visited.
        - For every unvisited adjacent node of the current node, push the edge to the adjacent node into the priority queue.

    - **Step 3: Check for MST Completion**:
        - After processing all edges, check if the number of nodes added to the MST is equal to the total number of vertices (`V`).
        - If not all nodes are added, return `-1`, indicating that the graph is disconnected, and an MST cannot be formed.

    - **Step 4: Return the Sum of Weights**:
        - Return the total sum of the edge weights in the MST.

---

3. **Time Complexity**:
    - **O((V + E) log V)**, where V is the number of vertices and E is the number of edges.
    - Each vertex is added to the priority queue once, and each edge is processed once.

4. **Space Complexity**:
    - **O(V + E)** for storing the adjacency list and the priority queue.

---

**Gist**:
- Use a **priority queue** to always pick the edge with the smallest weight that connects a node outside the MST.
- If all vertices are added to the MST, return the total weight.
- If some vertices remain unconnected, return `-1` to indicate a disconnected graph.

## Typical Mistakes to avoid
* Iterate over the input carefully, don't consider everything as List<>[] G
* Make sure to see the order ( node, wt ) while adding and retrieving from queue, use a class to avoid confusion
* Make sure to see the order while accessing things from graph
* Do not add vis array within the for loop , add it while popping from PQ after filtering the vis.


## Kruskal's Algorithm for Minimum Spanning Tree (MST)

### Key Concepts:

1. **Graph Representation**:
   - The graph is represented as an adjacency list, where each node has a list of adjacent nodes and the corresponding edge weights.

2. **Kruskal’s Algorithm**:
   - Kruskal’s algorithm is a **greedy algorithm** that finds the MST of a graph by sorting all edges in non-decreasing order of their weights and adding them to the MST if they don’t form a cycle.
   - To prevent cycles, we use the **Disjoint Set (Union-Find)** data structure.

3. **Disjoint Set (Union-Find)**:
   - Used to keep track of which vertices are connected in the MST. It supports two operations:
      - **Find**: To determine the set (or parent) a vertex belongs to.
      - **Union**: To merge two sets.
   - The **union by size** strategy ensures that the smaller tree is attached to the root of the larger tree, keeping the tree flat and making the operations efficient.

---

### Steps in the Code:

1. **Convert Adjacency List to Edge List**:
   - Traverse the adjacency list to create a list of edges. Each edge is represented as a triplet `(u, v, weight)` where `u` and `v` are vertices and `weight` is the edge weight.

2. **Sort the Edges**:
   - Sort all the edges based on their weights in non-decreasing order.

3. **Initialize the Disjoint Set**:
   - Use the **Disjoint Set** data structure to track the connected components and avoid cycles.

4. **Iterate Over Edges**:
   - For each edge, check if the vertices `u` and `v` are in different sets (i.e., they don't form a cycle).
   - If they are in different sets, add the edge to the MST and unite the sets.

5. **Return the Total MST Weight**:
   - The total weight of the MST is accumulated and returned after processing all edges.

---

### Time Complexity:
- **O(N + E)** for building the edge list, where `N` is the number of vertices and `E` is the number of edges.
- **O(M log M)** for sorting the edges, where `M` is the total number of edges.
- **O(M * 4 * α)** for the Disjoint Set operations (union-find with path compression), where `α` is the inverse Ackermann function, which grows very slowly and can be treated as constant for practical purposes.

### Space Complexity:
- **O(N + E)** for storing the graph and Disjoint Set data.

## Kosaraju’s Algorithm for SCC (Strongly Connected Components)

### Steps:

1. **Step 1: Perform DFS to determine the finishing order of vertices**:
    - Perform **DFS** on the original graph and push each vertex to a stack **after finishing its DFS** (when all its adjacent nodes are processed).
    - This stack will have nodes in decreasing order of their finish times.

2. **Step 2: Reverse the Graph**:
    - Reverse all the edges of the original graph to create a **transposed (reverse) graph**.

3. **Step 3: Process vertices in the order of the stack**:
    - Reset the visited array.
    - Now, perform **DFS** on the reversed graph, starting from the vertices in the order they were finished (popped from the stack).
    - Each DFS call on the reversed graph will give one **Strongly Connected Component (SCC)**.

4. **Count the SCCs**:
    - Count how many times a new DFS is triggered on the reversed graph, as each new DFS indicates a new SCC.

---

### Time Complexity:
- **O(V + E)**, where `V` is the number of vertices and `E` is the number of edges.
    - First DFS takes O(V + E) time.
    - Reversing the graph takes O(V + E) time.
    - Second DFS (on the transposed graph) takes O(V + E) time.

### Space Complexity:
- **O(V + E)** for storing the graph and the transposed graph.
- **O(V)** for the visited array and stack.

---

### Code Breakdown:

1. **DFS on the original graph**:
    - Store vertices in a stack in the order of their DFS completion.

2. **Reverse the graph**:
    - Reverse all edges to get the transposed graph.

3. **DFS on the reversed graph**:
    - Process vertices in the order of the stack and count SCCs.

---

### Example Use Case:
- **Find SCCs** in a directed graph to determine which nodes are part of a cycle or influence other nodes strongly.

Kosaraju’s Algorithm is efficient for identifying SCCs in directed graphs.


## Critical Connections in a Network (Bridges) using Tarjan's Algorithm

### Problem Overview:
- We are given a network of `n` servers and `connections` between them. A **critical connection** (bridge) is an edge that, when removed, would make the graph disconnected.
- The goal is to find all such critical connections (bridges).

---

### Key Concepts:

1. **DFS Traversal**:
    - We perform a DFS traversal, exploring all nodes and marking them as visited.

2. **Discovery Time**:
    - Track the **discovery time** (`time[]`) of each node during DFS traversal. This represents when the node is first visited.

3. **Low-Link Values**:
    - Use a `low[]` array to keep track of the **lowest point** (i.e., the earliest visited node) that can be reached from the subtree rooted at the current node.
    - This helps in determining if the connection (edge) between the current node and its adjacent node is a bridge.

4. **Bridge Condition**:
    - If the **low-link value** of an adjacent node is **greater than** the discovery time of the current node, it means there is no other way to reach this adjacent node except through the current node, making the edge a **bridge**.

---

### Steps:

1. **Graph Construction**:
    - Convert the list of `connections` to an adjacency list for easy traversal.

2. **DFS with Tarjan’s Algorithm**:
    - For each node, perform a DFS to explore its neighbors. Track both **discovery times** and **low-link values**.
    - After visiting all adjacent nodes, check if there is any adjacent node whose `low[]` value is greater than the current node's `time[]`. If yes, mark this edge as a **bridge**.

---

### Time Complexity:
- **O(V + E)**, where `V` is the number of vertices (nodes) and `E` is the number of edges (connections). Each edge and vertex is visited once.

### Space Complexity:
- **O(V + E)**, for storing the graph and auxiliary arrays like `time[]`, `low[]`, and `vis[]`.

---

## Check if a Linked List is a Subpath of a Binary Tree

### Problem Overview:
- Given a **singly-linked list** and a **binary tree**, the task is to determine if the linked list exists as a downward path (root to leaf) in the binary tree.
- The path can start from any node in the tree, and it must follow the exact order of nodes from the linked list.

---

### Key Concepts:

1. **Linked List**:
    - Traverse each node in the linked list sequentially.

2. **Binary Tree**:
    - Each node has up to two children: left and right.
    - We need to search the tree to find paths that match the linked list.

---

### Algorithm:

1. **Base Case**:
    - If the `head` of the linked list is `null`, return `true` (an empty list is a subpath).
    - If the `root` of the binary tree is `null` and the list still has nodes, return `false`.

2. **DFS Search**:
    - **dfs(ListNode head, TreeNode root)**:
        - This function checks if the current node in the linked list (`head`) matches the current node in the binary tree (`root`).
        - If they match, recursively check the next node in the linked list (`head.next`) with both the left and right children of the tree node.

3. **Search Entire Tree**:
    - For each node in the binary tree, initiate a DFS search using `isSubPath`:
        - Try to match the list starting from the current root, left child, and right child recursively.
## Checking Linked List as a Subpath in a Binary Tree using KMP Algorithm

### Problem Overview:
- Given a **singly-linked list** and a **binary tree**, we need to determine if the linked list exists as a downward path (from root to leaf) in the binary tree.
- The problem is tackled using the **Knuth-Morris-Pratt (KMP) algorithm**, typically used for string matching, to efficiently match the linked list with the path in the binary tree.

---

### Key Concepts:

1. **KMP Algorithm**:
    - The **KMP algorithm** is used for pattern matching in strings. It efficiently skips unnecessary comparisons using a **longest prefix-suffix (LPS)** table.
    - In this problem, the linked list is treated as the **pattern** to search for in the binary tree's node values.

2. **LPS Array**:
    - The **LPS table** helps us store the length of the longest proper prefix of the pattern that is also a suffix, which is used to skip comparisons.
    - The LPS array is computed for the values in the linked list, allowing us to optimize the comparison between the linked list and the binary tree.

---

### Steps:

1. **Convert Linked List to Array**:
    - The linked list is converted into an array to be used as the pattern for the KMP search.

2. **Compute the LPS Array**:
    - Compute the LPS table for the linked list values to optimize pattern matching using the KMP algorithm.

3. **DFS with KMP Search**:
    - Perform a **depth-first search (DFS)** on the binary tree and match the tree nodes with the linked list values using the KMP pattern matching.
    - For each node, compare its value with the corresponding value from the linked list (using the KMP technique). If the values match, continue the search recursively down the left and right subtrees.
    - If the linked list values are exhausted (i.e., fully matched), return `true`.

