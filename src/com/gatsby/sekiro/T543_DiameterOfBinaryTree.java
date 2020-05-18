package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:一边dfs 一边记录状态
 * @since 2020-05-15
 */
public class T543_DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


    }

    int depth;
    int result = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        depth++;
        int l = 0, r = 0;
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int t1 = 0;
        if (root.left != null) {
            l = 1;
            t1 = diameterOfBinaryTree(root.left);
            depth--;
        }
        int t2 = 0;
        if (root.right != null) {
            r = 1;
            t2 = diameterOfBinaryTree(root.right);
            depth--;
        }
        int self = t1 + t2 + r + l;
        int containRoot = Math.max(t1, t2) + 1;
        result = Math.max(result, self);
        return depth == 1 ? Math.max(self, result) : containRoot;
    }
}
