// ===============================================================
// https://leetcode.com/problems/simplify-path/
// Input: path = "/home/"
// Output: "/home"
//
// Input: path = "/../"
// Output: "/"
//
// Input: path = "/home//foo/"
// Output: "/home/foo"
// ----------------------------------------------------------------

package HomeWork4;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Task3 {

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String[] substr = path.split("/");
        for (String subst : substr) {
            if (!subst.isEmpty()) {
                if (subst.equals(".")) {
                    continue;
                }
                if (subst.equals("..")) {
                    deque.pollLast();
                } else {
                    deque.addLast(subst);
                }
            }
        }
        if (deque.isEmpty()) {
            sb.append('/');
        }
        while (!deque.isEmpty()) {
            String st = deque.pollFirst();
            sb.append('/' + st);
        }
        return sb.toString();
    }
}
