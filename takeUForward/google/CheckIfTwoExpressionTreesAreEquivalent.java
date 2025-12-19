package takeUForward.google;

import java.util.Arrays;

public class CheckIfTwoExpressionTreesAreEquivalent {
    public boolean checkEquivalence(TreeNode root1, TreeNode root2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        collectFrequencies(root1, freq1);
        collectFrequencies(root2, freq2);
        return Arrays.equals(freq1, freq2);
    }

    private void collectFrequencies(TreeNode root, int[] freq) {
        if ( root == null) return;
        if ( root.data != '+'){
            freq[root.data-'a']++;
        }
        collectFrequencies(root.left, freq);
        collectFrequencies(root.right, freq);
    }

    class TreeNode {
        char data;
        TreeNode left, right;
        TreeNode(char x) {
            data = x;
            left = right = null;
        }
    }
}
