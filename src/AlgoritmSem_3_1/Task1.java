package AlgoritmSem_3_1;

/**
 * Реализуем простой односвязный список. Пишем только структуру, никаких
 * методов не требуется. Напоминаем студентам структур связного списка и что
 * односвязный список представляет собой последовательность элементов, каждый
 * из которых ссылается на следующий элемент цепочки
 */
public class Task1 {

    public static void main(String[] args) {

        MyList ml = new MyList();
/*
        ml.appendFirst("1е");
        ml.appendFirst("2е");
        ml.appendFirst("3е");
        ml.appendFirst("4е");
        ml.appendFirst("5е");
*/
        for (int i=0;i<100;i++ ) {
            ml.appendFirst("i" + i);
        }
        Node time = ml.head;
        while (time != null) {
            System.out.println(time.value);
            time = time.next;
        }
        ml.deleteFirst();
        time = ml.head;
        while (time != null) {
            System.out.println(time.value);
            time = time.next;
        }
        if ( ml.contains("i4") ) {
            System.out.println("есть");
        }else {
            System.out.println("нет");
        }

    }
}

    class MyList {
        Node head;

        public void appendFirst(String value) {
            Node n = new Node();
            n.value = value;
            if (head != null) {
                n.next = head;
            }
            head = n;
        }

        public void deleteFirst(){
            if(head != null) {
                head = head.next;
            }
        }

        public boolean contains(String text) {
            if (head != null) {
                Node time = head;
                while (time != null) {
                    if (text.equals(time.value)) {

                        return true;
                    }
                    time = time.next;
                }
            }
            return false;
        }
    }

    class Node {
        Node next;
        String value;
    }