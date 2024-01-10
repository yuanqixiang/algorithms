package tree.binarytree;

import java.util.Stack;

public class SameTree {
    // 递归方法
    public boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;

        return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
    }

    // 非递归方法
    public boolean isSameTreeIteration(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()) {
            TreeNode f = stack.pop();
            TreeNode s = stack.pop();

            if(f == null && s == null) continue;
            if (f == null || s == null || f.val != s.val) return false;

            stack.push(f.left);
            stack.push(s.left);
            stack.push(f.right);
            stack.push(s.right);
        }
        return true;
    }
}
