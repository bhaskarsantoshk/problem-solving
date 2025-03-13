package takeUForward.blind75.tree;

import company.TreeNode;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    String nullPtr = "#";
    String delimitre = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }

    private void buildString(StringBuilder sb, TreeNode root) {
        if ( root == null) sb.append(nullPtr).append(delimitre);
        else {
            sb.append(root.val).append(delimitre);
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(delimitre);
        Queue<String> nodes = new LinkedList<>(Arrays.asList(split));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if ( val.equals(nullPtr)) return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}
