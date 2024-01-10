package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class InOrder {
    private final List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper1(root);
        // helper2(root);
        return res;
    }

    private void helper1(TreeNode root) {
        if (root == null) return;
        helper1(root.left);
        res.add(root.val);
        helper1(root.right);
    }

    private void helper2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
    }
}
