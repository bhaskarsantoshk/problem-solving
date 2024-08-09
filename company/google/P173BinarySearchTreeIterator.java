package company.google;

import company.TreeNode;

import java.util.Stack;

public class P173BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    private TreeNode currentNode;

    public P173BinarySearchTreeIterator(TreeNode root) {
        this.stack = new Stack<>();
        currentNode = root;
    }


    public int next() {
        while ( currentNode != null ){
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
        currentNode = stack.pop();
        int res = currentNode.val;
        currentNode = currentNode.right;
        return res;

    }

    public boolean hasNext() {
        return !stack.isEmpty() || currentNode != null ;
    }
}
