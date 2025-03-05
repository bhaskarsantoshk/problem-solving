package company.microsoft.trees;

import company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P297SerializeAndDeserializeBinaryTree {
    String nullPtr = "#";
    String delimiter = ",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if ( root == null) sb.append(nullPtr).append(delimiter);
        else {
            sb.append(root.val).append(delimiter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(List.of(data.split(delimiter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if ( val.equals(nullPtr)) return null;
        else {
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}
