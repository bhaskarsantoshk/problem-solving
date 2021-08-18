## Collection

#### Difference between Collection and Collections?
* Collection is an interface, Collections is a  class.
* Collection interface provides a standard functionality of a data structure to List, Set and Queue.
Collections class provide the utility methods that can be used to search, sort and synchronize collection elements.

#### ArrayList
* Implementation of List interface.
* Elements are stored in order of insertion. 
* allows duplicate and null elements. 
* Internal implementation: when an array list is created, an array of size zero is created. 
when first element is inserted,the size changes to 10. 
when the array is full, a new array with n+n/2+1 is created. 
* Time complexities: adding an element : O(1), Removing an element: O(n)
* Creating an Array List
    
    `List list = new ArrayList();`
    
    `List list = new ArrayList(20);`
    
    `List list = new ArrayList(oldList);`
    
* Inserting operations:
    * adding at the end: `add (E element)`
    * adding at an index: `add(int index, E element) # throws IndexOutOfBoundsException if index is less than 0 or greater than size`
    * inserting elements from another Collection: 
    `list.addAll (anotherList)`
    `list.addAll (index, anotherList)`
    
* Fetch operations:
    * to fetch: `get(int index)`
    * to get size: `list.size()`
    
* Remove operations:
    * to remove an element at an index: `remove(int index) # throws IndexOutOfBoundsException if index is less than 0 or greater than size`
    * to remove an element: `remove(Object o)`
    * to remove range : `removeRange(int fromIndex, int toIndex)`
    * to remove all elements of a collection: `removeAll(Collection<?> c)`
    * to remove all elements of array list: `clear()`

* Replacing operations:
    * to replace all: `replaceAll(UnaryOperator<E> operator)`
    * to update an element: `set(int index, E e)`
* Lookup:
    * to check if an element exists: `contains(Object o)`
    * to search an element: `indexOf(Object o), lastIndexOf(Object o)`
    

    