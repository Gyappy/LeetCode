package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-31
 */
public class T94_InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
