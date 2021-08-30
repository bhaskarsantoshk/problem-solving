# Leetcode Top Interview Questions Easy

1. Remove Duplicates From Sorted Array:  

    >   First element will be present at index 0, then you compare from i=1 till the length of the array. If nums[i] != nums[i-1], then you add to nums[index] and increment index.                                    
2. Best Time to Buy and Sell Stock II
    >   It involves as many transactions as you can. whenever price of day i is greater than day i-1, add the difference to profit. 
3. Rotate Array
    > right rotation and k is non negative integer. k = k % length. do the following operations: reverse(nums, 0, len); reverse(nums, 0, k-1); reverse(nums, k, len);
4. Contains Duplicate
    > Sort the array. Check if nums[i] == nums[i+1]
5. Single Number
    > Do an XOR of all
6. Intersection of Two Arrays II
    > Use HashMap, add the intersection to array list 
7. Plus one 
    > traverse the array, when you encounter a number < 9, increment the number by one and return. else number will be 0 and continue. at the end, create a result array with length one more than the previous, make the first digit 1 and return.                        
8. Move Zeroes
    > index = 0, when you encounter a non zero number, a[index++] = number, at the end mark all numbers from index to length as 0. 
9. Two Sum
    > Use HashMap<Number, Index> 
10. Valid  Sudoku

11. Rotate Image

12. Reverse String
    > start and end approach
13. Reverse Integer

14. First Unique Character in a String

15. Valid Anagram
    > Take 26 character array, a[c-'a']++ for array a, a[c-'a']-- for array b. Check if there are no non zero elements in the end
16. Valid Palindrome
    > Write a method that checks for only alpha numeric, and use start and end way to check if the string is a palindrome.
18. Implement strStr
    > Brute Force
19. Longest Common Prefix
    > Take the first string, check if all the other strings contain this part - if not reduce suffix by one character while traversing. 
20. Delete Node in a Linked List
    > if the node is null, return. if node.next is null, make node = null and return. else node.data = node.next.data, node.next = node.next.next
21. Remove Nth Node From End of List
    > travese fast node from head till length n, now start slow(at head or before one dummy node) and fast until fast reaches null. delete the link at slow. return head.     
22. Reversed Linked List
    > 
40. FizzBuzz
    > First check will be divisible by both
50. Missing Number
    > XOR of all numbers and then xor with 1 to n
51.    

# Leetcode Amazon Interview Questions

###Sources:

