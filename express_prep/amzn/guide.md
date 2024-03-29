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

## Letter Combinations of a Phone Number

* URL:
  * https://leetcode.com/explore/interview/card/amazon/84/recursion/521/
  * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
* Explanation:
  * Backtracking
  * Create a letter map with key as number character and array of letters as value
  * Use backtracking with prefix ( an empty string buiulder), digits , result ( array list) and map as arguements
```
public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if ( digits == null || digits.length() == 0) return result;
        Map<Character, char[]> letterMap = new HashMap<>();
        letterMap.put('0', new char[]{});
        letterMap.put('1', new char[]{});
        letterMap.put('2', new char[]{'a','b','c'});
        letterMap.put('3', new char[]{'d','e','f'});
        letterMap.put('4', new char[]{'g','h','i'});
        letterMap.put('5', new char[]{'j','k','l'});
        letterMap.put('6', new char[]{'m','n','o'});
        letterMap.put('7', new char[]{'p','q','r','s'});
        letterMap.put('8', new char[]{'t','u','v'});
        letterMap.put('9', new char[]{'w','x','y','z'});
        StringBuilder sb = new StringBuilder();
        backtrack(sb, digits, letterMap, result);
        return result;
}
    
private void backtrack(StringBuilder prefix, String digits, Map<Character,char[]> letterMap, List<String> result){
        if ( prefix.length() == digits.length() ){
            result.add(prefix.toString());
            return;
        }
        for ( char c: letterMap.get(digits.charAt(prefix.length()))) {
            prefix.append(c);
            backtrack(prefix, digits, letterMap, result);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
```

## Generate Parentheses
* URL: 
  * https://leetcode.com/explore/interview/card/amazon/84/recursion/2988/
* Explanation:
  * Think of the possible number of open and closed braces
  * We can add "(" as long as the number of open braces are less than n
  * String can't start with ")"
  * We can add ")" if and only if number of closed are less than open braces
  * By considering the above conditions , apply backtracking
```
public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
}
    
private void backtrack(List<String> result, String prefix, int open, int closed, int max){
        if ( open + closed == 2 * max ){
            result.add(prefix);
        }
        if ( open < max ){
            backtrack(result, prefix+"(", open+1, closed, max);
        }
        if ( closed < open ){
            backtrack(result, prefix+")", open, closed+1, max);
        }
}
```

## Median of Two Sorted Arrays
* URL:
  * https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/2991/
  * https://leetcode.com/problems/median-of-two-sorted-arrays/
* Explanation:
  * Use Binary Search on the smallest array
  * Partition the arrays in such a way that number of elemts on the left and right side are equal
  * Apply binary search to find the right partition
```
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1.length > nums2.length ){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int start = 0, end = x;
        while ( start <= end ){
            int partitionX = (start+end)/2;
            int partitionY = ( x+y+1)/2 - partitionX;
            int maxLeftX = ( partitionX == 0 ) ? Integer.MIN_VALUE: nums1[partitionX-1];
            int minRightX= ( partitionX == x ) ? Integer.MAX_VALUE: nums1[partitionX];
            int maxLeftY = ( partitionY == 0 ) ? Integer.MIN_VALUE: nums2[partitionY-1];
            int minRightY= ( partitionY == y ) ? Integer.MAX_VALUE: nums2[partitionY];

            if ( maxLeftX <= minRightY && maxLeftY <= minRightX ){
                if ( (x+y) % 2 == 0 ) {
                    return ( Math.max (maxLeftX, maxLeftY) + Math.min( minRightX, minRightY)) / 2.0;
                } else {
                    return (Math.max (maxLeftX, maxLeftY));
                }
            } else if (maxLeftX > minRightY){
                end = partitionX-1;
            } else {
                start = partitionX+1;
            }
        }
        return -1;
}
```

## Search in Rotated Sorted Array
* URL:
  * https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/2992/
  * https://leetcode.com/problems/search-in-rotated-sorted-array/
* Explanation:
  * Tweak the binary search
  * initialize start and end
  * while start is less than or equal to end:
    * mid = ( start + end )/2
    * if a[mid] == key, return mid
    * Explore left / right region
    * Check if a[mid] >= a[start]:
      * If yes
        * now check the key position
        * if the key is greater than a[mid] and a[start]:
          * end = mid-1
        * else: start = mid+1
      * Else:
        * if the key is greater than a[mid] and less than a[end]:
          * start = mid+1;
        * else: end = mid-1
  * return -1
