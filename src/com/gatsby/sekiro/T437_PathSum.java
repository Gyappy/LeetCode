package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-31
 */
public class T437_PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    int result = 0;
    List<Integer> mStack = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return result;

        mStack.add(root.val);
        result += checkSum(sum);

        if (root.left != null) {
            pathSum(root.left, sum);
            mStack.remove(mStack.size() - 1);
        }

        if (root.right != null) {
            pathSum(root.right, sum);
            mStack.remove(mStack.size() - 1);
        }

        return result;
    }

    public int checkSum(int sum) {
        int len = mStack.size();
        int total = 0;
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            total += mStack.get(i);
            if (total == sum) {
                result++;
            }
        }
        return result;
    }

}
