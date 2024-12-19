package LeetCode;

public class P2415ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    public void dfs(TreeNode node1, TreeNode node2, int lvl) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (lvl % 2 == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        dfs(node1.left, node2.right, lvl + 1);
        dfs(node1.right, node2.left, lvl + 1);
    }
}
