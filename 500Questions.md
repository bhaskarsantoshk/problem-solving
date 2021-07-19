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