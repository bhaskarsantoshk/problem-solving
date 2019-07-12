package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class P124BinaryTreeMaximumPathSum {
    int max;
    Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }
    private int maxPath(TreeNode root) {
        if ( root == null ) return 0;
        if ( map.containsKey(root)){
            return map.get(root);
        }
        int left = Math.max ( 0, maxPath(root.left));
        int right = Math.max ( 0, maxPath(root.right));
        max = Math.max ( max, left + right + root.val);
        int result = Math.max ( left, right) + root.val;
        map.put(root, result);
        return result;
    }
}
