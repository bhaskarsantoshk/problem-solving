# Dynamic Programming

* Characteristics of a problem that can be solved using DP:
  *   Optimal Substructure : If it's possible to breakdown a problem into smaller sub problems 
and an optimal solution to these problems contribute to the solution of the given problem, we can say
Optimal substructure exists for such problem. 
  *   Overlapping Sub problems : solution to the overall problem requires solving some of the sub problems
  repeatedly. 

* Note:
  *   Not all recursive problems an be optimized using DP. For example, if the sub problems are distinct.
  *   Problems that can be solved using Greedy technique ( Minimal Spanning Tree (Kruskal's Algo), Shortest Path (Dijkstra's algo)) 
  *   Some problems do require a global optimal solution and greedy technique will cause us to miss it in some cases, we would need an exhaustive search - 
  such problems can be solved using Backtracking. For example: Cross words, Sudoku etc. 
  
* TWo ways to implement DP: Top Down (Memoization) & Bottom Up ( Tabulation )
* In scenarios, the recusrive call stack exceeds the max depth of recusrion supported by the machin - Bottom up will be considered over Top Down
* 

