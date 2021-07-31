package data_structures.trees;

public class ConvertBinaryTreeToDoublyLinkedList {
    public static TreeNode convertTreeToDoublyLinkedList (TreeNode root){
        TreeNode head = convertTreeToDoublyLinkedListRec(root);
        if (head != null && head.left != null) {
            head.left.right = null;
            head.left = null;
        }
        return head;
    }

    private static TreeNode convertTreeToDoublyLinkedListRec(TreeNode root) {
        if ( root == null ) return null;
        TreeNode list1 = convertTreeToDoublyLinkedListRec(root.left);
        TreeNode list2 = convertTreeToDoublyLinkedList(root.right);
        root.left = root.right = root;
        TreeNode res = concat(list1, root);
        res = concat(res, list2);
        return res;
    }

    private static TreeNode concat(TreeNode list1, TreeNode list2) {
        if ( list1 == null ) return list2;
        if ( list2 == null ) return list1;
        TreeNode tail1 = list1.left;
        TreeNode tail2 = list2.left;
        tail1.right = list2;
        list2.left = tail1;

        list1.left = tail2;
        tail2.right = list1;
        return list1;
    }
}
