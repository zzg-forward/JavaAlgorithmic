package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 *
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 解题思路
 * 法一：递归法。求二叉树的深度，就是求左子树、右子树的中深度最大的加上一个根节点，依此递归即可。
 * 法二：层次遍历。每遍历一层，deep 加 1，直接到最后一层，输出 deep。
 *
 * 递归与层级遍历的应用
 * 层级遍历还可以应用在按层打印二叉树上
 */

public class T39TreeDeep {
    public static void main(String[] args) {

    }

    //递归遍历
    private static int getTreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeDepth1(root.left);
        int right = getTreeDepth1(root.right);
        return (left > right ? left : right) + 1;
    }

    //层级遍历
    private static int getTreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int start = 0;
        int end = 1;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            start++;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                depth++;
            }
        }
        return depth;
    }

}
