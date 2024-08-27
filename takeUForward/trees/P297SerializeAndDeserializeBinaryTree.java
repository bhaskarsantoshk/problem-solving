package takeUForward.trees;

import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P297SerializeAndDeserializeBinaryTree {

    private final String nullPointer = "#";
    private final String delimiter = ",";
    public String serialize(TreeNode root) {
        if ( root == null) return nullPointer;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while ( !q.isEmpty()){
            TreeNode node = q.poll();
            if ( node == null){
                sb.append(nullPointer).append(delimiter);
                continue;
            }
            sb.append(node.val).append(delimiter);
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(delimiter);
        if ( values == null || values.length == 0 || values[0].equals(nullPointer)) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for ( int i=1; i<values.length; i++){
            TreeNode parent = q.poll();
            if ( !values[i].equals(nullPointer)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if ( ++i < values.length && !values[i].equals(nullPointer)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    private final String nullPointerPreOrder = "#";
    private final String delimiterPreOrder = ",";
    public String serializePreOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root , StringBuilder sb) {
        if ( root == null) sb.append(nullPointerPreOrder).append(delimiterPreOrder);
        else {
            sb.append(root.val).append(delimiterPreOrder);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public TreeNode deserializePreOrder(String data) {
        Queue<String> nodes = new LinkedList<>(List.of(data.split(delimiterPreOrder)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if ( val.equals(nullPointerPreOrder)) return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}
