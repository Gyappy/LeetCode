package com.gatsby.sekiro;

/**
 * @author guchenhui
 * @Describe: 在一个有序二叉树上找到最小的差值   中序遍历逐个对比属于easy题  如果用模拟来硬钢 就是hard题
 * @since 2020-05-30
 */
public class T783_MinDiffInBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int result = Integer.MAX_VALUE;
    int tempVal;
    boolean f;

    public int minDiffInBST(TreeNode root) {
        if (result == 1) {
            return result;
        }
        if (root == null) return result;
        minDiffInBST(root.left);
        if (!f) {
            f = true;
            tempVal = root.val;
        } else {
            result = Math.min(result, Math.abs(tempVal - root.val));
            tempVal = root.val;
        }
        minDiffInBST(root.right);
        return result;
    }

}
