# Technical Interview Questions and Answers

## Question 1
**What's the best/worst running time for Merge Sort?**
- **Best and Worst Case:** \(O(n \log n)\)
- **Explanation:** Merge Sort always divides the list into two halves and then merges them back together in sorted order. This divide-and-conquer approach results in a consistent time complexity of \(O(n \log n)\) in all cases.

## Question 2
**What's the average/worst running time for Quick Sort?**
- **Average Case:** \(O(n \log n)\)
- **Worst Case:** \(O(n^2)\)
- **Explanation:** Quick Sort works by selecting a 'pivot' element and partitioning the array around the pivot. In the average case, it performs well with \(O(n \log n)\) complexity. However, if the pivot selection is poor (e.g., always the smallest or largest element), it can degrade to \(O(n^2)\).

## Question 3
**What's the worst running time for a lookup in a Hashtable?**
- **Worst Case:** \(O(n)\)
- **Explanation:** In a Hashtable, the average time complexity for lookup is \(O(1)\) due to hashing. However, in the worst case, if many collisions occur and all elements hash to the same bucket, it can degrade to \(O(n)\) as it would need to traverse the linked list in that bucket.

## Question 4
**Could you name an implementation of a Hashtable?**
- **Example:** Java's `HashMap`, Python's built-in `dict`.
- **Explanation:** These implementations use hash functions to map keys to values efficiently, providing average-case constant time complexity for lookups, insertions, and deletions.

## Question 5
**Which of the following Python data structures is not mutable: tuple, list, dictionary?**
- **Answer:** Tuple
- **Explanation:** In Python, a tuple is an immutable data structure, meaning its elements cannot be changed after creation. In contrast, lists and dictionaries are mutable and can be modified.

## Question 6
**For an unweighted graph, which algorithm should be used to find the shortest path: breadth-first search (BFS) or Dijkstra's?**
- **Answer:** Breadth-first search (BFS)
- **Explanation:** For unweighted graphs, BFS is the most appropriate algorithm to find the shortest path as it explores all neighbors at the present depth level before moving on to nodes at the next depth level, ensuring the shortest path is found.

## Question 7
**Could you estimate \(2^{24}\)?**
- **Answer:** \(2^{24} \approx 16.7 \times 10^6\) or approximately 16 million.
- **Explanation:** \(2^{24}\) is calculated as \(2 \times 2 \times 2 \times \ldots\) (24 times), which results in a value close to 16.7 million.

## Question 8
**In Java, could you name two Map implementations?**
- **Examples:** `HashMap`, `TreeMap`
- **Explanation:** `HashMap` is a hash table-based implementation of the `Map` interface, providing constant time performance for basic operations. `TreeMap` is a Red-Black tree-based implementation that maintains sorted order of keys and provides logarithmic time complexity for the basic operations.
