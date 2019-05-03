package company.microsoft;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder){
      if(inOrder== null || inOrder.size()==0 || postOrder== null || postOrder.size()==0){
          return null;
      }
        TreeNode root = new TreeNode(postOrder.get(postOrder.size()-1));
        int index = inOrder.indexOf(root.val);
        root.left = buildTree(new ArrayList<Integer>(inOrder.subList(0, index)),
                new ArrayList<Integer>(postOrder.subList(0, index)));
        root.right = buildTree(new ArrayList<>(inOrder.subList(index+1, inOrder.size())),
                new ArrayList<>(postOrder.subList(index, postOrder.size()-1)));
        return root;


    }




}
