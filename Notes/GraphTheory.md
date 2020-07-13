# Graph theory notes   
Reference : [Algorithms Course - Graph Theory Tutorial from a Google Engineer](https://www.youtube.com/watch?v=09_LlHjoEiY).  

## Brief Introduction:  
## Graph theory:  
> Graph theory is the mathematical theory of the properties and applications of Graphs ( Networks ).   
> The Canonical Graph theory example is a social network of friends. This enables interesting questions such as: How many friends does X have? How many degrees of separation is there between Person X and Person Y?

## Types of Graphs:  

### Undirected Graph :
> Undirected Graph is a graph in which edges have no orientation.  
> The Edge (u,v) is identical to Edge (v,u).     
> Example: Cities as nodes and bi directional roads as edges.    


### Directed Graph ( Digraph ) :    
> Directed Graph or Digraph is a graph in which edges have orientation.
> For example, the edge (u,v) represents an edge from node u to node v.

### Weighted Graph:   
> a graph can have edges that contain certain weight to represent an arbitrary value such as cost, distance, quantity etc.
> representation of an edge (u, v, w) : u,v nodes and w: weight

## Special Graphs:    

### Trees:
> A Tree is an undirected graph with no cycles.    
> Equivalently, it is a connected graph with n nodes and n-1 edges.

### Rooted Trees:   
> A rooted tree is a tree with a designated root where every edge either points away from or towards trhe root node.    
> When edges point away from the root node, the graph is called an arborescnece ( out-tree).   
> When edges point towards the root node, the graph is called anti-arborescence (in-tree).    

### Directed Acyclic Graphs ( DAGs):    
> DAGs are directed graphs with no cycles. These graphs play an important role in representing structures with dependencies.    
> Several efficient algorithms exist to operate on DAGs. 
> All out-trees are DAGs but not all DAGs are not out-trees. 


### Bipartite Graph:   
> A Bipartite graph is one in whose vertices can be split into two independant groups U and V such that every edge connecte between U and V.    
> The graph is two colorable and there is no odd length cycle. 

### Complete Graph:    
> A complete graph is one in which there is unique edge between evcery pair of nodes.     
> A complete graph with n vertices is denoted as Kn. 

## Representation of Graphs:   
### Adjacency Matrix: 
> It's very simple way of representing a graph.   
> The idea is that each cell in the matrix m[i][j] represents edge weight of going from node i to node j.    
> It's often assumed that edge of going from node to itself has a cost of 0. 

| Pros | Cons |
| ----------- | ----------- |
| Space efficient for representing dense graphs | Requires O(V^2) space |
| Edge weight lookup is O(1) | Iterating over all edges takes O(V^2) time |
| Simplest Graph representation |  |

### Adjacency List: 
> It's a way to represent a graph as a map from nodes to lists of edges.    

> Example: 
```
A -> [(B,4), (C,1)]
B -> [(C,6)]
C -> [(A,4), (B,1), (D,2)]
D -> []

# Node C can reach A at cost of 4, B at cost of 1 and D at cost of 2.
```

| Pros | Cons |
| ----------- | ----------- |
| Space efficient for representing sparse graphs | Less space efficient for representing dense graphs |
| Iterating over all edges is efficient | Edge weight lookup is O(E) |
| | Slightly more complex Graph representation  |


### Edge List: 
> It's a way to represent a graph simply as an unordered lists of edges.  
> It's seldomly used due to unordered structure

> Example: 
```
[(C,A,4), (A,C,1), (B,C,6), (A,B,4)]
```

| Pros | Cons |
| ----------- | ----------- |
| Space efficient for representing sparse graphs | Less space efficient for representing dense graphs |
| Iterating over all edges is efficient | Edge weight lookup is O(E) |
|Simple Graph representation |  |

## Common Graph Theory Problems
#### Ask yourself the following:
> Is the graph directed or undirected ?      
> Are the edges of the graph weighted ?
> Is the graph I will encounter likely to be sparse or dense with edges ?
> Should I use adjacency matrix , adjacency list, edge list or other structures to represent the graph efficiently?

* Shortest Path Problem:     
> Given a weighted graph, find the shortest path of edges from A to B.   
> Algorithms: BFS (Unweighted graph), Dijkstra's, Bellman Ford, Floyd-Warshall, A*, and many more. 

* Connectivity:    
> Does there exist a path between A and B?    
> Typical Solution: Use union find data structure or any search algorithm (e.g. DFS)

* Negative Cycles:    
> Does my weighted digraph have any negative cycles? If so, where ?
> Typical Solution: Bellman Ford and Floyd-Warshall

* Strongly Connected Components:   
> self-contained cycles within a directed graph where every vertex in a given cycle can reach every other vertex in the same cycle. 
> Algorithms: Tarjan's and Kosaraju's Algorithm.   
* Travelling Salesman Problem:   
> Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city and returns to the origin city?    
> Held-Karp, Branch and Bound , many approximation algorithms.  
> TSP is NP-hard, meaning computationally very challenging problem. 

* Bridges:   
> a bridge or cut edge is an edge in a graph whose removal increases the number of connected components. 
> they indicate or hint at weak points, vulnerabilities and bottlenecks in a graph.   

* Articulation Point:    
> an articulation point or cut vertex is a vertex in a graph whose removal increases the number of connected components.    
> they indicate or hint at weak points, vulnerabilities and bottlenecks in a graph.   

* Minimum Spanning Tree:   
> A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. 

> MTS are seen in many applications including: designing a least cost network, circuit design, transporatation networks, etc. 

> Kruskal's, Prim's and Borůvka's Algorithms. 

* Network Flow: max flow:    
> with infinite input source, how much flow can we put through network?   
> Suppose the edges are roads with cars, pipes with water or hallways packed with people, Flow represents the volume of water allowed to flow through pipes, the number of cars on the road can sustain in traffic, and the max amount of people that can navigate through hallways.    
> Algorithms : Ford-Fulkerson, Edmonds-Karp & Dinic's Algorithm. 


# Graph Theory Implementations

* DFS, BFS and Connected Components using DFS, Topological Sort :    [Graph.java](https://github.com/bhaskarsantoshk/problem-solving/blob/master/standard_algorithms/Graph/Graph.java) (Majority part of the code is referred from [GFG](https://www.geeksforgeeks.org/))
