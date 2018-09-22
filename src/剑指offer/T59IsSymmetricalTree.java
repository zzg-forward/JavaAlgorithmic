package 剑指offer;

import java.util.Stack;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 法一：递归。根节点的左右子树相同，左子树的左子树和右子树的右子树相同，左子树的右子树和右子树的左子树相同即可。
 * 法二：非递归。非递归也是一样，采用栈或队列存取各级子树根节点。
 */

public class T59IsSymmetricalTree {
    public static void main(String[] args) {

    }

    /**
     * 递归做法
     * @param root
     * @return
     */
    private static boolean isSymmetricalTree(TreeNode root){
        if (root == null)
            return false;

        return isSymmetricalTree(root.left, root.right);
    }

    private static boolean isSymmetricalTree(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.value == right.value){
            return isSymmetricalTree(left.left, right.right) && isSymmetricalTree(left.right, right.left);
        }

        return false;
    }

    /**
     * 非递归做法
     * @param root
     * @return
     */
    private static boolean isSymmetricalTree2(TreeNode root){
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();  //栈

        stack.push(root.right);
        stack.push(root.left);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.value != right.value)
                return false;

            stack.push(right.right);
            stack.push(left.left);
            stack.push(right.left);
            stack.push(left.right);
        }
        return true;
    }

}
