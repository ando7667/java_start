// ==================================================================================
// https://leetcode.com/problems/simplify-path/
//
// ----------------------------------------------------------------------------------

package Seminar4;

import java.util.Deque;
import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) {
        //abc/foo/bar
        Deque<String> deque = new LinkedList<>();
        deque.addLast("abc");
        deque.addLast("foo");
        deque.addLast("bar");

        // если две точки, то удалить последний введенный элемент
        deque.pollLast();

        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
        }

    }
}
