package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtils {
    //[1,null,2,3]
    public static TreeNode construct(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();

        boolean left = true;
        TreeNode curr = null;
        queue.add(root);

        for (int i = 1; i < array.length; ++i) {
            TreeNode node = null;
            if (array[i] != null) {
                node = new TreeNode(array[i]);
                queue.add(node);
            }

            if (left) {
                curr = queue.poll();
                curr.left = node;
                left = false;
            }
            else {
                curr.right = node;
                left = true;
            }
        }

        return root;
    }
}
