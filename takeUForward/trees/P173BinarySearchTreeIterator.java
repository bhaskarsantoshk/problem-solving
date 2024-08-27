package takeUForward.trees;

import java.util.NoSuchElementException;
import java.util.Stack;

public class P173BinarySearchTreeIterator {

    TreeNode currentNode;
    Stack<TreeNode> stack;
    public P173BinarySearchTreeIterator(TreeNode root) {
        currentNode = root;
        stack = new Stack<>();
    }

    public int next() {
        while ( currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
        if ( stack.isEmpty() ) throw new NoSuchElementException("");
        currentNode = stack.pop();
        int res = currentNode.val;
        currentNode = currentNode.right;
        return res;
    }

    public boolean hasNext() {
        return currentNode != null || !stack.isEmpty();
    }
}
