# Graphs

## Types of Graphs
- **Undirected Graph:** Edges have no direction.
- **Directed Graph (Digraph):** Edges have a direction.

## Components
- **Nodes (or Vertices):** Fundamental units of a graph.
- **Edges:**
  - **Undirected Edges:** Connections between nodes without a direction.
  - **Directed Edges:** Connections with a specific direction.

## Graph Structures
- **Cycles:**
  - **Undirected Cyclic Graph:** At least one cycle in an undirected graph.
  - **Directed Acyclic Graph (DAG):** Directed graph without cycles.
  - **Directed Cyclic Graph (DAG):** Directed graph with at least one cycle.

## Paths
- A sequence of nodes where each node is reachable, appears once, and adjacent nodes have an edge between them.

## Degree
- **Degree of a Node:** Number of edges attached to a node.
- **Total Degree (Undirected Graph):** Twice the number of edges (D = 2 * E).

## Directed Graph Degree
- **In-Degree:** Number of incoming edges to a node.
- **Out-Degree:** Number of outgoing edges from a node.

## Edge Weight
- Each edge has a weight, default unit weight is 1.

# Graph Representation

## Input Format
- **Directed/Undirected:** Mentioned in the question.
- **Nodes:** n (number of nodes).
- **Edges:** m (number of edges).
- **Edge Descriptions:** m lines representing edges.

### Example
Consider a graph with 5 nodes and 6 edges:

**Input:**

**Undirected**  
5  
6  
1 2  
2 3  
3 4  
4 5  
5 1  
2 5



## Matrix Representation
- Create a 2D array G of size (n+1) x (n+1).
- If there is an edge between nodes i and j, set G[i][j] and G[j][i] to 1.

### Java Code
```java
int n = 5; // Number of nodes
int m = 6; // Number of edges
int[][] G = new int[n + 1][n + 1];

// Read edges
for (int i = 0; i < m; i++) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    G[x][y] = 1;
    G[y][x] = 1;
}
```
**Space Complexity:** O(n^2)

## Adjacency List Representation
Create an array of lists, where each index represents a node.
Each list contains the nodes adjacent to the corresponding node.

**Java Code:**
```java
import java.util.ArrayList;
import java.util.List;

int n = 5; // Number of nodes
int m = 6; // Number of edges
List<Integer>[] adjList = new ArrayList[n + 1];

// Initialize the adjacency list
for (int i = 1; i <= n; i++) {
    adjList[i] = new ArrayList<>();
}

// Read edges
for (int i = 0; i < m; i++) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    adjList[x].add(y);
    adjList[y].add(x);
}
```
**Space Complexity:** O(n + m), where n is the number of nodes and m is the number of edges.

## Weighted Graph Adjacency List Representation in Java

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightedGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 5; // Number of nodes
        int m = 6; // Number of edges
        List<Edge>[] adjList = new ArrayList[n + 1];

        // Initialize the adjacency list
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Read edges and weights
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int weight = scanner.nextInt();

            adjList[x].add(new Edge(y, weight));
            adjList[y].add(new Edge(x, weight));
        }
    }
}

class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
```
## Connected Components in Graphs

- **Definition:** A connected component in a graph is a subgraph where every pair of vertices has a path between them, and there are no paths outside the subgraph.

- **Characteristics:**
  - Graph in Pieces: Represented by distinct subgraphs.
  - Single Graph, Multiple Components: A graph can have several connected components.

- **Traversal Approach:**
  - **Visited Array:** During any traversal algorithm, use a visited array to mark explored nodes.
  - **Isolation of Components:** Traversal algorithms ensure isolation of components by not reaching nodes outside the current component.
  - **Algorithmic Design:** Designed to traverse all nodes within a connected component, marking them as visited.
  - **Repetition:** Repeat the traversal algorithm for unvisited nodes to discover multiple components.

- **Implementation Overview:**
  - Utilize any traversal algorithm (e.g., DFS, BFS).
  - Maintain a visited array to track explored nodes.
  - Traverse and mark nodes, creating distinct components.
  - Repeat for unvisited nodes to find additional components.

- **Example:**
  - Graph:
    ```
    0 -- 1    2 -- 3
        |    |
    4 -- 5    6
    ```
  - Connected Components: [\[0, 1, 5, 4\], \[2, 3, 6\]]

- **Applications:**
  - Image Segmentation
  - Social Network Analysis
  - Component Labeling in Computer Vision

## Breadth-First Search (BFS)

- **Starting Node:** Begins at level 0.

- **Node Levels:** Nodes are assigned levels based on their distance from the starting node.

- **Dynamic Levels:** Changing the starting node alters the levels.

- **Traversal Pattern:** BFS traverses nodes level-wise.

- **Order Flexibility:** Nodes within a level can be traversed in any order.

### Example:

Starting Node: A

Levels:
- 0: A
- 1: B, C
- 2: D, E, F
- 3: G


### Key Points:

- BFS explores neighboring nodes before moving to the next level.
- Well-suited for finding the shortest path in unweighted graphs.
- Utilizes a queue data structure for efficient implementation.

  
## Breadth-First Search (BFS) Algorithm

BFS is a graph traversal algorithm that explores nodes level-wise. It uses a queue data structure to efficiently process nodes. Here's a concise explanation:

1. **Initialization:**
   - Start with a queue containing the initial node (e.g., starting node 'A').
   - Create a visited array, initialized to `false` for each node. If nodes are 1-based, create an array of size `#nodes + 1`.

