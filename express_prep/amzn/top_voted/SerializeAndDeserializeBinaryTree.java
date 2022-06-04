package express_prep.amzn.top_voted;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    String delim = ",";
    String nullPointer = ".";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuffer sb) {
        if ( root == null ) {
            sb.append(nullPointer).append(delim);
        } else {
            sb.append(root.val).append(delim);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(delim)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if  ( val.equals(nullPointer)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode ( int val){
            this.val = val;
        }
    }
}
