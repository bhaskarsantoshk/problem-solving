package takeUForward.QR;

import java.util.HashSet;
import java.util.Set;

public class P44TwoSumInBST {
    public boolean twoSumBST(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
       return twoSumBST(root, k, set);
    }

    private boolean twoSumBST(TreeNode root, int k, Set<Integer> set) {
        if ( root == null) return false;
        if (set.contains(k-root.data)) return true;
        set.add(root.data);
        return twoSumBST(root.left, k, set) || twoSumBST(root.right, k, set);
    }
}
