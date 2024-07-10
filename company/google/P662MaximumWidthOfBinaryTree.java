package company.google;

import company.TreeNode;

import java.util.LinkedList;

public class P662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 1;
        while ( !q.isEmpty()) {
            maxWidth = Math.max( maxWidth, q.peekLast().val-q.peekFirst().val+1);
            int size = q.size();
            for ( int i=0; i<size; i++){
                TreeNode node = q.peek().node;
                int val = q.peek().val;
                q.poll();
                if ( node.left != null ){
                    q.offer(new Pair(node.left, 2*val+1));
                }
                if ( node.right != null ){
                    q.offer(new Pair(node.right, 2*val+2));
                }
            }
        }
        return maxWidth;
    }
}

class Pair {
    int val;
    TreeNode node;
    Pair(TreeNode node, int val ){
        this.node = node;
        this.val = val;
    }
}
