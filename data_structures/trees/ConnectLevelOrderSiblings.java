package data_structures.trees;

import java.util.Queue;
import java.util.LinkedList;

public class ConnectLevelOrderSiblings {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }
    }

    public static void connectLevelOrder(TreeNode root) {
        if ( root == null ) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while ( !queue.isEmpty() ){
            TreeNode prevNode = null;
            int levelSize = queue.size();
            for ( int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                if ( prevNode != null ){
                    prevNode.next = currentNode;
                }
                prevNode = currentNode;

                if ( currentNode.left != null ){
                    queue.offer(currentNode.left);
                }
                if ( currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
    }


    public static void connect(TreeNode root){
        if ( root == null ) return;
        if ( root.left != null ){
            root.left.next = root.right;
            if ( root.next != null && root.right != null ){
                root.right.next= root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
