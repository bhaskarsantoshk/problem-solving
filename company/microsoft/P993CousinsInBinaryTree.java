package company.microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class P993CousinsInBinaryTree {
    private TreeNode parentX = null, parentY = null;
    private int depthX = -1 , depthY = -1;
    public boolean isCousinsDFS(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return depthX == depthY && parentX != parentY;
    }

    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if ( node == null) return;
        if ( node.val == x){
            parentX = parent;
            depthX = depth;
        }
        if ( node.val == y){
            parentY = parent;
            depthY = depth;
        }
        if ( depthX != -1 && depthY != -1) return;
        dfs( node.left, node, depth+1, x, y);
        dfs( node.right, node, depth+1, x, y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if ( root == null || root.val == x || root.val == y) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean foundX = false, foundY = false;
            for ( int i=1; i<=size; i++){
                TreeNode node = queue.poll();
                if ( node.left != null && node.right != null){
                    int left = node.left.val, right = node.right.val;
                    if ( ( left == x && right == y ) || (left==y && right == x)) return false;
                }
                if ( node.val == x) foundX=true;
                if ( node.val == y) foundY=true;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if ( foundX && foundY ) return true;
            if ( foundX || foundY) return false;
        }
        return false;
    }
}
