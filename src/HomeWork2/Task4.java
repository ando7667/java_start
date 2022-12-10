//========================================================================
// https://leetcode.com/problems/same-tree/
// попытаться одновременно обойти два дерева
// рабор задачи в 4ом семинаре
//------------------------------------------------------------------------
package HomeWork2;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {

        Task3.TreeNode p = new Task3.TreeNode(1, new Task3.TreeNode(2),new Task3.TreeNode(3));
        Task3.TreeNode q = new Task3.TreeNode(1, new Task3.TreeNode(2),new Task3.TreeNode(4));

        if (isSameTree(p,q)) {
            System.out.println("деревья идентичны");
        } else {
            System.out.println("деревья разные");
        }
    }

    public static boolean isSameTree(Task3.TreeNode p, Task3.TreeNode q) {
        // для варианта когда у соответствующих нод деревьев p и q нет потомков, т.е. обошли деревья
        if (p == null && q == null) {
            return true;
        }

        // вариант, когда закончился обход одного из деревьев
        if (p == null || q == null) {
            return false;
        }

        // если соответствующие ноды не равны
        if (p.val != q.val) {
            return false;
        }

        // рекурсивно вызываем проверку соответствия потомков для правой и левой частей деревьев
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}