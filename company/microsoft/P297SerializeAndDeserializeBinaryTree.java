package company.microsoft;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P297SerializeAndDeserializeBinaryTree {

    String nullPtr="#";
    String delimeter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if ( root == null) sb.append(nullPtr).append(delimeter);
        else {
            sb.append(root.val).append(delimeter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(delimeter);
        Queue<String> nodes = new LinkedList<>(List.of(split));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String node = nodes.poll();
        if ( node.equals(nullPtr)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }

    /*
        1
     2     3
        4.    5
     */

    // 1,2,#,#,3,4,#,#,5, #, #,
}

