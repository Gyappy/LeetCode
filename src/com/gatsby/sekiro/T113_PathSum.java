package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-31
 */
public class T113_PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> mStack = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return result;

        mStack.add(root.val);
        if (root.left == null && root.right == null) {
            checkSum(sum);
        }

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

    public void checkSum(int sum) {
        int len = mStack.size();
        int total = 0;
        for (int i = len - 1; i >= 0; i--) {
            total += mStack.get(i);
        }
        if (total == sum) {
            result.add((List<Integer>) mStack.clone());
        }
    }

}
