package 剑指offer;

import java.util.LinkedList;

/**
 * 把二叉树打印成多行
 *
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 解题思路
 * 就是二叉树的层序遍历，用队列来实现。我们需要两个变量，一个start记录当前层已经打印的节点个数，一个end记录前当层所有的节点个数，当 start == end 时，表时当前层遍历完了，就可以开始下一层遍历。
 *
 */

public class PrintTreeFromTopToBottomInLine {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        p1.left = p2;
        p1.right = p6;
        p2.left = p3;
        p3.right = p4;
        p4.left = p5;
        printTreeFromTop(p1);
    }

    private static void printTreeFromTop(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int current = 0;
        int total = 1;
        while (!nodeList.isEmpty()) {
                TreeNode temp = nodeList.poll();  //移除list
                System.out.print(temp.value + "\t");
                current += 1;
                if (temp.left != null) {
                    nodeList.add(temp.left);
                }
                if (temp.right != null) {
                    nodeList.add(temp.right);
                }
            if (current == total) {
                System.out.println();
                current = 0;
                total = nodeList.size();      //这是关键的一步
            }
        }
    }
}
