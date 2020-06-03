package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-06-03
 */
public class T173_BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    List<TreeNode> treeNodeList = new ArrayList<>();

    public T173_BSTIterator(TreeNode root) {
        dfsTree(root);
    }

    private void dfsTree(TreeNode root) {
        if(root==null) return;
        if (root.left == null && root.right == null) {
            treeNodeList.add(root);
            return;
        }
        if (root.left != null) {
            dfsTree(root.left);
        }
        treeNodeList.add(root);
        if (root.right != null) {
            dfsTree(root.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (treeNodeList.get(0) == null) return 0;
        int result = treeNodeList.get(0).val;
        treeNodeList.remove(0);
        return result;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !treeNodeList.isEmpty();
    }
}
