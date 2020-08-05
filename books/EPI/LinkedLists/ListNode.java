package books.EPI.LinkedLists;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
