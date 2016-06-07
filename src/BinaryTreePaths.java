import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmitriiiermiichuk on 6/6/16.
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n9 = new TreeNode(9);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n6.left = n7;
        n6.right = n5;

        n5.left = n4;
        n5.right = n8;

        n8.left = n9;
        n8.right = n10;

        n4.left = n3;
        n4.right = n2;

        n2.left = n1;

        System.out.println(new BinaryTreePaths().binaryTreePaths(n6));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<String> res = new ArrayList<>();
        String path = root.val + "";
        findPath(root, path, res);

        return res;
    }

    public void findPath(TreeNode node, String path, List<String> res) {
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        if (node.left != null) findPath(node.left, path + "->" + node.left.val, res);
        if (node.right != null) findPath(node.right, path + "->" + node.right.val, res);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
