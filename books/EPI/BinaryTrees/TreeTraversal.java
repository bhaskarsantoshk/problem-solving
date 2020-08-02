package books.EPI.BinaryTrees;

public class TreeTraversal {
    public static void treeTraversal (BinaryTreeNode<Integer> root ){
        if ( root != null ){
            System.out.println("Preorder: "+ root.data);
            treeTraversal(root.left);
            System.out.println("Inorder: "+ root.data);
            treeTraversal(root.right);
            System.out.println("Postorder: "+ root.data);
        }
    }
}
