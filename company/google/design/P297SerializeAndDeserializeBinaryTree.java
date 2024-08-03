package company.google.design;

import company.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P297SerializeAndDeserializeBinaryTree {

    String delimiter = ",";
    String nullPointer = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if ( root == null ) return "";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if ( root == null ) sb.append(nullPointer).append(delimiter);
        else {
            sb.append(root.val).append(delimiter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ( data == null || data.isEmpty() ) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(delimiter)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if ( val.equals(nullPointer)){
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}
