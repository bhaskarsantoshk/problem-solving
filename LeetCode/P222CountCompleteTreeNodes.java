package LeetCode;

public class P222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if ( root == null ) return 0;
        return 1+ countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesOptimized(TreeNode root) {
        if ( root == null ) return 0;
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if ( leftDepth == rightDepth ) return (1 << leftDepth) -1;
        return 1 + countNodesOptimized(root.left) + countNodesOptimized(root.right);
    }

    private int rightDepth(TreeNode root) {
        int depth = 0;
        while ( root != null ){
            root = root.right;
            depth++;
        }
        return depth;
    }

    private int leftDepth(TreeNode root) {
        int depth = 0;
        while ( root != null ){
            root = root.left;
            depth++;
        }
        return depth;
    }
}

/*
# Time Complexity Analysis of `countNodesOptimized`

## Time Complexity

### Depth Calculation

- Calculating the depth of the tree (both left and right) involves traversing the height of the tree, which is \(O(d)\). In a complete binary tree, \(d = \log n\).

### Recursive Case

- If the left and right depths are equal, the tree is a perfect binary tree, and the node count is \(2^d - 1\). This takes \(O(1)\) time after calculating the depth.
- If the left and right depths are not equal, the function recursively counts the nodes in the left and right subtrees. The depth calculation occurs at each recursive call.

### Detailed Time Complexity Analysis

- **Depth Calculation:**
  Each depth calculation is \(O(\log n)\).

- **Recursive Calls:**
  The function makes recursive calls to both left and right subtrees, which effectively halves the problem size at each level.

The recurrence relation for the function is:

\[ T(n) = O(\log n) + 2T(n/2) \]

This can be solved using the Master Theorem for divide-and-conquer recurrences:

- \(a = 2\) (number of subproblems)
- \(b = 2\) (factor by which the problem size is divided)
- \(f(n) = O(\log n)\) (cost outside the recursive calls)

According to the Master Theorem, if \(f(n) = O(n^c)\) where \(c < \log_b a\), the time complexity is dominated by the divide step, and \(T(n) = O(n^{\log_b a})\).

Here, \(\log_b a = \log_2 2 = 1\) and \(f(n) = O(\log n)\). Since \(\log n\) grows slower than \(n^1\), we fall into case 2 of the Master Theorem:

\[ T(n) = O(n^{\log_2 2}) = O(n) \]

However, this is not the exact case here. The depth calculation \(O(\log n)\) leads to an overall logarithmic cost at each level, making the final complexity:

\[ T(n) = O(\log^2 n) \]

Thus, the time complexity of the `countNodesOptimized` function is \(O(\log^2 n)\).

 */