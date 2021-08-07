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
2. Merge two sorted lists
    * Recursive approach: Base conditions: If l1 is null, return l2. If l2 is null, return l1.
    if l1.val is less than l2.val, l1 will be the head. l1.next will be the return of merge of l1.next and l2- vice versa. 
    * https://leetcode.com/submissions/detail/436004130/
    
    * Iterative approach: base conditions, create a cur pointer with -1 as val, assign it to result
    move the cur pointer based on the l1.val and l2.val. do this until l1 and l2 are not null, later cur.next will be the leftover list.
    at the end, return result.next. 
    
    * https://leetcode.com/submissions/detail/540793128/                                 