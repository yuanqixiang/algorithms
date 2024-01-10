package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class PreOrder {
    private final List<Integer> res = new ArrayList<>();

    private void helper1(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper1(root.left);
        helper1(root.right);
    }

    public List<Integer> preTraversal(TreeNode root) {
        helper1(root);
        //helper2(root);
        return res;
    }

    private void helper2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;

        if (root != null) {
            stack.push(root);
            while (!stack.empty()) {
                cur = stack.pop();
                res.add(cur.val);

                //注意先后顺序，因为栈是先进后出的结构，而前序遍历，是当前-左-右的顺序遍历，所以右子树先进栈。
                if(root.right != null) stack.push(root.right);
                if(root.left != null) stack.push(root.left);
            }
        }
    }
}