2. **Queue Processing Loop:**
   - While the queue is not empty:
     - Dequeue a node from the front of the queue.
     - Mark the node as visited in the visited array.
     - Enqueue all unvisited neighbors of the dequeued node.

3. **Traversal Order:**
   - Nodes are processed in the order they are dequeued, leading to a level-wise traversal.

4. **Implementation Overview:**
   - Utilize an adjacency list to represent the graph.
   - Check the visited array to avoid processing a node more than once.
```java
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(int start, LinkedList<Integer>[] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " "); // Process the current node

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int numNodes = 7; // Number of nodes in the graph
        LinkedList<Integer>[] graph = new LinkedList[numNodes + 1];

        // Initialize the adjacency list (1-based indexing)
        for (int i = 1; i <= numNodes; i++) {
            graph[i] = new LinkedList<>();
        }

        // Example edges for the graph
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(4);
        graph[2].add(5);
        graph[3].add(6);
        graph[3].add(7);

        boolean[] visited = new boolean[numNodes + 1];
        System.out.println("BFS Traversal:");
        bfs(1, graph, visited);
    }
}
```

## Time Complexity of BFS

The time complexity of Breadth-First Search (BFS) is typically expressed in terms of the number of vertices (nodes) and edges in the graph.

- **Time Complexity:** O(V + E)
  - V: Number of vertices (nodes) in the graph.
  - E: Number of edges in the graph.

BFS traverses each vertex and each edge once, resulting in a linear time complexity proportional to the sum of vertices and edges.

## Explanation

1. **Queue Operations:**
   - Each vertex is enqueued and dequeued at most once.
   - Enqueue and dequeue operations take O(1) time.

2. **Adjacency List Processing:**
   - Visiting neighbors of a vertex takes O(deg(v)) time, where deg(v) is the degree of vertex v (the number of edges incident to v).
   - Summing up the degrees of all vertices gives the total number of edges in the graph.

3. **Overall Complexity:**
   - The main loop runs O(V) times, as each vertex is processed once.
   - The inner loop processes each edge once, resulting in O(E) time complexity for adjacency list processing.

4. **Total Time Complexity:**
   - O(V + E)

## Key Points

- BFS is efficient for sparse graphs with fewer edges.
- The constant factor in the time complexity is relatively small, making BFS practical for many real-world applications.
- For dense graphs (where E is close to V^2), adjacency matrix representation might be more suitable.

## Depth-First Search (DFS)

- **Starting Node:** Begins at the specified starting node.

- **Node Visitation:** Marks nodes as visited during traversal.

- **Traversal Pattern:** DFS explores as far as possible along each branch before backtracking.

- **Stack Usage:** Typically implemented using a stack or recursion.

### Example:

Starting Node: A

Traversal Order: A, B, D, E, F, C, G

### Key Points:

- DFS explores as deeply as possible before backtracking.
- Well-suited for topological sorting and detecting cycles in a graph.
- Recursive or stack-based implementation.

  
## Depth-First Search (DFS) Algorithm

DFS is a graph traversal algorithm that explores as far as possible along each branch before backtracking. It uses a stack or recursion for efficient processing. Here's a concise explanation:

1. **Initialization:**
   - Start with an empty stack (or recursion) and mark all nodes as unvisited.
   - Choose a starting node and push it onto the stack (or call the recursive function).

2. **Traversal Loop:**
   - While the stack (or recursion) is not empty:
     - Pop a node from the stack (or return from the recursive call).
     - If the node is not visited:
       - Mark the node as visited.
       - Process the node.
       - Push all unvisited neighbors onto the stack (or call the recursive function).

3. **Traversal Order:**
   - Nodes are processed in the order they are popped from the stack or return from recursion.

4. **Implementation Overview:**
   - Utilize an adjacency list to represent the graph.
   - Check the visited array to avoid processing a node more than once.
```java
import java.util.LinkedList;

public class DFS {
    public static void dfs(int start, LinkedList<Integer>[] graph, boolean[] visited) {
        // Implementing DFS using recursion
        if (!visited[start]) {
            visited[start] = true;
            System.out.print(start + " "); // Process the current node

            for (int neighbor : graph[start]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int numNodes = 7; // Number of nodes in the graph
        LinkedList<Integer>[] graph = new LinkedList[numNodes + 1];

        // Initialize the adjacency list (1-based indexing)
        for (int i = 1; i <= numNodes; i++) {
            graph[i] = new LinkedList<>();
        }

        // Example edges for the graph
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(4);
        graph[2].add(5);
        graph[3].add(6);
        graph[3].add(7);

        boolean[] visited = new boolean[numNodes + 1];
        System.out.println("DFS Traversal:");
        dfs(1, graph, visited);
    }
}

