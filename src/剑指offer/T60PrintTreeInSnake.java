package 剑指offer;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 解题思路
 * 设两个栈，s2存放奇数层，s1存放偶数层
 * 遍历s2节点的同时按照左子树、右子树的顺序加入s1，
 * 遍历s1节点的同时按照右子树、左子树的顺序加入s2
 */

import java.util.ArrayList;
import java.util.Stack;

public class T60PrintTreeInSnake {
    public static void main(String[] args) {

    }

    private static ArrayList<Integer> printTreeInSnake(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> oddStack = new Stack<>();  //奇数stack
        Stack<TreeNode> evenStack = new Stack<>(); //偶数stack

        int flag = 1;
        oddStack.push(root);

        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (flag % 2 == 1) {
                while (!oddStack.isEmpty()) {
                    TreeNode temp = oddStack.pop();
                    result.add(temp.value);
                    if (temp.left != null)
                        evenStack.push(temp.left);
                    if (temp.right != null)
                        evenStack.push(temp.right);
                }
            }

            if (flag % 2 == 0){
                while (!evenStack.isEmpty()) {
                    TreeNode temp = evenStack.pop();
                    result.add(temp.value);
                    if (temp.right != null)
                        oddStack.push(temp.right);
                    if (temp.left != null)
                        oddStack.push(temp.left);
                }
            }

            flag++;
        }

        return result;

    }

}
