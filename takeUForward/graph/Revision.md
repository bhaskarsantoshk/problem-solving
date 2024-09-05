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

## Typipcal mistakes to avoid
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

## Typipcal mistakes to avoid
* don't mis type node and adjNodes
* take the parameter as start, node as q.poll()
* don't forget for ( int adjNode: adj.get(node))
* don't need to pass in the color from caller func if it's a BFS, always start with 0 color
* use colors[adjNode] as 1-colors[node] , not some color variable if colors[adjNode] is -1
* if ( colors[adjNode] == colors[node]) return false