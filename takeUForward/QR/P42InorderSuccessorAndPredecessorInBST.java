package takeUForward.QR;

import java.util.ArrayList;
import java.util.List;

public class P42InorderSuccessorAndPredecessorInBST {
    List<Integer> succPredBST(TreeNode root, int key) {
        List<Integer> sortedList = new ArrayList<>();
        // Perform in-order traversal to get the sorted list of node values
        inorderTraversal(root, sortedList);

        int predecessor = -1;
        int successor = -1;

        // Find the predecessor and successor in the sorted list
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) < key) {
                // Update predecessor if the current value is less than the key
                predecessor = sortedList.get(i);
            } else if (sortedList.get(i) > key) {
                // Update successor if the current value is greater than the key
                successor = sortedList.get(i);
                break;  // No need to continue once successor is found
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        return result;
    }

    // Helper function to perform in-order traversal
    private void inorderTraversal(TreeNode node, List<Integer> sortedList) {
        if (node == null) {
            return;
        }
        // Traverse the left subtree
        inorderTraversal(node.left, sortedList);
        // Add the node's value to the sortedList
        sortedList.add(node.data);
        // Traverse the right subtree
        inorderTraversal(node.right, sortedList);
    }
}