```
public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while ( start <= end ){
            int mid = (start+end)/2;
            if ( nums[mid] == target ) return mid;
            if ( nums[start] <= nums[mid] ){
                if ( target < nums[mid] && target >= nums[start]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if ( target > nums[mid] && target <= nums[end] ){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
}
```

## Longest Palindromic Substring
* URL:
  * https://leetcode.com/problems/longest-palindromic-substring/
  * https://leetcode.com/explore/interview/card/amazon/80/dynamic-programming/489/
* Explanation:
* Extending Palindrome approach O(N^2):
  * For index=0 to length:
    * extend the string by keeping s[index] as mid point ( odd length )
    * extend the string by keeping s[index], s[index+1] as mid point ( even length)
    * get the max of both
  * return the max of all
```
public String longestPalindrome(String s) {
        String max = "";
        for ( int i=0; i<s.length(); i++){
            String s1= extend(s, i, i);
            String s2= extend(s, i, i+1);
            if ( max.length() < s1.length() ) max = s1;
            if ( max.length() < s2.length() ) max = s2;
        }
        return max;
}
    
private String extend(String s, int i, int j){
        while ( i>= 0 && j<= s.length()-1){
            if ( s.charAt(i) != s.charAt(j) ) break;
            i--;
            j++;
        }
        return s.substring(i+1, j);
}
```

* DP Solutiion:
  * Watch https://www.youtube.com/watch?v=UflHuQj6MVA

## Maximum Subarray

* URL:
  * https://leetcode.com/explore/interview/card/amazon/80/dynamic-programming/899/
  * https://leetcode.com/problems/maximum-subarray/
* Explanation:
  * take sum and max and initialize them to nums[0]
  * Traverse from i -> 1 to n:
    * sum = MAX ( summ+ nums[i], nums[i])
    * max = MAX ( sum, max)
  * return max
```
public int maxSubArray(int[] nums) {
        if ( nums == null || nums.length == 0) return 0;
        int sum = nums[0], max= nums[0];
        for ( int i=1; i<nums.length; i++ ){
            sum = Math.max( sum+nums[i], nums[i]);
            max = Math.max( sum, max);
        }
        return max;
}
```

## LRU Cache

* URL:
  * https://leetcode.com/explore/interview/card/amazon/81/design/478/
  * https://leetcode.com/problems/lru-cache/
* Explanation:
  * Initial Setup: Empty Constructor, get and put
  * Member variables: Node head, tail ( for boundaries), HashMap for cache, capacity
  * Node contains ke, val, next, prev, constructor (key, val)
  * get(key):
    * check if cache contains key
      * if yes: 
        * node = cache.get(key)
        * remove ( node )
        * insert ( node )
        * return node.value
      * else: return -1
  * put ( key , value ):
    * if cache.contains(key):
      * remove(cache.get(key))
    * if cache.size() == capacity:
      * remove(tail.prev)
    * insert(new Node(key, value))
  * insert(node):
    * cache.put(node.key, node.value)
    * Node next = head.next
    * head.next = node.next
    * node.next = next
    * node.prev = head
    * next.prev = node
  * remove (node):
    * cache.remove(node)
    * node.prev.next = node.next
    * node.next.prev = node.prev
```
class LRUCache {
    
    class Node{
        int key, value;
        Node next, prev;
        
        Node ( int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    Node head = new Node (0,0);
    Node tail = new Node (0,0);
    Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if ( cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }
        if ( cache.size() == capacity ){
            remove(tail.prev);
        }
        insert (new Node(key, value));
    }
    
    private void insert(Node node ){
        cache.put(node.key, node);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    private void remove( Node node ){
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
```

## Min Stack
* URL:
  * https://leetcode.com/explore/interview/card/amazon/81/design/503/
  * https://leetcode.com/problems/min-stack/
* Explanation:
  * Use LinkedList
  * Craete a Node with val, min and next
  * Initiatlize Node top = null
  * getMin() -> return top.min
  * pop() -> top = top.next
  * for both methods above, return if top is null
  * push() :
    * Node node = new Node(val)
    * if top == null:
      * top = node
    * else:
      * node.min = Math.min( top.min, val)
      * node.next = top
      * top = node
