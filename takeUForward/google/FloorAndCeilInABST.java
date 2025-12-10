package takeUForward.google;

import takeUForward.google.common_ds.TreeNode;

import java.util.Arrays;
import java.util.List;

public class FloorAndCeilInABST {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor = getFloorBST(root, key);
        int ceil = getCeilBST(root, key);

        return Arrays.asList(floor, ceil);
    }

    private int getCeilBST(TreeNode root, int key) {
        TreeNode cur = root;
        int ceil = -1;
        while ( cur != null ){
            if ( cur.data == key) return key;
            else if ( cur.data < key ){
                cur = cur.right;
            } else {
                ceil = cur.data;
                cur = cur.left;
            }
        }
        return ceil;
    }

    private int getFloorBST(TreeNode root, int key) {
        int floor = -1;
        TreeNode cur = root;
        while ( cur != null){
            if ( cur.data == key) return key;
            else if ( cur.data < key) {
                floor = cur.data;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return floor;
    }
}
