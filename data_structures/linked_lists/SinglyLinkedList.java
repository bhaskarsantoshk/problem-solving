package data_structures.linked_lists;

public class SinglyLinkedList<T> {
    public class Node {
        public T data;
        public Node next;

    }
    public Node head;
    public int size;

    //constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {

        if (head == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's next
        newNode.next = head;
        head = newNode;
        size++;
    }

    //Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
        //if the list is empty then call insertATHead()
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        Node last = head;
        //iterate to the last element
        while (last.next != null) {
            last = last.next;
        }
        //make newNode the next element of the last node
        last.next = newNode;
        size++;
    }

    //inserts data after the given prev data node
    public void insertAfter(T data, T previous) {

        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        //Start from head node
        Node cur = this.head;
        //traverse the list until node having data equal to previous is found
        while (cur != null && cur.data != previous) {
            cur = cur.next;
        }
        //if such a node was found
        //then point our newNode to cur's nextElement
        if (cur != null) {
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = head;
        System.out.print("List : ");

        while (temp.next != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.next;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    //Searches a value in the given list.
    public boolean searchNode(T data) {
        //Start from first element
        Node cur = this.head;

        //Traverse the list till you reach end
        while (cur != null) {
            if (cur.data.equals(data))
                return true; //value found

            cur = cur.next;
        }
        return false; //value not found
    }

    //Deletes data from the head of list
    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the next of the head equal to new head
        head = head.next;
        size--;
    }

    //Deletes data given from the linked list
    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node cur = this.head;
        Node prev = null; //previous node starts from null

        if(cur.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (cur != null) {
            //node to delete is found
            if (data.equals(cur.data)){
                prev.next = cur.next;
                size--;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}
