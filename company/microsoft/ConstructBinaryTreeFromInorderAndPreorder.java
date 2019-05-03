package company.microsoft;

import java.util.ArrayList;

public class ConstructBinaryTreeFromInorderAndPreorder {
    public TreeNode buildTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        return helper(0,0,inOrder.size()-1, preOrder, inOrder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        if(preStart > preOrder.size()-1 || inStart> inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preOrder.get(preStart));
        int inIndex = 0;
        for(int i= inStart ; i<=inEnd; i++){
            if(inOrder.get(i)== root.val){
                inIndex = i;
            }
        }
        root.left = helper(preStart+1, inStart, inIndex-1, preOrder, inOrder);
        root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd , preOrder, inOrder);
        return root;
    }
}
