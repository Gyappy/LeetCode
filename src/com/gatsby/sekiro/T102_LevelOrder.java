package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guchenhui
 * @Describe:
 * @since 2020-06-01
 */
public class T102_LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;
        List<Integer> list = new ArrayList<>();

        List<TreeNode> mQueue = new ArrayList<>();
        mQueue.add(root);

        int p = 0;
        int obj = 1;
        int t = 0;
        int level = 0;
        while (p <= mQueue.size() - 1) {
            list.add(mQueue.get(p).val);
            t++;

            if (mQueue.get(p).left != null) {
                mQueue.add(mQueue.get(p).left);
                level++;
            }
            if (mQueue.get(p).right != null) {
                mQueue.add(mQueue.get(p).right);
                level++;
            }
            if (t == obj) {
                obj = level;
                t = 0;
                level = 0;
                result.add(list);
                list = new ArrayList<>();
            }
            p++;
        }
        return result;
    }

}
