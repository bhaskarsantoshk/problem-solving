# BFS
* Take Queue, visited array
* add start node, mark vis to true
* while traversing queue,
  * poll the node , add to result.
  * get adjacent nodes, 
    * if unvisited, add the adjNode to queue, mark it visited
## typical mistakes: 
    * adding node instead of adjNode, not marking the adjNode in vis array