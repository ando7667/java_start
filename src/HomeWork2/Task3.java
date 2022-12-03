//========================================================================
// https://leetcode.com/problems/binary-tree-paths/
//------------------------------------------------------------------------
package HomeWork2;

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Task3 {
    public static void main(String[] args) {
        TreeNode root;
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<Integer> path = new ArrayList<>();
        List<String> pathStr = new ArrayList<>();
        dfs(root, path);
        for (int i = 0; i < path.size(); i++) {
            pathStr.add(path.get(i) + "->");
        }
        return pathStr;
    }

    private static void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        dfs(root.left, path);
        dfs(root.right, path);
    }
}