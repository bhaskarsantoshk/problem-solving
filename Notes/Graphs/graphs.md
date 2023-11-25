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




