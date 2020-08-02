# Binary Trees

* Root:
> A node that has no parent. 

* Leaf:
> A node with no descendants. 

* Depth:
> The depth of node n is the number of nodes on the search path from the root to n, not including the n itself.

* Height:
> The height of a binary tree is the maximum depth of any node in that tree. 

* Full Binary Tree:   
> A binary tree in which every node other than the leaves has two children. 

* Perfect Binary Tree:
> A Full Binary Tree in which all leaves are at same depth. 

* Complete Binary Tree:   
> A Binary Tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. 

* A perfect binary tree of height h contains exactly 2<sup>(h+1)</sup> -1 nodes, of which 2<sup>h</sup> are leaves.  

* A complete binary tree of n nodes has height log<sub>2</sub>(n)

* Left-Skewed Tree: 
> A tree in which no node has a right child. 

* Right-Skewed Tree:
> A tree in which no node has a left child. 

### Traversals: 

* Inorder: 
> Traverse the left subtree, visit the root, then traverse the right subtree. 

* Preorder:
> Visit the root, traverse the left subtree, then traverse the right subtree.

* Postorder:
> Traverse the left subtree, traverse the right subtree, and then visit the root. 

* Time and Space Complexities:
> Let T be a binary tree of n nodes, with the height h. Implemented recursively, these traversals have O(n) time complexity and O(h) additional space complexity. 
> The space complexity is due to the maximum depth of the function call stack. 
> If each node has a parent field, then the traversal can be done with O(1) space complexity. 

