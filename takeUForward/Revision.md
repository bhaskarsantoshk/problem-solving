## Backtracking
### Subsets with Duplicates
- **Goal**: Find all unique subsets of a set that may contain duplicates
- **Approach**:
    1. Sort the array to handle duplicates.
    2. Use backtracking to generate subsets.
    3. Skip adding duplicates by checking if the current element equals the previous one.

- **Time Complexity**: `O(2^n)` (generating all subsets)
- **Space Complexity**: `O(n)` (recursion stack)

```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);  // Sort to handle duplicates
    subsetsWithDup(0, nums, result, new ArrayList<Integer>());
    return result;
}

private void subsetsWithDup(int index, int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
    result.add(new ArrayList<>(list));

    for (int i = index; i < nums.length; i++) {
        if (i != index && nums[i] == nums[i - 1]) continue;  // Skip duplicates
        list.add(nums[i]);
        subsetsWithDup(i + 1, nums, result, list);
        list.remove(list.size() - 1);  // Backtrack
    }
}
```

## Backtracking
### Permutations
- **Goal**: Generate all possible permutations of the array
- **Approach**:
  1. Use backtracking to explore each permutation.
  2. Track used elements with a frequency array (`freq`).
  3. Add a permutation to the result when the current list matches the length of the input array.

- **Time Complexity**: `O(n * n!)` (generating and storing all permutations)
- **Space Complexity**: `O(n)` (recursion stack)

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int[] freq = new int[nums.length];
    permute(nums, result, freq, new ArrayList<Integer>());
    return result;
}

private void permute(int[] nums, List<List<Integer>> result, int[] freq, ArrayList<Integer> list) {
    if (list.size() == nums.length) {
        result.add(new ArrayList<>(list));  // Add valid permutation
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (freq[i] == 0) {  // Check if the element is already used
            freq[i] = 1;
            list.add(nums[i]);
            permute(nums, result, freq, list);
            freq[i] = 0;  // Backtrack
            list.remove(list.size() - 1);
        }
    }
}
```
### Key Points:
	•	Use freq array to track used numbers.
	•	Add permutation when list size equals nums.length.

## Backtracking
### Permutations (In-Place Swap)
- **Goal**: Generate all possible permutations of the array using in-place swapping.
- **Approach**:
  1. Use backtracking by swapping elements.
  2. Swap the current index with each subsequent element to explore all permutations.
  3. Backtrack by swapping back after recursive call.

- **Time Complexity**: `O(n * n!)` (generating and storing all permutations)
- **Space Complexity**: `O(n)` (recursion stack)

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute(0, nums, result);
    return result;
}

private void permute(int index, int[] nums, List<List<Integer>> result) {
    if (index == nums.length) {
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) temp.add(num);
        result.add(temp);  // Add permutation to result
        return;
    }

    for (int i = index; i < nums.length; i++) {
        swap(nums, i, index);  // Swap to generate new permutation
        permute(index + 1, nums, result);
        swap(nums, index, i);  // Backtrack by swapping back
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```
### Key Points:
	•	Use in-place swapping to generate permutations.
	•	Backtrack by swapping elements back after recursive call.


## Backtracking
### Rat in a Maze
- **Goal**: Find all possible paths for the rat to reach the destination in a grid.
- **Approach**:
  1. Move in four possible directions (Up, Down, Left, Right).
  2. Use recursion to explore all possible paths.
  3. Mark cells as visited by setting them to `0`, then backtrack by resetting them.
  4. If destination `(n, m)` is reached, add the path to the result list.

- **Time Complexity**: `O(4^(n*m))` (exploring 4 possible directions for each cell)
- **Space Complexity**: `O(n*m)` (recursion stack and path storage)

```java
public class L19RatInAMazeBacktracking {
    public List<String> findPath(int[][] grid) {
        List<String> result = new ArrayList<>();
        findPath(grid, 0, 0, grid.length - 1, grid[0].length - 1, "", result);
        return result;
    }

    private void findPath(int[][] grid, int i, int j, int n, int m, String s, List<String> result) {
        if (i == n && j == m) {
            result.add(s);  // Add path to result
            return;
        }

        if (grid[i][j] == 0) return;  // Cell blocked or visited

        grid[i][j] = 0;  // Mark as visited

        // Up
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            findPath(grid, i - 1, j, n, m, s + "U", result);
        }
        // Down
        if (i + 1 <= n && grid[i + 1][j] == 1) {
            findPath(grid, i + 1, j, n, m, s + "D", result);
        }
        // Left
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            findPath(grid, i, j - 1, n, m, s + "L", result);
        }
        // Right
        if (j + 1 <= m && grid[i][j + 1] == 1) {
            findPath(grid, i, j + 1, n, m, s + "R", result);
        }

        grid[i][j] = 1;  // Backtrack (unmark the visited cell)
    }
}
```
### Key Points:
	•	Explore all possible directions (Up, Down, Left, Right).
	•	Use backtracking by marking the visited cell and resetting after recursion.
	•	Add path when destination is reached.

## Backtracking
### M-Coloring Problem
- **Goal**: Determine if it’s possible to color a graph using at most `M` colors such that no two adjacent vertices share the same color.
- **Approach**:
  1. Represent the graph as an adjacency list.
  2. Use backtracking to try different colors for each vertex.
  3. Check if the current color assignment is valid for all adjacent vertices.
  4. If a valid coloring is found, return `true`; otherwise, backtrack and try a different color.

- **Time Complexity**: `O(m^n)` (trying all color combinations)
- **Space Complexity**: `O(n)` (to store color assignments)

