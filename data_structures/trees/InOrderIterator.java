package data_structures.trees;

import java.util.Stack;

public class InOrderIterator {
    Stack<TreeNode> stack = new Stack<>();
    public InOrderIterator(TreeNode root){
        populateIterator(root);
    }

    private void populateIterator(TreeNode root) {
        while (root!= null){
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext(){
        return false;
    }

    public TreeNode getNext() {
        if ( stack.isEmpty() ) return null;
        TreeNode node = stack.pop();
        TreeNode temp = node.right;
        populateIterator(temp);
        return node;
    }

    public String inorderUsingIterator(TreeNode root) {
        InOrderIterator iter = new InOrderIterator(root);
        String result = "";
        while (iter.hasNext()) {
            result += iter.getNext().data + " ";
        }
        return result;
    }
}
