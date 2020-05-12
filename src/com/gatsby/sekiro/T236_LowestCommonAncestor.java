package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe: dfs遍历，分两种情况
 * 1.俩target存在继承关系，那就取深度浅的那个为result
 * 2.俩target分处不同的左右子树，这时候在遍历过程中保留深度最浅的那个节点为result
 * 在dfs的时候有两种情况可以更新result变量
 * 1.当前这个节点正好是target
 * 2.只找到一个target，并且在向上回溯的时候
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
