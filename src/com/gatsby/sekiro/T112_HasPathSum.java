package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-31
 */
public class T112_HasPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    boolean result;
    List<Integer> mStack = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return result;
        if (result) return true;

        mStack.add(root.val);
        if (root.left == null && root.right == null) {
            result = checkSum(sum);
        }
        if (result) return true;

        if (root.left != null) {
            hasPathSum(root.left, sum);
            if (result) return true;
            mStack.remove(mStack.size() - 1);
        }

        if (root.right != null) {
            hasPathSum(root.right, sum);
            if (result) return true;
            mStack.remove(mStack.size() - 1);
        }

        return result;
    }

    public boolean checkSum(int sum) {
        int len = mStack.size();
        int total = 0;
        for (int i = len - 1; i >= 0; i--) {
            total += mStack.get(i);
        }
        return total == sum;
    }
}