* https://leetcode.com/discuss/study-guide/1149636/Amazon-LPs-Compiled
* https://leetcode.com/discuss/interview-experience/1148076/amazon-sde2-bangalore-april-2021-offer-repost
* [Amazon Final Interview Questions | SDE1](https://leetcode.com/discuss/interview-question/488887/Amazon-Final-Interview-Questions-or-SDE1)
* []
### Problems

0. Merge two sorted lists
       * Recursive approach: Base conditions: If l1 is null, return l2. If l2 is null, return l1.
       if l1.val is less than l2.val, l1 will be the head. l1.next will be the return of merge of l1.next and l2- vice versa. 
       * https://leetcode.com/submissions/detail/436004130/
       
       * Iterative approach: base conditions, create a cur pointer with -1 as val, assign it to result
       move the cur pointer based on the l1.val and l2.val. do this until l1 and l2 are not null, later cur.next will be the leftover list.
       at the end, return result.next. 
       
       * https://leetcode.com/submissions/detail/540793128/   
1. Two Sum
    * use Map to store index as key and value as number, for each number check if target - num exists. if yes, return res [map.get(target-num), current index]
2. Median of two sorted arrays
    * Do a binary search on the smaller array to find a partition point such that 
    every element on the left side is less than or equal to every element on the right side for two arrays
    * [explanation](https://www.youtube.com/watch?v=LPFhl65R7ww)
3. Longest Palindromic Substring
    * Approach 1: O ( N^2 ): Create a 2 d array, row will be start , column will be end of string. 
    fill the diagonal i.e single length palindromes, the diagonal above the main one will be two length palindromes
    the fill the table for length more than 3, keep track of max length and sub string.
4. String to Integer (atoi)
    * First check for empty string, trim both trailing and ending spaces, 
    calculate sign
    check until you get digits, keep calculating the number while checking overflow, 
    if overflow , return INT_MAX/MIN based on the sign.
5. Integer to Roman 
    * Have a string array of roman numbers for 1000,900,500,400,100,90,50,40,10,9,5,4,1
    * 900,400, 90, 40, 4 - because these are exceptions
    * Remember L C D M for 50,100,500,1000
    * Loop through the above numbers in descending order,Append roman strings to result for the respective values while dedcuting the value
    * If the number is less, move to next value 
6. Roman to Integer
    * Store I,V,X,L,C,D,M and their respective values in a map
    * Store A with 0
    * initially assign A to prev. Iterate through all roman chars in the string left to right, if map.get(c) is greater than map.get(prev), sum -= 2* map.get(c)
    * add map.get(c) to sum, prev = c.
    * reason for deducting twice is because we are adding blindly the value in next step.
7. Valid Parentheses 
    * Create a stack, iterate through all characters, for each open bracket - push the respective closed bracket.
    * For every closed bracket , check if stack is not empty and popped value is matching else return false
    * at the end, return true if stack is empty.
8. Merge k Sorted Lists
    * Create a MinHeap with size equal to length of the lists. 
    * Add all the first nodes of lists.
    * Create the res pointer and cur pointer, For each poll, add the next elements. 
    * return res.next
9. Valid Sudoku
    * Create a HashSet 
    * iterate through rows and cols, check if we already added a num in same row(i)/col(j)/grid (i/3+" "+j/3)
10. Combination Sum
    * backtracking 
    * create a res, temp list, start as 0, remaining as target
    * inside backtrack, see if remain is 0, then add list to res. if rem is less than 0, return.
    * loop through start to length of nums, each time remove cand[i] from rem.
11. Permutations
    * backtracking
    * base condition is when start >= len, swap, backtrack, swap
12. Merge Intervals
    * sort the intervals based on first element
    * create a list of arrays, add the first array. compare every new array's 2nd element with the 1st elemnt of the array before.
    * if it's more, merge. else add the new interval to res. 
13. Rotate List
    * create res (res.next = head) , slow and fast. Find len (fast), find the the node before rotation ( len - k%len) (slow)
    * rotate - fast.next = res.next
    * res.next = slow.next ( modified head)
    * slow.next = null // cut the cycle
14. Minimum Path Sum
    Approach 1:
    * call recursive function on height-1, width-1 i.e bottom right cell
    * base case is 0,0
    * recusrive function gets called on row 0, col 0 or non zero row and col. 
15. Word Search
    * for each character in the cell, call a rec function on 4 directions once the first character matches
    * base condition will be when the index matches word length or if i and j are out of boundaries    
    DP: 
    * Bottom up
    * if row == 0 and col == 0, continue
    * fill zeroth row and zeroth column straight away by adding prev cell vcalue
    * fill non zeroth row and col by adding min of top and left cell value.
    * return the last cell ( bottom right) 
16. Validate Binary Search Tree
    * Approach 1: Recursive.
    * Make a rec call with root, long.min and long.max
    * base case is when root is null ( return true ) 
    * if root.val is less than or equal to long.min or greater than or equal to long.max - return false
    * recurive call on root.left, long.min , root.val && root.right, root.val , long.max
    
    * Approach 2: Iterative
    
    [Learn Iterative way of Inorder traversal and tackle several tree problems.](https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)) 
    
    * follow iterative inorder way, before going for root.right, check if pre is not null , if yes, check if root.val <= pre.val - return false
17. Same Tree
    * Approach 1: Recursion
    * base cases: if p is null or q is null, return p is null && q is null.
    * p.val == q.val && call rec on p.left, q.left && p.right && q.right
    
    * Approach 2: Iterative
    * Use a Queue. add p and q.
    * while q is empty, poll two nodes, and check if the values are equal. add f.left, s.left and f.right s.right to queue.
18. Symmetric Tree
    * Approach 1: Recursive
        * Call rec on left and right sub trees
        * s.val == t.val && isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left)
    * Approach 2: Iterative
        * Use a Queue. add p and q.
       * while q is empty, poll two nodes, and check if the values are equal. add f.left, s.right and f.right s.left to queue.                        
19. Binary Tree Level Order Traversal
    * Create a List<List>
    * Create a Queue, add root
    * while queue is not empty, loop through queue size (also level size), add val of popped node to temp list, add left and right of popped node to queue
    * each time loop ends, add temp list to res

20. Convert Sorted List to Binary Search Tree
    * Use Recursion, pass the head and null in main call
    * find the mid point, create the root, call rec function on root.left = rec(head, mid), root.right = rec(mid.next, tail)
    * return root
21. Populating Next Right Pointers in Each Node
    * The gist is to connect all nodes by moving to each level
    * Call a helper function with root which will connect the nodes
    * start = root, while start is not null, cur = start, 
        * while cur is not null, 
            * check if cur.left is not null, if yes, cur.left.next = cur.right
            * check if cur.right is not null and cur.next is not null, if yes, cur.right.next = cur.next.left
            * move cur to cur.next
        * move start to start.left (i.e next level)