```java
public class L16MColoringProblemBacktracking {
    boolean graphColoring(int[][] edges, int m, int n) {
        List<Integer>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++) G[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            G[u].add(v);
            G[v].add(u);
        }

        int[] colors = new int[n];
        Arrays.fill(colors, -1);  // Initialize all vertices with no color (-1)
        return dfs(0, G, n, m, colors);
    }

    private boolean dfs(int node, List<Integer>[] g, int n, int m, int[] colors) {
        if (node == n) return true;  // All nodes colored
        for (int num = 1; num <= m; num++) {
            if (isValid(node, g, n, m, colors, num)) {
                colors[node] = num;  // Assign color
                boolean val = dfs(node + 1, g, n, m, colors);
                if (val) return true;  // If valid coloring found, return true
                colors[node] = -1;  // Backtrack
            }
        }
        return false;
    }

    private boolean isValid(int node, List<Integer>[] g, int n, int m, int[] colors, int col) {
        for (int adjNode : g[node]) {
            if (colors[adjNode] == col) return false;  // Adjacent node has the same color
        }
        return true;
    }
}
```

### Key Points:
	•	Use backtracking to try coloring each vertex.
	•	Ensure no two adjacent vertices have the same color.
	•	Backtrack if a valid coloring isn’t possible with the current assignment.

## Backtracking
### Sudoku Solver
- **Goal**: Solve a 9x9 Sudoku puzzle by filling the empty cells (`'.'`) with digits `1-9`, following Sudoku rules.
- **Approach**:
  1. Use backtracking to try digits `1-9` for each empty cell.
  2. Ensure the chosen digit follows Sudoku rules:
    - The digit must not repeat in the current row, column, or 3x3 sub-grid.
  3. If a valid solution is found, return `true`; otherwise, backtrack and try a different digit.

- **Time Complexity**: `O(9^(n*n))` (each cell can have 9 options)
- **Space Complexity**: `O(n*n)` (recursion stack)

```java
public class L15SudokoSolverBacktracking {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board);
    }

    private boolean sudokuSolver(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {  // Empty cell
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (areRulesMat(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (sudokuSolver(board)) return true;  // Valid solution found
                            board[i][j] = '.';  // Backtrack
                        }
                    }
                    return false;  // No valid digit found for current cell
                }
            }
        }
        return true;  // All cells filled
    }

    private boolean areRulesMat(char[][] board, int row, int col, char digit) {
        for (int i = 0; i <= 8; i++) {
            if (board[i][col] == digit || board[row][i] == digit) return false;  // Check row and column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == digit) return false;  // Check 3x3 sub-grid
        }
        return true;
    }
}
```

### Key Points:
	•	Use backtracking to place digits in empty cells.
	•	Check if the placement follows Sudoku rules (row, column, 3x3 sub-grid).
	•	Backtrack if a valid solution isn’t possible.

## Backtracking
### N-Queens Problem
- **Goal**: Place `N` queens on an `N x N` chessboard such that no two queens attack each other.
- **Approach**:
  1. Use backtracking to place queens column by column.
  2. Check if it’s safe to place a queen in the current row/column using three conditions:
    - No queen in the current row.
    - No queen in the upper left diagonal.
    - No queen in the lower left diagonal.

- **Time Complexity**: `O(N!)` (checking all configurations)
- **Space Complexity**: `O(N)` (for board and arrays)

### Standard Backtracking Solution

```java
public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
    solve(board, 0, result, n);
    return result;
}

private void solve(char[][] board, int col, List<List<String>> result, int n) {
    if (col == n) {
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subList.add(new String(board[i]));
        }
        result.add(subList);
        return;
    }

    for (int row = 0; row < n; row++) {
        if (isSafeToPlace(board, row, col, n)) {
            board[row][col] = 'Q';
            solve(board, col + 1, result, n);
            board[row][col] = '.';
        }
    }
}

private boolean isSafeToPlace(char[][] board, int row, int col, int n) {
    // Check upper diagonal, left side, and lower diagonal
    for (int i = 0; i < col; i++) {
        if (board[row][i] == 'Q') return false;
        if (row - i >= 0 && board[row - i][col - i] == 'Q') return false;
        if (row + i < n && board[row + i][col - i] == 'Q') return false;
    }
    return true;
}

```

## Optimized Backtracking Solution

	•	Optimization: Use arrays to track if a row, upper diagonal, or lower diagonal is occupied, reducing time spent checking for conflicts.

```java
public List<List<String>> solveNQueensOptimized(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
    boolean[] leftRow = new boolean[n];
    boolean[] lowerDiagonal = new boolean[2 * n - 1];
    boolean[] upperDiagonal = new boolean[2 * n - 1];
    solveOptimized(board, 0, result, n, leftRow, lowerDiagonal, upperDiagonal);
    return result;
}

private void solveOptimized(char[][] board, int col, List<List<String>> result, int n,
                            boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal) {
    if (col == n) {
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subList.add(new String(board[i]));
        }
        result.add(subList);
        return;
    }

    for (int row = 0; row < n; row++) {
        if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 + col - row]) {
            board[row][col] = 'Q';
            leftRow[row] = true;
            lowerDiagonal[row + col] = true;
            upperDiagonal[n - 1 + col - row] = true;
            solveOptimized(board, col + 1, result, n, leftRow, lowerDiagonal, upperDiagonal);
            board[row][col] = '.';
            leftRow[row] = false;
            lowerDiagonal[row + col] = false;
            upperDiagonal[n - 1 + col - row] = false;
        }
    }
}
```

### Key Points:
	•	Use backtracking to place queens on the board.
	•	In the optimized solution, use arrays to track the occupied rows and diagonals.
	•	Backtrack if no valid placement is found for the current configuration.