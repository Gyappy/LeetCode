package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-05-11
 */

public class T236_LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    TreeNode parent;
    int findCount = 0;
    int findDepth = 0;
    int depth = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        depth++;
        if (findCount == 2) {
            return parent;
        }
        if (root == p || root == q) {
            findCount++;
            if (findCount < 2) {
                parent = root;
                findDepth = depth;
            }
        }
        if (root.left != null) {
            lowestCommonAncestor(root.left, p, q);
            depth--;
            if (findCount < 2 && depth < findDepth) {
                parent = root;
                findDepth = depth;
            }
        }
        if (root.right != null) {
            lowestCommonAncestor(root.right, p, q);
            depth--;
            if (findCount < 2 && depth < findDepth) {
                parent = root;
                findDepth = depth;
            }
        }
        return parent;
    }

}
