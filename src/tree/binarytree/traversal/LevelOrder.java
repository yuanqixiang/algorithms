package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class LevelOrder {
    private List<List<Integer>> res = new ArrayList<>();
    //方法1，采用队列，非递归
    public List<List<Integer>> levelOrder(TreeNode root) {

        helper1(root);
        //helper2(root, 0, res);
        return res;
    }

    private void helper1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>(size);
                for (int i = 0; i < size; ++i) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(list);
            }
        }
    }

    /**
     * 方法2，采用递归, 相当于前序遍历
     * @param root
     * @param rootLevel
     * @param res
     */
    public void helper2(TreeNode root, int rootLevel, List<List<Integer>> res) {
        if (root != null) {
            if (rootLevel == res.size()) {
                List<Integer> list = new ArrayList<>();
                res.add(list);
            }

            List<Integer> curr = res.get(rootLevel);
            curr.add(root.val);

            helper2(root.left,  rootLevel + 1, res);
            helper2(root.right,  rootLevel + 1, res);
        }

    }
}
