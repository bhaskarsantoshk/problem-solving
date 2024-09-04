# Last minute revision Questions
1. Permutation Sequence
  * To get the k-th permutation of numbers from 1 to n:
    * Precompute factorials to determine the block size for each position. 
    * Select the appropriate number by dividing k by the factorial, then adjust k and repeat until the sequence is built.
2. Cost to Cut a Chocolate
   * Formula:
     For each cut between indices i and j, the cost is cuts[j+1] - cuts[i-1] + f(i, ind-1) + f(ind+1, j), where f(i, j) 
     recursively calculates the minimum cost to cut between i and j. 
   * Use dynamic programming to store intermediate results to avoid recalculations.