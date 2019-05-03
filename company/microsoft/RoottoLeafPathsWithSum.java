package company.microsoft;

import java.util.ArrayList;

public class RoottoLeafPathsWithSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return pathList;
        }
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, sum-root.val, pathList, path);
        return pathList;
    }

    private void dfs(TreeNode node, int sum, ArrayList<ArrayList<Integer>> pathList, ArrayList<Integer> path) {
        if(node.left== null && node.right== null && sum==0){
            pathList.add(new ArrayList<Integer>(path));
        }
        if(node.left!=null){
            path.add(node.left.val);
            dfs(node.left, sum- node.left.val, pathList, path);
            path.remove(path.size()-1);
        }
        if(node.right != null){
            path.add(node.right.val);
            dfs(node.right, sum-node.right.val, pathList, path);
            path.remove(path.size()-1);
        }
    }
    }


