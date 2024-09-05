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