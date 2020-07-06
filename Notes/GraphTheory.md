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