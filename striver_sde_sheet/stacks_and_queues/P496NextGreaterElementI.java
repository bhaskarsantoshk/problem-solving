package striver_sde_sheet.stacks_and_queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496NextGreaterElementI {
    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        for ( int i=0; i< nums1.length; i++){
            int elementIndex = -1;
            for ( int j=0; j<nums2.length; j++){
                if ( nums1[i] == nums2[j]){
                    elementIndex = j; break;
                }
            }
            if ( elementIndex == -1) res[i] = -1;
            else {
                int greatElementIndex = -1;
                for ( int j= elementIndex+1; j<nums2.length; j++){
                    if ( nums2[elementIndex] < nums2[j]) {
                        greatElementIndex = j;
                        break;
                    }
                }
                if ( greatElementIndex != -1){
                    res[i] = nums2[greatElementIndex];
                } else{
                    res[i] = -1;
                }
            }
        }

        return res;
    }

    // Use the knowledge of P503NextGreaterElementII
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>(); // map num to next greater
        Stack<Integer> stack = new Stack<>();
        for ( int i= nums2.length-1; i>=0 ;i--){
            while ( !stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if ( stack.isEmpty() ) {
                nextGreater.put(nums2[i], -1);
            } else {
                nextGreater.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        int res[] = new int[nums1.length];
        for ( int i=0; i<nums1.length; i++){
            res[i] = nextGreater.get(nums1[i]);
        }
        return res;
    }

}
