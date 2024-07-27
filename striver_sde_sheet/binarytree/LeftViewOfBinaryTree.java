package striver_sde_sheet.binarytree;

import company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {

    // Recursive - O(n) time and O(H) space
    // Iterative - first node in each level , O(N) time and O(N) space

    // Let's prefer reverse preorder root, right , left
    public ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helperRightView( root, res, 0);
        return res;
    }

    private void helperRightView(TreeNode node, List<Integer> res, int level) {
        if ( node == null ) return;
        if ( level == res.size() ) res.add(node.val);
        helperRightView(node.right, res, level+1);
        helperRightView(node.left, res, level+1);
    }

    public ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helperLeftView( root, res, 0);
        return res;
    }

    private void helperLeftView(TreeNode node, ArrayList<Integer> res, int level) {
        if ( node == null ) return;
        if ( level == res.size() ) res.add(node.val);
        helperLeftView(node.left, res, level+1);
        helperLeftView(node.right, res, level+1);
    }
}
