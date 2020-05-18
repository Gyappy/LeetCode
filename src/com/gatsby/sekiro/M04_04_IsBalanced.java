package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-18
 */
public class M04_04_IsBalanced {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root != null)
            checkBalanced(root);
        return result;
    }

    public int checkBalanced(TreeNode root) {
        if (!result) return 0;
        int left = 0, right = 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left != null) {
            left = checkBalanced(root.left);
        }
        if (root.right != null) {
            right = checkBalanced(root.right);
        }
        if (Math.abs(left - right) > 1) {
            result = false;
            return 0;
        }
        return Math.max(left, right) + 1;
    }

}
