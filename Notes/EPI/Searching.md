# Searching

## Searching Libraries: 

* To search an array, use `Arrays.binarySearch(A,"Euler")`. The time complexity is O(Log N), where N is the length of the array. 

* To search a sorted List-type object, use `Collections.binarySearch(list, 42)`. These return the index of the searched key if it's present, and a negative value if it's not present.

* The time complexity depends on the nature of list implementation. Fir list implementation with constant time positional access, it is O (Log N), and for Linkedlist, it is O(N). 

* When there are multiple occurences of search key, neither Arrays nor Collections guarantee which one will be found by binary search.

* If the search key is not present, both methods would return `(-(insertion point) - 1)`, where insertion point is defined as the point at which the key would be inserted into the array, i.e. , 
the index of the first element greater than the key, or the number of elements if all elements are less than the specified value. 
