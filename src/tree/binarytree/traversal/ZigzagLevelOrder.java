package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class ZigzagLevelOrder {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int rootLevel, List<List<Integer>> res) {
        if (root == null) return;
        if (rootLevel == res.size()) {
            List<Integer> list = new LinkedList<>();
            res.add(list);
        }

        List<Integer> curr = res.get(rootLevel);
        if (rootLevel % 2 == 1) {
            curr.add(0, root.val);
        }
        else {
            curr.add(root.val);
        }

        helper(root.left,  rootLevel + 1, res);
        helper(root.right,  rootLevel + 1, res);
    }
}
