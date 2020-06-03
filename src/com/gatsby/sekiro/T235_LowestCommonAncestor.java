package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-06-03
 */
public class T235_LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    TreeNode result;
    int temp;
    int depth;
    int resultDepth;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        depth++;
        if (root == p || root == q) {
            temp++;
            if (temp == 1) {
                result = root == p ? p : q;
                resultDepth = depth;
            }
        }

        if (temp == 2) {
            return result;
        }
        if (root.left != null) {
            lowestCommonAncestor(root.left, p, q);
            depth--;
            if (temp == 1 && resultDepth >= depth) {
                resultDepth = depth;
                result = root;
            }
        }
        if (root.right != null) {
            lowestCommonAncestor(root.right, p, q);
            depth--;
            if (temp == 1 && resultDepth >= depth) {
                resultDepth = depth;
                result = root;
            }
        }
        return result;
    }
}
