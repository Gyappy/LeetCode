package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-31
 */
public class T257_BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    List<String> result = new ArrayList<>();
    ArrayList<Integer> mStack = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;

        mStack.add(root.val);
        if (root.left == null && root.right == null) {
            checkPath();
        }

        if (root.left != null) {
            binaryTreePaths(root.left);
            mStack.remove(mStack.size() - 1);
        }

        if (root.right != null) {
            binaryTreePaths(root.right);
            mStack.remove(mStack.size() - 1);
        }

        return result;
    }

    public void checkPath() {
        String s = "";
        for (int i = 0; i < mStack.size() - 1; i++) {
            s += mStack.get(i) + "->";
        }
        s += mStack.get(mStack.size() - 1) + "";
        result.add(s);
    }

}
