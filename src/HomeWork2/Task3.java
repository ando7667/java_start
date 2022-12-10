//========================================================================
// https://leetcode.com/problems/binary-tree-paths/
// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]
// Input: root = [1]
// Output: ["1"]
// рабор задачи в 4ом семинаре
// преобразование массива в дерево ->  родитель имеет в массиве индекс = parent
// тогда индекс для левого ребенка будет left = (parent-1)*2+1,
//                          для правого right = (parent-1)*2+2.
//------------------------------------------------------------------------
package HomeWork2;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        addRightChild(root.left, 5);
        System.out.println(root);
        System.out.println(binaryTreePaths(root));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void addLeftChild(TreeNode parent, int val) {
        parent.left = new TreeNode(val);
    }

    static void addRightChild(TreeNode parent, int val) {
        parent.right = new TreeNode(val);
    }

    static List<String> ans = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    // рекурсивная функция обхода дерева
    private static void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
            return;
        }

        dfs(root.left, path + root.val + "->");
        dfs(root.right, path + root.val + "->");
    }
}
