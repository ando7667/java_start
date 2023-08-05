package AlgoritmSem_4_1;

import java.util.Arrays;
import java.util.Random;

public class Tree {

    Node root;

    static class Node {
        int value;
        Node left;
        Node rigth;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.rigth = null;
        }
    }

    public Node buildTree(int[] array, int ind) {
        Node root = null;
        if (ind < array.length) {
            root = new Node(array[ind]);
            root.left = buildTree(array, 2 * ind + 1);
            root.rigth = buildTree(array, 2 * ind + 2);
        }
        return root;
    }

    public Node buildBalanceTree(int[] array, int left, int right) {
        Node root = null;
        if (left > right) {
            return null;
        } else {
            int midle = (left + right) / 2;
            root = new Node(array[midle]);
            root.left = buildBalanceTree(array, left, midle - 1);
            root.rigth = buildBalanceTree(array, midle + 1, right);
        }
        return root;
    }

    public void printTree(Node root, String sp) {
        if (root != null) {
            System.out.println(sp + root.value);
            printTree(root.left, sp + " ");
            printTree(root.rigth, sp + " ");
        }
    }

    public int high(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(high(root.left), high(root.rigth));
    }

    public boolean isBalance(Node root) {
        int i = 0;
        if (root == null) {
            return false;
        }
        i = Math.abs(high(root.left) - high(root.rigth));
        if (i > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] value = {1, 9, 2, 8, 3, 7, 4, 6, 5, 10, 20, 15, 17,31,11};
        Arrays.parallelSort(value);
        System.out.println(Arrays.toString(value));
        Tree tree = new Tree();
        tree.root = tree.buildBalanceTree(value, 0, value.length-1);
        System.out.println(tree.isBalance(tree.root));
        System.out.println("Вывод дерева\n");
        tree.printTree(tree.root, "");
    }
}

