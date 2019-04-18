package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(list, path, root, sum);

        return list;
    }

    private void dfs(List<List<Integer>> list, ArrayList<Integer> path, TreeNode root, int sum) {
        if(sum == root.val && root.left== null && root.right== null){
            path.add(root.val);
            list.add(new ArrayList<>(path));
        }
        if(root.left != null) {
            path.add(root.val);
            dfs(list, path, root.left, sum - root.val);
            path.remove(path.size()-1);
        }
        if(root.right != null) {
            path.add(root.val);
            dfs(list, path, root.right, sum - root.val);
            path.remove(path.size()-1);
        }
    }
}
