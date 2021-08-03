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
* Iterator
    * If we try removing an element from list while iterating, it will throw ConcurrentModificationException
    * To avoid the exception, we need to use remove() method in iterator.
    * If we add an element to the ArrayList after the iterator is created then also ConcurrentModificationException will be thrown.    
#### List Iterator
* The `listIterator()` method returns an object of type ListIterator which can then be used to iterate the ArrayList.
* Methods in ListIterator interface:
    * hasNext()
    * next()
    * hasPrevious()
    * previous()
    * nextIndex()
    * previousIndex()
    * remove() 
    * set(E e)
    * add(E e)

#### Sorting
* `Collections.sort(list)`
* `list.stream().sorted().collect(Collectors.toList())`
* `Collections.sort(list, Collections.reverseOrder())`
* `list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())`

#### Comparable Interface
* Each wrapper class(Integer, Double, or Long), String class, and Date class implements an interface called Comparable.

### LinkedList 
* Implements List and Deque interface
* Elements are stored in order of insertion. 
* allows duplicate and null elements.
* Internal Implementation:
    * The LinkedList class has a static inner class called Node. 
    * This class contains three fields: 
        * item (value of current element)
        * next
        * prev
    * When a node at index i is removed, the next field of node at index i-1 is set to the node at index i+1. 
    Similarly, the prev field of node at index i+1 is set to node i-1.
    
    * Time complexities: 
        * adding an element: O(1)
        * removing an element: O(1)
        * searching an element : O(1)
    * Creating a LinkedList:
        * `List<Integer> list = new LinkedList<>()`
        * `List<Integer> list = new LinkedList<>(oldList)`
    * Inserting an element:
        * `add (E e)` or `addLast(E e)` inserts at the end of list.
        * `addFirst(E e)` inserts at the beginning
        * `add(int index, E element)` inserts at the particular index.
        * `list.addAll(anotherList)` inserts multiple elements from another collection at the end
        * `addAll(int index, Collection c)` inserts multiple elements from another collection at the particular index
        