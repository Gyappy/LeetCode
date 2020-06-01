package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-06-01
 */
public class T111_MinDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    int depth;
    int result = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        depth++;
        if (root.left == null & root.right == null) {
            result = Math.min(result, depth);
            return result;
        }
        if (root.left != null) {
            minDepth(root.left);
            depth--;
        }
        if (root.right != null) {
            minDepth(root.right);
            depth--;
        }
        return result;
    }
}
