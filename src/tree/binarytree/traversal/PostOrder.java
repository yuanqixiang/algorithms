package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class PostOrder {
    private final List<Integer> res = new ArrayList<>();

    private void helper1(TreeNode root) {
        if (root == null) return;
        helper1(root.left);
        helper1(root.right);
        res.add(root.val);
    }

    private void helper2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            TreeNode last = null;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode node = stack.peek();
                    if (node.right != null && node.right != last) {
                        cur = node.right;
                    } else {
                        res.add(node.val);
                        last = stack.pop();
                    }
                }
            }
        }
    }

    public List<Integer> postTraversal(TreeNode root) {
        helper1(root);
        //helper2(root);
        return res;
    }
}
