package company.microsoft;

public class PopulateNextRightPointersTree {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null && root.right!=null){
                root.right.next= root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
