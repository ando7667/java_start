package HomeWork_11;

public class Program {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addFirst("5", "4", "3", "2", "1");

        // вывод односвязного списка
        System.out.println("исходный\nhead: " + ll.head);
        ll.printList(ll.head);

        // разворот списка через цикл
        ll.head = ll.reverseList(ll.head);

        // вывод односвязного списка
        System.out.println("\nпосле разворота\nhead: " + ll.head);
        ll.printList(ll.head);

        // разворот списка через рекурсию
        ll.head = ll.reverseListRecursive(ll.head);

        // вывод односвязного списка
        System.out.println("\nпосле разворота\nhead: " + ll.head);
        ll.printList(ll.head);

    }
}

