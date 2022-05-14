# LC Guide

## Two Sum 
* URL : 
  * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/
* Explanation:
  * Initialize a HashMap with key as number and value as index
  * Traverse through array:
    * Check if map contains target - num[i]
      * If yes, Return new int[] { map.get(target-nums[i]), i }
    * Add (nums[i], i) to map

```
public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i=0; i<nums.length; i++){
            if ( map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
 }
```

## Longest Substring Without Repeating Characters

* URL: 
  * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2961/
* Explanation:
  * Initialize a Set<Character> , index=0, length=0
  * Traverse through each character in the string:
    * check if set contains the character
      * If yes, keep removing character s.charAt(index) from the set 
      * increment index
    * add s.charAt(i) to the set
    * check for max length ( between length and size of set)
  * return length
```
   public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        int index = 0;
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            while ( set.contains(c)){
                set.remove(s.charAt(index));
                index++;
            }
            set.add(c);
            len = Math.max( len, set.size());
        }
        return len; 
    }
```
### Add Two Numbers

* URL:
  * https://leetcode.com/explore/interview/card/amazon/77/linked-list/513/
* Explanation:
  * Create a dummy node
  * Create a cuurrent node and assign dummy node address
  * carry = 0
  * Keep traversing both linked lists ( while ( l1 != null || l2 != null))
    * sum = l1.val + l2.val ( if l1 or l2 is null, give 0 as default)
    * cur.next = new ListNode ( suum % 10)
    * carry = sum /10
    * l1 = l1.next ( if l1 is null, don't move the pointer ), l2= l2.next ( same as l1) , cur = cur.next
  * if carry = 1:
    * cur.next = new ListNode(1)
  * return dummy.next
```
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        
        while ( l1 != null || l2 != null ){
            int sum = ( l1 != null ? l1.val : 0) + ( l2 != null ? l2.val : 0)+ carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = ( l1 != null ) ? l1.next : l1;
            l2 = ( l2 != null ) ? l2.next : l2;
            cur = cur.next;
        }
        if ( carry == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
```

## 
* URL:
  * https://leetcode.com/problems/merge-two-sorted-lists/
  * https://leetcode.com/explore/interview/card/amazon/77/linked-list/2976/

* Explanation:
  * Create a dummy node
  * Create a current node and assign dummy node's pointer
  * while list1 != null and list2 != null
    * if list1 has min value: cur.next = list1, list1 = list1.next
    * else cur.next = list2, list2= list2.next
    * move current to it's next
  * if list1 is not null, cur.next = list1
  * if list2 is not null, cur.next = list2
  * return dummy.next
```
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( list1 != null && list2 != null ){
            if ( list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if ( list1 != null ) cur.next = list1;
        if ( list2 != null ) cur.next = list2;
        return dummy.next;   
  }
```

## Validate Binary Search Tree
* URL: 
  * https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/514/
  * https://leetcode.com/problems/validate-binary-search-tree/
* Recursive Approach Explanation:
  * start a recusrive method with root, Long.MIN_VALUE and Long.MAX_VALUE as parameters
  * if root value is greater than max or less than min value , return false
  * return isValidBST(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue)
```
public boolean isValidBSTRec(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if ( root == null ) return true;
        if ( root.val >= maxValue || root.val <= minValue){
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right , root.val, maxValue);
    }
```
### Iterative Approach Explanation:
  * Learn Inorder Traversal and solve all the related problems.
#### Inorder Traversal
* Create a Stack of TreeNodes
* Create a result list to add elements
  * while root is not null or stack is not empty:
    * while root is not empty:
      * keep pushing root into stack
      * move root to it's left
    * root = stack.pop()
    * add root's value to list
    * move root to it's right
* returhn result
```
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ) return result;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty()) {
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
}
```
#### Kth smallest element in a BST
* Use Inorder traversal approach
```
public int kthSmallest(TreeNode root, int k) {
        if ( root == null || k == 0) return -1;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty() ){
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( --k == 0) break;;
            root = root.right;
        }
        return root.val;
    }
```
#### Validate Binary Search Tree
```
public boolean isValidBST(TreeNode root) {
       if ( root == null ) return false;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty() ){
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( pre != null && pre.val >= root.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
```

## Symmetric Tree

* URL:
  * https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/507/
  * https://leetcode.com/problems/symmetric-tree/
* Explanation
* Recursive approach:
  * if root is null, return true
  * Create a helper function that takes left and right nodes
  * return the helper function
  * Helper Function:
    * if s or t is null, return s == null && t == null
    * return s.val == t.val && Helper of s.left , t.right && Helper of s.right , t.left
```
public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        return isSameTree(root.left, root.right);
}

private boolean isSameTree(TreeNode s, TreeNode t) {
        if ( s == null || t == null ) 
          return s == null && t == null;
        return s.val == t.val 
        && isSameTree(s.left, t.right) 
        && isSameTree(s.right, t.left);
}
```
* Iterative approach:
  * BFS 
  * Create a Queue, add left and right
  * while queue is not empty:
    * poll f and s
    * check if f and s are null
      * if yes, continue
    * check if f is null or s is null or f.val != s.val 
      * if yes, return false
    * add f.left, s.right to queue
    * add f.right, s.left to queue
  * return true
```
public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while ( !queue.isEmpty() ){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if ( f == null && s == null) continue;
            if ( f == null || s == null || f.val != s.val ) return false;
            queue.add(f.left);
            queue.add(s.right);
            queue.add(f.right);
            queue.add(s.left);
        }
        return true;
}
```

