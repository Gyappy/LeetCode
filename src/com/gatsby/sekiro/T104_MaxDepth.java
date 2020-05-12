package com.gatsby.sekiro;

import com.gatsby.Main;

/**
 * @author guchenhui
 * @Describe: 求最大深度  直接暴力dfs
 * @since 2020-05-12
 */
public class T104_MaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int resultDepth;
    int depth;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        depth++;
        resultDepth = resultDepth < depth ? depth : resultDepth;
        if (root.left != null) {
            maxDepth(root.left);
            depth--;
        }
        if (root.right != null) {
            maxDepth(root.right);
            depth--;
        }
        return resultDepth;
    }
}
