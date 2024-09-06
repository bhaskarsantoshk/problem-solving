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