```
public class MinStack {
    private Node top = null;
    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node(val);
        if ( top == null ){
            top = node;
        } else {
            node.min = Math.min(top.min, val);
            node.next = top;
        }
        top = node;
    }

    public void pop() {
        if ( top == null ) return;
        top = top.next;
    }

    public int top() {
        if ( top == null ) return -1;
        return top.val;
    }

    public int getMin() {
        if ( top == null ) return -1;
        return top.min;
    }

    class Node {
        int val;
        int min;
        Node next;
        Node (int val){
            this.val = val;
            this.min = val;
        }
    }
}
```

## Word Search
* URL:
  * https://leetcode.com/explore/interview/card/amazon/84/recursion/2989/
* Explanation:
  * dfs
```
public boolean exist(char[][] board, String word) {
        if ( word == null || word.length() == 0 ) return true;
        if ( board == null || board.length == 0 ) {
            return false;
        }
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++ ){
                if ( exist(board, i, j, word, 0) ){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean exists = exist(board, i + 1, j, word, index + 1)
                || exist(board, i, j + 1, word, index + 1)
                || exist(board, i-1, j, word, index+1)
                || exist(board, i, j-1, word, index+1);
        board[i][j] = c;
        return exists;
    }
```

## Word Search II
* URL:
  * https://leetcode.com/explore/interview/card/amazon/84/recursion/2990/
* Explanation:
  * DFS + Trie
```
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if ( board == null || board.length == 0 ) return result;
        Trie root = buildTrie(words);
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                dfs(board, i, j, result, root);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, List<String> result, Trie p){
        if ( i <0 || i>= board.length || j<0 || j>= board[0].length ){
            return;
        }
        char c= board[i][j];
        if ( c == '#' || p.next[c-'a'] == null ) return;
        if ( p.next[c-'a'].word != null ){
            result.add(p.next[c-'a'].word);
            p.next[c-'a'].word = null;
        }
        board[i][j] = '#';
        p = p.next[c-'a'];
        dfs ( board, i+1, j, result, p);
        dfs ( board, i, j+1, result, p);
        dfs ( board, i-1, j, result, p);
        dfs ( board, i, j-1, result, p);
        board[i][j] = c;
    }
    
    private Trie buildTrie(String[] words ){
        Trie root = new Trie();
        for ( String word: words){
            Trie p = root;
            for ( char c: word.toCharArray() ){
                if ( p.next[c-'a'] == null ){
                    p.next[c-'a'] = new Trie();
                }
                p = p.next[c-'a'];
            }
            p.word = word;
        }
        return root;
    }
    
    class Trie{
        String word;
        Trie[] next = new Trie[26];
    }
}
```

## Partitiion Labels
* URL:
  * https://leetcode.com/explore/interview/card/amazon/82/others/3004/
* Explanatiion:
  * create a lastIndex[26] and fill the array
  * keep updating prev and max
  * when max == i:
    * add the size ( max- prev ) to result
```
public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            lastIndex[c-'a'] = i;
        }
        int max = 0;
        int prev= -1;
        List<Integer> res = new ArrayList<>();
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            max = Math.max( max, lastIndex[c-'a']);
            if ( max == i){
                res.add(max-prev);
                prev = max;
            }
        }
        return res;
}
```

## Prison Cells After N Days
* URL:
  * https://leetcode.com/explore/interview/card/amazon/82/others/3005/
* Explanation:
  * To be added
```
public int[] prisonAfterNDays(int[] cells, int n) {
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        int remaining = 0;
        int cycle = 0;
        
        while ( index < n){
            String key = Arrays.toString(cells);
            if ( map.containsKey(key) ){
                cycle = index - map.get(key);
                remaining = ( n - index ) % cycle;
                break;
            }
            map.put(key, index);
            cells = getNext(cells);
            index++;
        }
        
        while ( remaining != 0){
            cells = getNext(cells);
            remaining--;
        }
        return cells;
}
    
private int[] getNext(int[] cells){
        int[] ans = new int[cells.length];
        for ( int i=1; i<cells.length-1; i++){
            if ( cells[i-1] == cells[i+1]){
                ans[i]=1;
            }
        }
        return ans;
}
```