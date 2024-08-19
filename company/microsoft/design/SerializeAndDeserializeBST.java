package company.microsoft.design;

import company.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    String delimiter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb){
        if ( root == null ) return;
        else {
            sb.append(root.val).append(delimiter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ( data == null || data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(delimiter)));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> nodes, int lower, int upper){
        if (nodes.isEmpty()) return null;
        String s = nodes.peek();
        int val = Integer.parseInt(s);
        if ( val <lower || val >upper) return null;
        nodes.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(nodes, lower, val);
        root.right = deserialize(nodes, val, upper);
        return root;
    }
}