22. Best Time to Buy and Sell Stock
    * Use Kadane algorithm
    * initially minPrice = prices[0], maxProfit = 0
    * keep track of minPrice and maxProfit through i = 1 to N
    * return maxProfit
23. Word Ladder II
    * Pre-requisite : Word Ladder I
    * calculate nodeNeighbors , distanceFromBeginWord using BFS
    * Use DFS to calculate the solution
    * see the solution if you can't recall / solve
24. Word Ladder I
    * BFS is the main algorithm
    * Create a Set with all the words given in the list
    * Create a set to go by each level. first level will have only beginWord.
    * distance = 1
    * For all words in the level: 
        * create a set to store next level words
        * from str[] i 0 till n:
            * from c 'a' to 'z':
                * form a string with str[i] = c
                * check if it's part of dictionary, if yes, add to nextLevel set
        * if next level is empty, return 0
        * distance++
        * level = nextLevel
    * return distance
25. LRU Cache
    * Initial setup: Constructor, put and get methods
    * member variables: HashTable (cache) with integer (key), DLL as value, count (size), capacity (max size).
    * two DLL Nodes head, tail
    
26. Min Stack  
    * Using a Linked List
    * operations: push, pop, top, getMin
    * Create a Node with val, min and Next.
    * For push, append node at the front. 
        *  head = new Node(val, Math.min(val, head.min), head) if head is not null)
        * head = new Node(val, val, null) if head is null
    * pop() : head = head.next
    * top() : return head.val
    * getMin() : return head.min

27. Number of Islands
    * go through each char on the grid, if you find '1', call DFS , increase num of Islands 
    * dfs(): check for boundary conditions, mark grid[i][j] = '0', call dfs on all 4 directions
    * return num of islands
28. Course Schedule
    * Create a Graph  ( an array of array lists )
    * degree of each nodes  
    * add all independent courses to queue ( i.e degree of course is 0)
    * completedCoursess =0, this keeps track of each completed course
    * now while queue is not empty:
        * take out a course, completedCourses++, get each connected course and see if the degree is 0, which means it can be completed, so add to queue
    * return completedCourses == numOfCourses ( boolean )
29. Course Schedule II
    * Create a Graph  ( an array of array lists )
    * degree of each nodes  
    * add all independent courses to queue ( i.e degree of course is 0)
    * create res[] with size numOfCourses
    * completedCoursess =0, this keeps track of each completed course
    * now while queue is not empty:
        * take out a course, res[completedCourses] = course, completedCourses++, get each connected course and see if the degree is 0, which means it can be completed, so add to queue
    * return completedCourses == numOfCourses ? res: new int[0]
30. Add and Search Word - Data structure design
    * Create a TrieNode class with member varaibles - children (= new TrieNode[26]), isWord = false;
    * Add word : assign node = root, 
        * go through each char, 
            * if there is no trieNode within node's children, if it's null, create one
            * move node to node.children[c-'a]
            * at the end of loop, node.isWord = true
        * Search :
            * call match(word.toCharArray(), 0, root)
            * if index == len, return node.isWord
            * if word[index] == '.'
                * Go through all children of node, and see if node.children[i] != null and match(,index+1,) is true:
                    * return true
            * else: return node.children[c-'a'] != null && match (,index+1,) 
            * return false at the end

31.

32.

33.

34. Find Median from Data Stream
    * Median will likely between max of lower half and min of upper half
    * store lower values in minHeap and higher values in maxHeap
    * Solution:
        * initalize min and max heap
        * store num in maxHeap if it's empty or maxHeap.poll() > num ( this means we are storing lower values)
        * else store in minHeap
        * if you see any of min or max heap size is greater than +1 of the other, poll one num and add it
        * the above step is to make sure both will have same size or only a gap of 1.
        * at the end if maxHeap size is high , return maxHeap.peek() else if - vice -versa
        * if both are equal , return (peek+peek)/2.0
35. Longest Increasing Subsequence
    * create a lis[] array
    * fill 1 since all elements are lis of size 1
    * initialize max with 1
    * traverse each element:
        * traverse all it's prev elements to update lis
        * keep track of max
    * return max

36.

37.

38.

39. Diameter of Binary Tree
    * Use maxDepth approach
    * while calculating maxDepth of each node, update max ( = Math.max(left+right, max), where left and right are maxDepths)
    * by definition, Diameter is the max num of edges between two nodes,not the num of nodes hence we are not adding a +1
    * maxDepth = num of nodes until it's leaf ( Math.max (left, right) + 1)
    
40. Reorganize String
    * create a hash[26]
    * Find maxRepeatedLetter and it's count, if count > (len+1)/2, return ""
    * create a res[len of string]
    * update index=0 to count ( index+=2)
    * update each character at index (index+=2, if index reaches max, index=1)
         

