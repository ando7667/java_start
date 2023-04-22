package HomeWork_15;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        int[] value = {1, 9, 2, 8, 3, 7, 4, 6, 5, 10, 20, 15, 17, 31, 11};
        Arrays.parallelSort(value);
        System.out.println(Arrays.toString(value));
        Tree tree = new Tree();
        // строим сбалансированное дерево из массива value
        tree.root = tree.buildBalanceTree(value, 0, value.length - 1);
        System.out.println(tree.isBalance(tree.root));
        // вывод сбалансированного дерева в консоль
        System.out.println("Сбалансированное дерево:");
        tree.printTree(tree.root, "");

        // создаем красно-черное дерево
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(1);
        rbt.insert(3);
        rbt.insert(15);
        rbt.insert(6);
        rbt.insert(5);
        rbt.insert(25);
        rbt.insert(27);
        rbt.insert(2);
        rbt.insert(7);
        rbt.insert(19);
        // вывод красно-черного дерева в консоль
        System.out.println("красно-черное дерево:");
        rbt.printTree(rbt.getRoot(), " ");
    }

}
