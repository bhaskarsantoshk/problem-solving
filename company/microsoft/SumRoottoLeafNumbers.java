package company.microsoft;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode A) {
        return sum(A, 0);
    }
    private int sum(TreeNode root, int s) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right== null){
            return (s*10 + root.val)%1003;
        }
        return sum(root.left, (s*10+root.val)%1003) + sum(root.right, (s*10+root.val)%1003);
    }
}
