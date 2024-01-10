package tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricRecursion(root.left, root.right);
    }

    private boolean isSymmetricRecursion(TreeNode left, TreeNode right) {
        if(left == null || right == null) return left == right;
        return left.val == right.val && isSymmetricRecursion(left.left, right.right)
                && isSymmetricRecursion(left.right, right.left);
    }

    public boolean isSymmetricIteration(TreeNode root) {
        // iterative
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelList = new ArrayList<>(size);
            for(int i = 0; i < size; ++i) {
                TreeNode q = queue.poll();
                if(q != null) {
                    queue.add(q.left);
                    queue.add(q.right);
                }
                levelList.add(q);
            }

            for(int i = 0; i < size / 2; ++i) {
                TreeNode l = levelList.get(i);
                TreeNode r = levelList.get(size - 1 - i);
                if(l == null && r == null) continue;
                if(l == null || r == null || l.val != r.val) return false;
            }
        }
        return true;
    }
}
