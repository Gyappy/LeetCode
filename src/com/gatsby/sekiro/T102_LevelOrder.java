package com.gatsby.sekiro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guchenhui
 * @Describe: 正经做法是用双队列，在bfs是过程中判断出具体的"层"。 我这边用的是模拟计数的方法，可以减少代码量。
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
        int obj = 1;//当前这层需要访问的节点数量
        int t = 0;//对于obj目标数的计数变量
        int level = 0;//在逐个访问obj目标数的节点的过程中，会累加level，做为下一层的目标数next obj。
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
