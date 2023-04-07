package HomeWork_11;

public class LinkedList {
    Node head;

    public void addFirst(String... values) {
        for (String string : values) {
            this.addFirst(string);
        }
    }

    public void addFirst(String value) {
        Node node = new Node(value);

        if (head != null) {
            node.setNext(head);
        }

        head = node;
    }

    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public Node reverseListRecursive(Node head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null ) {
            return head;
        }
        Node node = reverseListRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }
    public void printList(Node head) {
        var item = head;
        while (item != null) {
            System.out.println(item);
            item = item.getNext();
        }

    }
}

class Node {

    private String value;
    private Node next;

    public Node(String value) {
        this.value = value;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Node next, String value) {
        this.next = next;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

