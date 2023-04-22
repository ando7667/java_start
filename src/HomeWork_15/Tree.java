package HomeWork_15;

import java.util.Arrays;

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
            root = new Tree.Node(array[ind]);
            root.left = buildTree(array, 2 * ind + 1);
            root.rigth = buildTree(array, 2 * ind + 2);
        }
        return root;
    }

    public Tree.Node buildBalanceTree(int[] array, int left, int right) {
        Tree.Node root = null;
        if (left > right) {
            return null;
        } else {
            int midle = (left + right) / 2;
            root = new Tree.Node(array[midle]);
            root.left = buildBalanceTree(array, left, midle - 1);
            root.rigth = buildBalanceTree(array, midle + 1, right);
        }
        return root;
    }

    public void printTree(Tree.Node root, String sp) {
        if (root != null) {
            System.out.println(sp + root.value);
            printTree(root.left, sp + " ");
            printTree(root.rigth, sp + " ");
        }
    }

    public int high(Tree.Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(high(root.left), high(root.rigth));
    }

    public boolean isBalance(Tree.Node root) {
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
}

